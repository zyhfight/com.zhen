package com.zhen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhen.extra.BarcodeFactory;
import com.zhen.extra.ChineseToEnglish2;
import com.zhen.model.QRCodeModel;
import com.zhen.utils.ErrorCorrectLevel;
import com.zhen.utils.GIFImage;
import com.zhen.utils.Image2Base64;
import com.zhen.utils.QRCode;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhenyonghe on 2017/5/3.
 */
@Controller
@RequestMapping("/qr_code")
public class QRCodeController {

    @RequestMapping(value = "/upload_file")
    public @ResponseBody
    Map<String, Object> UploadProcessor(HttpServletRequest request, QRCodeModel qrCodeModel) throws IOException {

        System.out.println(qrCodeModel);

        String outType = qrCodeModel.getOutType();
        String text = qrCodeModel.getText();

        Map<String, Object> map = new HashMap<String, Object>();

        String[] strings = text.split("%%");

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        int number = 0;

        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String originalFilename = file.getOriginalFilename();

                    if(originalFilename.equals("")){

                      return index(qrCodeModel);

                    }else{
                        Properties pro = new Properties();

                        pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("common.properties"));

                        String path = new String(pro.getProperty("upload").getBytes("ISO8859-1"),"GBK") + "logo/";



                        String logoName=path +  sf.format(new Date())+  originalFilename;

                        //上传
                        file.transferTo(new File(logoName));

                        String destName=null;

                        List<String> imgList = new ArrayList<String>();

                        for(String str : strings){

                            ++number;

                            String dir = new String(pro.getProperty("dir").getBytes("ISO8859-1"),"GBK") ;

                            String absouteName=null;

                            if ("image/jpeg".equals(outType) ) {

                                absouteName  = String.valueOf(number) + sf.format(new Date())  + ".jpeg";

                                destName = dir + absouteName;

                                BarcodeFactory.encode(str,300,300,"jpeg",logoName,destName);

                            }else {
                                absouteName  = String.valueOf(number) + sf.format(new Date())  + ".png";

                                destName = dir + absouteName;

                                BarcodeFactory.encode(str,300,300,"png",logoName,destName);
                            }

                            File destImageFile = new File(destName);

                            String destBaseStr = Image2Base64.image2Base64(destImageFile);

                            imgList.add(destBaseStr);

                        }

                        String result = JSONObject.toJSONString(imgList);

                        map.put("result",result);
                    }

                }

            }

        }

        return map;

    }


    @RequestMapping(value = "/upload_logo")
    public ModelAndView upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) throws IOException {

        System.out.println("开始");

        Properties pro = new Properties();

        pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("common.properties"));

        String path = new String(pro.getProperty("upload").getBytes("ISO8859-1"),"GBK") ;

       String originName = file.getOriginalFilename();

       if(originName.equals("")){
            return new ModelAndView("error.jsp");
       }

        String fileName =getRandomString(12) + originName.substring(originName.indexOf("."));

        System.out.println(path);

        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);

