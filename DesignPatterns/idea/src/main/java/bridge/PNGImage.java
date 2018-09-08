package bridge;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 扩充抽象类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        imageService.doPaint(matrix);
        System.out.println(fileName + ".PNG");
    }
}
