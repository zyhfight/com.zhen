package IOTestC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Externalizable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.PushbackReader;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import IOTestC.CMain;


public class IOMain
{
    public static void listAll(File fileDir)
    {
        
        String[] strList = fileDir.list();
        for (String filename : strList)
        {
            System.out.println(filename);
            File fileDirTmp = new File(fileDir.getName()+ System.getProperty("file.separator") + filename);
            if (fileDirTmp.isDirectory())
            {
                CMain.listAll(fileDirTmp);
            }
        }  
    }

  public static void insert(String fileName, long pos, String insertContent) throws IOException
  {
          File file = File.createTempFile("insertFile", ".tmp");
          file.deleteOnExit();
          
          try( RandomAccessFile targetRaf = new RandomAccessFile(fileName, "rw");
                  RandomAccessFile tmpRaf = new RandomAccessFile(file, "rw"))
          {
              byte[] buf = new byte[1024];
              int hasread = 0;
              targetRaf.seek(pos);
              while ((hasread = targetRaf.read(buf)) > 0)
              {
                  tmpRaf.write(buf, 0, hasread);
              }
  
              targetRaf.seek(pos);
              targetRaf.write(insertContent.getBytes());
              
              tmpRaf.seek(0);
              while ((hasread = tmpRaf.read(buf)) > 0)
              {
                  System.out.println(new String(buf, 0, hasread));
                  targetRaf.write(buf, 0, hasread);
              }
          }
          catch (IOException e)
          {
              e.printStackTrace();
          }
  }
 
//    public static void insert(String fileName, long pos, String insertContent)
//            throws IOException
//    {
//        File tmp = File.createTempFile("tmp", null);
//        tmp.deleteOnExit();
//        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
//        // 使用临时文件来保存插入点后的数据
//                FileOutputStream tmpOut = new FileOutputStream(tmp);
//                FileInputStream tmpIn = new FileInputStream(tmp))
//        {
//            raf.seek(pos);
//            // ------下面代码将插入点后的内容读入临时文件中保存------
//            byte[] bbuf = new byte[64];
//            // 用于保存实际读取的字节数
//            int hasRead = 0;
//            // 使用循环方式读取插入点后的数据
//            while ((hasRead = raf.read(bbuf)) > 0)
//            {
//                // 将读取的数据写入临时文件
//                tmpOut.write(bbuf, 0, hasRead);
//            }
//            // ----------下面代码插入内容----------
//            // 把文件记录指针重新定位到pos位置
//            raf.seek(pos);
//            // 追加需要插入的内容
//            raf.write(insertContent.getBytes());
//            // 追加临时文件中的内容
//            while ((hasRead = tmpIn.read(bbuf)) > 0)
//            {
//                raf.write(bbuf, 0, hasRead);
//            }
//        }
//    }
  
    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
      
//        System.out.println(args.length);
//        for (String arg : args)
//        {
//            System.out.println(arg);
//        }
        
        
//        // System.in代表标准输入，就是键盘输入
//        Scanner sc = new Scanner(System.in);
//        sc.useDelimiter("\n");
//        while(sc.hasNext())
//        {
//            // 输出输入项
//            System.out.println("键盘输入的内容是："
//                + sc.next());
//        }     
        
//        InputStream in = System.in;
//        byte[] buffer = new byte[256];
//        int readnu = 0;
//        while((readnu = in.read(buffer)) > 0)
//        {
//            System.out.println(new String(buffer, 0, readnu-1));
//        }
        
