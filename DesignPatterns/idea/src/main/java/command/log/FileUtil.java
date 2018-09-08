package command.log;

import java.io.*;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description:工具类 文件操作类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-22     zyh           v1.0.0               修改原因
 */
public class FileUtil {
    //将命令集合写入日志文件
    public static void writeCommands(List commands){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("config.log");
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
            oos.writeObject(commands);
            oos.close();
        }catch (Exception e){
            System.out.println("命令保存失败！");
            e.printStackTrace();
        }

    }

    //从日志文件中提取命令集合
    public static List<Command> readCommands(){
        try{
            FileInputStream fis = new FileInputStream("config.log");
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
            List commands = (List) ois.readObject();
            ois.close();;
            return commands;
        }catch (Exception e){
            System.out.println("命令读取失败！");
            e.printStackTrace();
            return null;
        }
    }

}
