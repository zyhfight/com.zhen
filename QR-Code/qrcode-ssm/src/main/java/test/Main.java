package test;

import com.zhen.utils.Image2Base64;

import java.io.File;

/**
 * Created by zhenyonghe on 2017/5/4.
 */
public class Main {
    public static void main(String[] args){

//        System.out.print(System.getProperty("user.dir"));

        String base64 = Image2Base64.image2Base64(new File("D:\\pic\\1.jpeg"));
        System.out.println(base64);

    }

}