        // 获取系统所有的环境变量
//        Map<String,String> env = System.getenv();
//        for (String name : env.keySet())
//        {
//            System.out.println(name + " ---> " + env.get(name));
//        } 
        
//        System.out.println(System.getenv("TEMP"));
    
//        Properties props = System.getProperties();
//        props.store(new FileOutputStream("props.txt"), "---jvm props--");
//        System.out.println(System.getProperty("user.dir"));
        
//        // 获取Java程序关联的运行时对象
//        Runtime rt = Runtime.getRuntime();
//        System.out.println("处理器数量："+ rt.availableProcessors());
//        System.out.println("空闲内存数："+ rt.freeMemory());
//        //启动的时候就会无条件的从操作系统中挖- Xms后面定义的内存数
//        System.out.println("总内存数："+ rt.totalMemory());
//        //没有添加-Xmx参数 64M java -cp ClassPath -Xmx512m ClassName
//        System.out.println("可用最大内存数："+ rt.maxMemory());     
        
//        Runtime rt = Runtime.getRuntime();
//        // 运行记事本程序
//        rt.exec("calc.exe");
        
//        System.out.println(System.getProperty("user.dir"));
//        if (args.length > 0)
//        {
//            File file = new File("props.txt");
//
//            System.out.println("文件或目录是否存在:" + file.exists());
//            System.out.println("是文件吗:" + file.isFile());
//            System.out.println("是目录吗:" + file.isDirectory());
//            System.out.println("名称:" + file.getName());
//            System.out.println("路径: " + file.getPath());
//            System.out.println("绝对路径: " + file.getAbsolutePath());
//            System.out.println("最后修改时间:" + file.lastModified());
//            System.out.println("文件大小:" + file.length() + "字节");
////        }       
        
//        // 以当前路径来创建一个File对象
//        File file = new File(".");
//        // 直接获取文件名，输出一点
//        System.out.println(file.getName());
//        // 获取相对路径的父路径可能出错，下面代码输出null
//        System.out.println(file.getParent());
//        // 获取绝对路径
//        System.out.println(file.getAbsoluteFile());
//        // 获取上一级路径
//        System.out.println(file.getAbsoluteFile().getParent());
//        System.out.println(file.getAbsoluteFile().getName());
        
//        File tmpFile = File.createTempFile("aaa", ".txt", new File("."));
//        tmpFile.deleteOnExit();
        
//        File newFile = new File("aa\\bb");
//        //newFile.createNewFile();
//        //newFile.deleteOnExit();
//        newFile.mkdirs();
//        newFile.deleteOnExit();

//        //System.out.println("是目录吗:" + file.isDirectory());
//        File file = new File(".");
//        String[] fileList = file.list();
//        System.out.println("====当前路径下所有文件和路径如下====");
//        for (String fileName : fileList)
//        {
//            System.out.println(fileName);
//        }        
        
//        // listRoots()静态方法列出所有的磁盘根路径。
//        File[] roots = File.listRoots();
//        System.out.println("====系统所有根路径如下====");
//        for (File root : roots)
//        {
//            System.out.println(root);
//        }
        
//        File file = new File(".");
//        String[] fileList = file.list(new MyFilenameFilter());
//        System.out.println("====当前路径下所有文件和路径如下====");
//        for (String fileName : fileList)
//        {
//            System.out.println(fileName);
//        }      
        
//        File file = new File(".");
//        File[] fileList = file.listFiles(new MyFileFilter());
//        System.out.println("====当前路径下所有文件和路径如下====");
//        for (File fileName : fileList)
//        {
//            System.out.println(fileName.getName());
//        }    
        
//        // 创建字节输入流
//        FileInputStream fis = new FileInputStream("props.txt");
//        // 创建一个长度为1024的“竹筒”
//        byte[] bbuf = new byte[1024];
//        // 用于保存实际读取的字节数
//        int hasRead = 0;
//        // 使用循环来重复“取水”过程
//        while ((hasRead = fis.read(bbuf)) > 0)
//        {
//            System.out.println("\n---->:  " + hasRead);
//
//            // 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
//            System.out.print(new String(bbuf, 0, hasRead));
//        }
//        // 关闭文件输入流，放在finally块里更安全
//        fis.close();
        
//        FileReader fr = null;
//        try
//        {
//            fr = new FileReader("props.txt");
//            // 创建一个长度为32的“竹筒”
//            char[] cbuf = new char[32];
//            // 用于保存实际读取的字符数
//            int hasRead = 0;
//            // 使用循环来重复“取水”过程
//            while ((hasRead = fr.read(cbuf)) > 0)
//            {
//                System.out.println("\n---->:  " + hasRead);
//                // 取出“竹筒”中水滴（字符），将字符数组转换成字符串输入！
//                System.out.print(new String(cbuf, 0, hasRead));
//            }
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }
//        finally
//        {
//            if (fr != null)
//            {
//                fr.close();
//            }
//        }
//        
 
//        try (
//                // 创建字节输入流
//                FileInputStream fis = new FileInputStream("props.txt");
//                // 创建字节输出流
//                FileOutputStream fos = new FileOutputStream("newFile.txt"))
//        {
//            byte[] bbuf = new byte[1000];
//            int hasRead = 0;
//            // 循环从输入流中取出数据
//            while ((hasRead = fis.read(bbuf)) > 0)
//            {
//                // 每读取一次，即写入文件输出流，读了多少，就写多少。
//                fos.write(bbuf, 0, hasRead);
//            }
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
        
//        try(
//                    FileWriter fw = new FileWriter("poem.txt", true);)
////                  FileWriter fw = new FileWriter("poem.txt"))
//              {
//                  fw.write("锦瑟 - 李商隐" + System.getProperty("line.separator"));
//                  fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
//                  fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
//                  fw.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
//                  fw.write("此情可待成追忆，只是当时已惘然。\r\n");
//              }
//              catch (IOException ioe)
//              {
//                  ioe.printStackTrace();
//              }
   