//            String srcPath = targetFile.getAbsolutePath();
//
//            BarcodeFactory.encode("I Love You",300, 300,srcPath , "D:\\pic\\dest2.jpg");


        } catch (Exception e) {
            e.printStackTrace();
        }

        String  url = "http://localhost:8080/static/upload/" + fileName;

        QRCodeModel qrCodeModel = new QRCodeModel();

        qrCodeModel.setText(url);
        qrCodeModel.setErrorCorrectLevel("L");
        qrCodeModel.setOffset("1");
        qrCodeModel.setOutType("image/jpeg");
        qrCodeModel.setQrCodeLevel("0");
        qrCodeModel.setSize("3");


       List<Object> list = JSONArray.parseArray(index(qrCodeModel).get("result").toString());
       String baseStr = list.get(0).toString();

        ModelAndView mav = new ModelAndView("test.jsp");
        mav.addObject("baseStr",baseStr);
        return mav;


    }

    private static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    private Map<String, Object> index(QRCodeModel qrCodeModel) throws IOException {

//        System.out.println(qrCodeModel);

        String text = qrCodeModel.getText();

        int errorCorrectLevel = parseErrorCorrectLevel(qrCodeModel.getErrorCorrectLevel());

        Map<String, Object> map = new HashMap<String, Object>();

        String output = qrCodeModel.getOutType();

        String[] strings = text.split("%%");

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        int number = 0;

        List<String> imgList = new ArrayList<String>();

        for(String str : strings){

            ++number;

            QRCode qrcode = getQRCode(str,Integer.valueOf(qrCodeModel.getQrCodeLevel()),errorCorrectLevel);

            if ("image/jpeg".equals(output) ) {

                BufferedImage image = qrcode.createImage(Integer.valueOf(qrCodeModel.getSize()), Integer.valueOf(qrCodeModel.getOffset()));

                Properties pro = new Properties();

                pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("common.properties"));

                String dir = new String(pro.getProperty("dir").getBytes("ISO8859-1"),"GBK") ;

                String absouteName = String.valueOf(number) + sf.format(new Date())  + ".jpeg";

                String fileName= dir + absouteName;

//                imgList.add(absouteName);

                File file = new File(fileName);

                File file2 = new File("D:/pic/"+absouteName);

                ImageIO.write(image, "jpeg", file);

                ImageIO.write(image, "jpeg", file2);

                String baseStr = Image2Base64.image2Base64(file);

                imgList.add(baseStr);

                if(file.exists()){
                    System.out.println(file.getName());
                }else{
                    File dirFile = new File(dir);
                    for(File f : dirFile.listFiles()){
                        System.out.println(f.getName());
                    }
                }

                map.put("data","success");


            } else if ("image/png".equals(output) ) {

                BufferedImage image = qrcode.createImage(Integer.valueOf(qrCodeModel.getSize()), Integer.valueOf(qrCodeModel.getOffset()));

                Properties pro = new Properties();
                pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("common.properties"));

                String dir = new String(pro.getProperty("dir").getBytes("ISO8859-1"),"GBK") ;

                String absouteName = String.valueOf(number) + sf.format(new Date())  + ".png";

                String fileName = dir + absouteName;

//                imgList.add(absouteName);

                File file = new File(fileName);

                ImageIO.write(image, "png", file);

                String baseStr = Image2Base64.image2Base64(file);

                imgList.add(baseStr);

                map.put("data","success");

            } else {
                map.put("data","fail");
                throw new IllegalArgumentException("illegal output type : " + output);
            }

        }

        String result = JSONObject.toJSONString(imgList);

        map.put("result",result);

        return map;
    }

    private static QRCode getQRCode(String text, int typeNumber, int errorCorrectLevel) {

        if (typeNumber == 0) {

            return QRCode.getMinimumQRCode(text, errorCorrectLevel);

        } else {

            QRCode qr = new QRCode();
            qr.setTypeNumber(typeNumber);
            qr.setErrorCorrectLevel(errorCorrectLevel);
            qr.addData(text);
            qr.make();

            return qr;

        }
    }

    private static int parseErrorCorrectLevel(String ecl) {

        if ("L".equals(ecl) ) {
            return ErrorCorrectLevel.L;
        } else if ("Q".equals(ecl) ) {
            return ErrorCorrectLevel.Q;
        } else if ("M".equals(ecl) ) {
            return ErrorCorrectLevel.M;
        } else if ("H".equals(ecl) ) {
            return ErrorCorrectLevel.H;
        } else {
            throw new IllegalArgumentException("invalid error correct level : " + ecl);
        }

    }

    private static GIFImage createGIFImage(QRCode qrcode, int cellSize, int margin) throws IOException {

        int imageSize = qrcode.getModuleCount() * cellSize + margin * 2;

        GIFImage image = new GIFImage(imageSize, imageSize);

        for (int y = 0; y < imageSize; y++) {

            for (int x = 0; x < imageSize; x++) {

                if (margin <= x && x < imageSize - margin
                        && margin <= y && y < imageSize - margin) {

                    int col = (x - margin) / cellSize;
                    int row = (y - margin) / cellSize;

                    if (qrcode.isDark(row, col) ) {
                        image.setPixel(x, y, 0);
                    } else {
                        image.setPixel(x, y, 1);
                    }

                } else {
                    image.setPixel(x, y, 1);
                }
            }
        }

        return image;
    }



}
