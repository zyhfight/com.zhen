package composite;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class MainClass {
    public static void main(String[] args) {
        //针对抽象构件编程
        AbstractFile file1,file2,folder1,folder2;
        folder1 = new Folder("zyh的资料");
        file1 = new ImageFile("back.jpg");
        folder1.add(file1);
        folder2 = new Folder("图片");
        folder1.add(folder2);
        file2 = new ImageFile("cat.png");
        folder2.add(file2);

        //从根节点开始杀毒
//        folder1.killVirus();

//        folder2.killVirus();

        file1.killVirus();
    }
}