//            String src = "从明天起，做一个幸福的人\n"
//                + "喂马，劈柴，周游世界\n"
//                + "从明天起，关心粮食和蔬菜\n"
//                + "我有一所房子，面朝大海，春暖花开\n"
//                + "从明天起，和每一个亲人通信\n"
//                + "告诉他们我的幸福\n";
//            char[] buffer = new char[32];
//            int hasRead = 0;
//            try(
//                StringReader sr = new StringReader(src))
//            {
//                // 采用循环读取的访问读取字符串
//                while((hasRead = sr.read(buffer)) > 0)
//                {
//                    System.out.println("\n---->:  " + hasRead);
//                    System.out.print(new String(buffer ,0 , hasRead));
//                }
//            }
//            catch (IOException ioe)
//            {
//                ioe.printStackTrace();
//            }
//            try(
//                // 创建StringWriter时，实际上以一个StringBuffer作为输出节点
//                // 下面指定的20就是StringBuffer的初始长度
//                StringWriter sw = new StringWriter())
//            {
//                // 调用StringWriter的方法执行输出
//                sw.write("有一个美丽的新世界，\n");
//                sw.write("她在远方等我,\n");
//                sw.write("哪里有天真的孩子，\n");
//                sw.write("还有姑娘的酒窝\n");
//                System.out.println("----下面是sw的字符串节点里的内容----");
//                // 使用toString()方法返回StringWriter的字符串节点的内容
//                System.out.println(sw.toString());
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try (
//                // 将Sytem.in对象转换成Reader对象
//                InputStreamReader reader = new InputStreamReader(System.in);
//                // 将普通Reader包装成BufferedReader
//                BufferedReader br = new BufferedReader(reader))
//        {
//            String line = null;
//            // 采用循环方式来一行一行的读取
//            while ((line = br.readLine()) != null)
//            {
//                // 如果读取的字符串为"exit"，程序退出
//                if (line.equals("exit"))
//                {
//                    System.exit(1);
//                }
//                // 打印读取的内容
//                System.out.println("输入内容为:" + line);
//            }
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }    
        
//        try (
//                // 将Sytem.in对象转换成Reader对象
//                OutputStreamWriter writer = new OutputStreamWriter(System.out);
//                // 将普通Reader包装成BufferedReader
//                BufferedWriter bw = new BufferedWriter(writer))
//         {
//             String line = null;
//             bw.write("我们一起学习！");
//             bw.newLine();
//             bw.write("我们一起玩！");
//             bw.newLine();
//         }
//         catch (IOException ioe)
//         {
//             ioe.printStackTrace();
//         }   
  
//        try(
//                FileOutputStream fos = new FileOutputStream("test.txt");
//                PrintStream ps = new PrintStream(fos))
//            {
//                // 使用PrintStream执行输出
//                ps.println("普通字符串");
//                ps.format("abcd=%10d%s", 10, System.getProperty("line.separator"));
//                // 直接使用PrintStream输出对象
//                ps.println(new CMain());
//            }
//            catch (IOException ioe)
//            {
//                ioe.printStackTrace();
//            }
        
//        PushbackReader pr = new PushbackReader(new FileReader("props.txt"), 64);
//        String strBuf = "abcde12345";
//        pr.unread(strBuf.toCharArray());
//        
//        char[] buf = new char[15];
//        int hasRead = pr.read(buf);
//        if (hasRead > 0)
//        {
//            System.out.println(new String(buf, 0, hasRead));     
//        }  
//        
//        hasRead = pr.read(buf);
//        if (hasRead > 0)
//        {
//            System.out.println(new String(buf, 0, hasRead));     
//        }     
        
