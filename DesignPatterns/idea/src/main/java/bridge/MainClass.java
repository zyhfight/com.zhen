package bridge;

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
        Image image = new JPGImage();//图像格式
        ImageService imageService = new WindowsImpl();//操作系统
        //通过组合关系，将两个维度变化松耦合
        image.setImageService(imageService);
        image.parseFile("张无忌");
    }
}
