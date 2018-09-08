package composite;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 叶子构件
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class ImageFile extends  AbstractFile{

    private String name;

    public ImageFile(String name){
        this.name = name;
    }

    @Override
    void killVirus() {
        System.out.println("---对图像文件： " + name + " 进行杀毒...");
    }
}