//        try(
//                FileInputStream fis = new FileInputStream("RedirectIn.java"))
//            {
//                // 将标准输入重定向到fis输入流
//                System.setIn(fis);
//                // 使用System.in创建Scanner对象，用于获取标准输入
//                Scanner sc = new Scanner(System.in);
//                // 增加下面一行将只把回车作为分隔符
//                sc.useDelimiter("\n");
//                // 判断是否还有下一个输入项
//                while(sc.hasNext())
//                {
//                    // 输出输入项
//                    System.out.println("键盘输入的内容是：" + sc.next());
//                }
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try(
//                // 一次性创建PrintStream输出流
//                //PrintStream ps = new PrintStream(new FileOutputStream("out.txt")))
//                PrintStream ps = new PrintStream("out.txt"))
//            {
//                // 将标准输出重定向到ps输出流
//                System.setOut(ps);
//                // 向标准输出输出一个字符串
//                System.out.println("普通字符串");
//                // 向标准输出输出一个对象
//                System.out.println(new CMain());
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
 
//        // 运行javac命令，返回运行该命令的子进程
//        Process p = Runtime.getRuntime().exec("java.exe");
//        try(
//            // 以p进程的错误流创建BufferedReader对象
//            // 这个错误流对本程序是输入流，对p进程则是输出流
//            BufferedReader br = new BufferedReader(new
//                InputStreamReader(p.getErrorStream())))
//        {
//            String buff = null;
//            // 采取循环方式来读取p进程的错误输出
//            while((buff = br.readLine()) != null)
//            {
//                System.out.println(buff);
//            }
//        }        

//        // 运行java ReadStandard命令，返回运行该命令的子进程
//        Process p = Runtime.getRuntime().exec("java -classpath bin IOTestC.ReadStandard");
//        try (
//        // 以p进程的输出流创建PrintStream对象
//        // 这个输出流对本程序是输出流，对p进程则是输入流
//        PrintStream ps = new PrintStream(p.getOutputStream()))
//        {
//            // 向ReadStandard程序写入内容，这些内容将被ReadStandard读取
//            ps.println("普通字符串");
//            ps.println(new CMain());
//        }

//        try (RandomAccessFile raf = new RandomAccessFile("out.txt", "r"))
//        {
//            // 获取RandomAccessFile对象文件指针的位置，初始位置是0
//            System.out.println("RandomAccessFile的文件指针的初始位置："+ raf.getFilePointer());
//            // 移动raf的文件记录指针的位置
//            raf.seek(0);
//            byte[] bbuf = new byte[1024];
//            // 用于保存实际读取的字节数
//            int hasRead = 0;
//            // 使用循环来重复“取水”过程
//            while ((hasRead = raf.read(bbuf)) > 0)
//            {
//                System.out.println("--->hasread: " + hasRead);
//                // 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
//                System.out.print(new String(bbuf, 0, hasRead));
//            }
//            
//            String strLine = null;
//            while ((strLine = raf.readLine()) != null)
//            {
//                // 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
//                System.out.println(strLine);
//            }
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }
        
//        try(
//                //以读、写方式打开一个RandomAccessFile对象
//                RandomAccessFile raf = new RandomAccessFile("out.txt" , "rw"))
//            {
//                //将记录指针移动到out.txt文件的最后
//                raf.seek(raf.length());
//                byte[] buff = new String("追加的内容！\r\n").getBytes();
//                raf.write(buff);
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try(
//                // 创建一个ObjectOutputStream输出流
//                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt")))
//            {
//                Person per = new Person("孙悟空", 500);
//                // 将per对象写入输出流
//                oos.writeObject(per);
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
   
//        try(
//                // 创建一个ObjectInputStream输入流
//                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt")))
//            {
//                // 从输入流中读取一个Java对象，并将其强制类型转换为Person类
//                Person p = (Person)ois.readObject();
//                System.out.println("名字为：" + p.getName()
//                    + "\n年龄为：" + p.getAge());
//            }
//            catch (Exception ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try (
//            // 创建一个ObjectOutputStream输出流
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt")))
//        {
//            Person per = new Person("孙悟空", 500);
//            Teacher t1 = new Teacher("唐僧", per);
//            Teacher t2 = new Teacher("菩提祖师", per);
//            // 依次将四个对象写入输出流
//            oos.writeObject(t1);
//            oos.writeObject(t2);
//            oos.writeObject(per);
//            oos.writeObject(t2);
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        } 
        
//        try (
//            // 创建一个ObjectInputStream输出流
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt")))
//        {
//            // 依次读取ObjectInputStream输入流中的四个对象
//            Teacher t1 = (Teacher) ois.readObject();
//            Teacher t2 = (Teacher) ois.readObject();
//            Person p = (Person) ois.readObject();
//            Teacher t3 = (Teacher) ois.readObject();
//            // 输出true
//            System.out.println("t1的student引用和p是否相同：" + (t1.getStudent() == p));
//            // 输出true
//            System.out.println("t2的student引用和p是否相同：" + (t2.getStudent() == p));
//            // 输出true
//            System.out.println("t2和t3是否是同一个对象：" + (t2 == t3));
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
        
