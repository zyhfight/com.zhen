package bridge;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 具体实现类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class WindowsImpl implements ImageService {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("Windows系统中显示图像！");
    }
}