//        try(
//                // 创建一个ObjectOutputStream输入流
//                ObjectOutputStream oos = new ObjectOutputStream(
//                    new FileOutputStream("mutable.txt"));
//                // 创建一个ObjectInputStream输入流
//                ObjectInputStream ois = new ObjectInputStream(
//                    new FileInputStream("mutable.txt")))
//            {
//                Person per = new Person("孙悟空", 500);
//                // 系统会per对象转换字节序列并输出
//                oos.writeObject(per);
//                // 改变per对象的name实例变量
//                per.setName("猪八戒");
//                // 系统只是输出序列化编号，所以改变后的name不会被序列化
//                oos.writeObject(per);
//                Person p1 = (Person)ois.readObject();    //①
//                Person p2 = (Person)ois.readObject();    //②
//                // 下面输出true，即反序列化后p1等于p2
//                System.out.println(p1 == p2);
//                // 下面依然看到输出"孙悟空"，即改变后的实例变量没有被序列化
//                System.out.println(p2.getName());
//            }
//            catch (Exception ex)
//            {
//                ex.printStackTrace();
//            }        

//        try (
//        // 创建一个ObjectOutputStream输出流
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
//                "object.txt")))
//        {
//            Person per = new Person("abcd", 500);
//            // 将per对象写入输出流
//            oos.writeObject(per);
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }

//        try (
//        // 创建一个ObjectInputStream输入流
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
//                "object.txt")))
//        {
//            // 从输入流中读取一个Java对象，并将其强制类型转换为Person类
//            Person p = (Person) ois.readObject();
//            System.out.println("名字为：" + p.getName() + "\n年龄为：" + p.getAge());
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
        
//        // 创建Buffer
//        CharBuffer buff = CharBuffer.allocate(8); // ①
//        System.out.println("capacity: " + buff.capacity());
//        System.out.println("limit: " + buff.limit());
//        System.out.println("position: " + buff.position());
//        // 放入元素
//        buff.put('a');
//        buff.put('b');
//        buff.put('c'); // ②
//        System.out.println("加入三个元素后，position = " + buff.position());
//        // 调用flip()方法
//        buff.flip(); // ③
//        System.out.println("执行flip()后，limit = " + buff.limit());
//        System.out.println("position = " + buff.position());
//        // 取出第一个元素
//        System.out.println("第一个元素(position=0)：" + buff.get()); // ④
//        System.out.println("取出一个元素后，position = " + buff.position());
//        // 调用clear方法
//        buff.clear(); // ⑤
//        System.out.println("执行clear()后，limit = " + buff.limit());
//        System.out.println("执行clear()后，position = " + buff.position());
//        System.out.println("执行clear()后，缓冲区内容并没有被清除：" + "第三个元素为：" + buff.get(2)); // ⑥
//        System.out.println("执行绝对读取后，position = " + buff.position());
                
//        try(
//                // 创建文件输入流
//                FileInputStream fis = new FileInputStream("props.txt");
//                // 创建一个FileChannel
//                FileChannel fcin = fis.getChannel())
//            {
//                // 定义一个ByteBuffer对象，用于重复取水
//                ByteBuffer bbuff = ByteBuffer.allocate(256);
//                // 将FileChannel中数据放入ByteBuffer中
//                while( fcin.read(bbuff) != -1 )
//                {
//                    // 锁定Buffer的空白区
//                    bbuff.flip();
//                    // 创建Charset对象
//                    //Charset charset = Charset.forName("GBK");
//                    // 创建解码器(CharsetDecoder)对象
//                    //CharsetDecoder decoder = charset.newDecoder();
//                    // 将ByteBuffer的内容转码
//                    //CharBuffer cbuff = decoder.decode(bbuff);
//                    byte[] bBbuf = bbuff.array(); 
//                    System.out.print(new String(bBbuf));
//                    // 将Buffer初始化，为下一次读取数据做准备
//                    bbuff.clear();
//                }
//            }        
        
//        File f = new File("props.txt");
//        try(
//            // 创建FileInputStream，以该文件输入流创建FileChannel
//            FileChannel inChannel = new FileInputStream(f).getChannel();
//            // 以文件输出流创建FileBuffer，用以控制输出
//            FileChannel outChannel = new FileOutputStream("a.txt")
//                .getChannel())
//        {
//            // 将FileChannel里的全部数据映射成ByteBuffer
//            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY , 0 , f.length());   // ①
//            // 使用GBK的字符集来创建解码器
//            //Charset charset = Charset.forName("GBK");
//            // 直接将buffer里的数据全部输出
//            outChannel.write(buffer);     // ②
//            // 再次调用buffer的clear()方法，复原limit、position的位置
//            buffer.clear();
//            // 创建解码器(CharsetDecoder)对象
//            //CharsetDecoder decoder = charset.newDecoder();
//            // 使用解码器将ByteBuffer转换成CharBuffer
//            //CharBuffer charBuffer =  decoder.decode(buffer);
//            // CharBuffer的toString方法可以获取对应的字符串
//            //System.out.println(charBuffer);         
//            byte[] bBbuf = buffer.array(); 
//            System.out.println(new String(bBbuf));
//            
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }

//        File f = new File("a.txt");
//        try(
//            // 创建一个RandomAccessFile对象
//            RandomAccessFile raf = new RandomAccessFile(f, "rw");
//            // 获取RandomAccessFile对应的Channel
//            FileChannel randomChannel = raf.getChannel())
//        {
//            // 将Channel中所有数据映射成ByteBuffer
//            ByteBuffer buffer = randomChannel.map(FileChannel
//                .MapMode.READ_ONLY, 0 , f.length());
//            // 把Channel的记录指针移动到最后
//            randomChannel.position(f.length());
//            // 将buffer中所有数据输出
//            randomChannel.write(buffer);    
        
//        // 获取Java支持的全部字符集
//        SortedMap<String,Charset>  map = Charset.availableCharsets();
//        for (String alias : map.keySet())
//        {
//            // 输出字符集的别名和对应的Charset对象
//            System.out.println(alias + "----->"
//                + map.get(alias));
//        }
 
//        // 创建简体中文对应的Charset
//        Charset cn = Charset.forName("GBK");
//        // 获取cn对象对应的编码器和解码器
//        CharsetEncoder cnEncoder = cn.newEncoder();
//        CharsetDecoder cnDecoder = cn.newDecoder();
//        // 创建一个CharBuffer对象
//        CharBuffer cbuff = CharBuffer.allocate(8);
//        cbuff.put('孙');
//        cbuff.put('悟');
//        cbuff.put('空');
//        cbuff.flip();
//        // 将CharBuffer中的字符序列转换成字节序列
//        ByteBuffer bbuff = cnEncoder.encode(cbuff);
//        // 循环访问ByteBuffer中的每个字节
//        for (int i = 0; i < bbuff.capacity() ; i++)
//        {
//            System.out.print(bbuff.get(i) + " ");
//        }
//        // 将ByteBuffer的数据解码成字符序列
//        System.out.println("\n" + cnDecoder.decode(bbuff));       
        
//        try(
//                // 使用FileOutputStream获取FileChannel
//                FileChannel channel = new FileOutputStream("a.txt")
//                    .getChannel())
//            {
//                // 使用非阻塞式方式对指定文件加锁
//                FileLock lock = channel.tryLock();
//                // 程序暂停10s
//                Thread.sleep(10000);
//                // 释放锁
//                lock.release();    
        

//        String strA = "中";
//        byte[] bt = strA.getBytes("UnicodeLittle");
//        
//        FileWriter fw = new FileWriter("test.out");
//        
//        char ch = '中';
//        fw.write(ch);
//        fw.close();
        
//        FileInputStream fi = new FileInputStream("tt.out");
//        byte[] bt2 = new byte[100];
//        fi.read(bt2);      
        
//        int n;
//        FileReader fr = new FileReader("tt.out");
//        char[] bt2 = new char[100];
//        n = fr.read(bt2); 
//        
//        FileWriter fw2 = new FileWriter("tt2.out");
//        fw2.write(bt2, 0, n); 
//        fr.close();
//        fw2.close();
        
//        OperatIniFile op = new OperatIniFile("t3.out");
//        String strVal = op.readItem("RUN", "c1");
//        System.out.println(strVal);
//        op.close();
//        
//        OperatIniFile op2 = new OperatIniFile("t3.out");
//        System.out.println(op2.deleteItem("RUN", "c1"));
        
          OperatIniFile op = new OperatIniFile("t3.out");
          System.out.println(op.addItem3("Common1", "d1", "123"));
          
    }
}

//class MyFilenameFilter implements FilenameFilter
//{
//    public boolean accept(File dir, String name) 
//    {
//        //System.out.println("dir: " + dir + " name: " + name);
//        if (name.startsWith("."))
//            return true;
//        return false;
//    }
//    
//}

//class MyFileFilter implements FileFilter
//{
//    public boolean accept(File pathname) 
//    {
//        //System.out.println("path: " + pathname.getParent() + " name: " + pathname.getName());
//        if (pathname.getName().startsWith("."))
//            return true;
//        return false;
//    }   
//}

//class Person implements Serializable
//{
//    private String name;
//    private int age;
//    //static private int age;
//    //transient private int age;
//     
//    // 注意此处没有提供无参数的构造器!
//    public Person(String name , int age)
//    {
//        System.out.println("有参数的构造器");
//        this.name = name;
//        this.age = age;
//    }
//    // 省略name与age的setter和getter方法
//
//    // name的setter和getter方法
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // age的setter和getter方法
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//    public int getAge()
//    {
//        return this.age;
//    }
//}
//
//class Teacher implements java.io.Serializable
//{
//    private String name;
//    private Person student;
//
//    public Teacher(String name, Person student)
//    {
//        this.name = name;
//        this.student = student;
//    }
//
//    // 此处省略了name和student的setter和getter方法
//
//    // name的setter和getter方法
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // student的setter和getter方法
//    public void setStudent(Person student)
//    {
//        this.student = student;
//    }
//
//    public Person getStudent()
//    {
//        return this.student;
//    }
//}

//class Person implements java.io.Serializable
//{
//    private String name;
//    private int    age;
//
//    // 注意此处没有提供无参数的构造器!
//    public Person(String name, int age)
//    {
//        System.out.println("有参数的构造器");
//        this.name = name;
//        this.age = age;
//    }
//
//    // 省略name与age的setter和getter方法
//
//    // name的setter和getter方法
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // age的setter和getter方法
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//
//    public int getAge()
//    {
//        return this.age;
//    }
//
//    private void writeObject(java.io.ObjectOutputStream out) throws IOException
//    {
//        // 将name实例变量的值反转后写入二进制流
//        out.writeObject(new StringBuffer(name).reverse());
//        out.writeInt(age);
//    }
//
//    private void readObject(java.io.ObjectInputStream in) throws IOException,
//            ClassNotFoundException
//    {
//        // 将读取的字符串反转后赋给name实例变量
//        StringBuffer temp = (StringBuffer)in.readObject();
//        this.name = temp.reverse().toString();
//        this.age = in.readInt();
//    }
//}

//class Person implements Externalizable
//{
//   // private static final long serialVersionUID = 42L;
//
//    private String name;
//    private int    age;
//    private String  memo;
//    // 注意此处需要提供无参数的构造器!
//    public Person()
//    {
//        name = null;
//        age = 0;
//    }
//
//    public Person(String name, int age)
//    {
//        System.out.println("有参数的构造器");
//        this.name = name;
//        this.age = age;
//    }
//
//    // 省略name与age的setter和getter方法
//
//    // name的setter和getter方法
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // age的setter和getter方法
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//
//    public int getAge()
//    {
//        return this.age;
//    }
//
//    public void writeExternal(java.io.ObjectOutput out) throws IOException
//    {
//        // 将name实例变量的值反转后写入二进制流
//        out.writeObject(new StringBuffer(name).reverse());
//        out.writeInt(age);
//    }
//
//    public void readExternal(java.io.ObjectInput in) throws IOException,
//            ClassNotFoundException
//    {
//        // 将读取的字符串反转后赋给name实例变量
//        this.name = ((StringBuffer) in.readObject()).reverse().toString();
//        this.age = in.readInt();
//        this.memo = "abcd";
//    }
//}

class OperatIniFile
{
    //BufferedReader br;
    String fileName;
    OperatIniFile(String fileName) throws FileNotFoundException
    {
        //br = new BufferedReader(new FileReader(fileName));
        this.fileName = fileName;
    }
    
//    void close() throws IOException
//    {
//       if (br != null)
//       {
//           br.close();
//       }
//    }
    
    String readItem(String strSector, String strItem) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strLine = null;
        boolean bFindSector = false;
        String strResult = null;
        while ((strLine = br.readLine()) != null)
        {
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.equals("["))
                {
                    //return null;
                    break;
                }
                
                String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                
                System.out.println(strLeft + "=" + strRight);
                if (strLeft.equals(strItem))
                {
                    //return strRight;
                    strResult = strRight;
                    break;
                }
            }
        }
        
        br.close();
        return strResult;
    }
    
    boolean deleteItem(String strSector, String strItem) throws IOException
    {
        String strLine = null;
        boolean bFindSector = false;
        boolean bDel = false;
        File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        FileWriter fw = new FileWriter(tmpFile);
        PrintWriter pw = new PrintWriter(fw);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.equals("["))
                {
                    bFindSector = false;
                }
                
                String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                
                if (strLeft.equals(strItem))
                {
                    bDel = true;
                    continue;
                }
            }
            
            //fw.write(strOld + "\r\n");
            pw.println(strOld);
        }

        br.close();
        fw.close();
        pw.close();
        
        File file = new File(fileName);
        file.delete();
        tmpFile.renameTo(new File(fileName));
        
        return bDel;
    }

    boolean addItem(String strSector, String strItem, String strVal) throws IOException
    {
        if (null == strSector || null == strItem || strVal == null)
        {
            return false;
        }
        
        String strLine = null;
        boolean bFindSector = false;
        boolean bAdd = false;
        
        File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        tmpFile.deleteOnExit();
        //FileWriter fw = new FileWriter(tmpFile);
        PrintWriter pw = new PrintWriter(tmpFile);
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.startsWith("["))
                {
                    bFindSector = false;
                    if (!bAdd)
                    {
                        bAdd = true;
                        pw.println(strItem + " = " + strVal);
                    }
                }
                
                int pos = strLine.indexOf("=");
                if (pos > 1)
                {
                    String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                    String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                    
                    if (strLeft.equals(strItem))
                    {
                        bAdd = true;
                        pw.println(strItem + " = " + strVal);
                        continue;
                    }
                }

            }
            
            //fw.write(strOld + "\r\n");
            pw.println(strOld);
        }

        if (!bAdd)
        {
            pw.println("[" + strSector + "]");
            pw.println(strItem + " = " + strVal);
        }
        
        br.close();
        //fw.close();
        pw.close();
        
        File file = new File(fileName);
        file.delete();
        tmpFile.renameTo(new File(fileName));
        
        return true;
    }

    boolean addItem2(String strSector, String strItem, String strVal) throws IOException
    {
        if (null == strSector || null == strItem || strVal == null)
        {
            return false;
        }
        
        String strLine = null;
        boolean bFindSector = false;
        boolean bAdd = false;
        
        //File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        //tmpFile.deleteOnExit();
        //FileWriter fw = new FileWriter(tmpFile);
        //PrintWriter pw = new PrintWriter(tmpFile);
        StringWriter sw = new StringWriter();
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.startsWith("["))
                {
                    bFindSector = false;
                    if (!bAdd)
                    {
                        bAdd = true;
                       // pw.println(strItem + " = " + strVal);
                        sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                    }
                }
                
                int pos = strLine.indexOf("=");
                if (pos > 1)
                {
                    String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                    String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                    
                    if (strLeft.equals(strItem))
                    {
                        bAdd = true;
                        //pw.println(strItem + " = " + strVal);
                        sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                        continue;
                    }
                }

            }
            
            //fw.write(strOld + "\r\n");
            //pw.println(strOld);
            sw.write(strOld + System.getProperty("line.separator"));
        }

        if (!bAdd)
        {
            //pw.println("[" + strSector + "]");
            //pw.println(strItem + " = " + strVal);
            sw.write("[" + strSector + "]" + System.getProperty("line.separator"));
            sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
        }
        
        br.close();
        //fw.close();
        //pw.close();
        sw.close();
        
        File file = new File(fileName);
        //file.delete();
        //tmpFile.renameTo(new File(fileName));
        FileWriter fw = new FileWriter(file);
        fw.write(sw.toString());
        fw.close();
        
        return true;
    }    
    
    boolean addItem3(String strSector, String strItem, String strVal) throws IOException
    {
        if (null == strSector || null == strItem || strVal == null)
        {
            return false;
        }
        
        String strLine = null;
        boolean bFindSector = false;
        boolean bAdd = false;
        
        //File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        //tmpFile.deleteOnExit();
        //FileWriter fw = new FileWriter(tmpFile);
        //PrintWriter pw = new PrintWriter(tmpFile);
        //StringWriter sw = new StringWriter();
        ArrayList<String> listLines = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.startsWith("["))
                {
                    bFindSector = false;
                    if (!bAdd)
                    {
                        bAdd = true;
                       // pw.println(strItem + " = " + strVal);
                        //sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                        listLines.add(strItem + " = " + strVal);
                    }
                }
                
                int pos = strLine.indexOf("=");
                if (pos > 1)
                {
                    String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                    String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                    
                    if (strLeft.equals(strItem))
                    {
                        bAdd = true;
                        //pw.println(strItem + " = " + strVal);
                        //sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                        listLines.add(strItem + " = " + strVal);
                        continue;
                    }
                }

            }
            
            //fw.write(strOld + "\r\n");
            //pw.println(strOld);
            //sw.write(strOld + System.getProperty("line.separator"));
            listLines.add(strOld);
        }

        if (!bAdd)
        {
            //pw.println("[" + strSector + "]");
            //pw.println(strItem + " = " + strVal);
            //sw.write("[" + strSector + "]" + System.getProperty("line.separator"));
            //sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
            listLines.add("[" + strSector + "]");
            listLines.add(strItem + " = " + strVal);
        }
        
        br.close();
        //fw.close();
        //pw.close();
        //sw.close();
        
        File file = new File(fileName);
        //file.delete();
        //tmpFile.renameTo(new File(fileName));
        FileWriter fw = new FileWriter(file);
        //fw.write(sw.toString());
        for (String strLineItem : listLines)
        {
            fw.write(strLineItem + System.getProperty("line.separator"));
        }
        fw.close();
        
        return true;
    }    
    
}

