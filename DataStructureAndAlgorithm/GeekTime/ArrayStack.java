package demo;

/**
 * @author : zyh
 * @Description : 基于数组实现的顺序栈
 * @date : 2018-10-09 23:31
 */
public class ArrayStack {

    private String[] items; //数组
    private int count; // 栈中元素个数
    private int n; //栈大小

    /**
     * 初始化数组，创建一个大小为n的数组
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public boolean push(String item) {
        //数组空间不足，栈已满，直接返回false，入栈失败
        if (count == n) {
            return false;
        }

        //入栈
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop() {
        //栈空，直接返回null
        if (count == 0) {
            return null;
        }

        //出栈
        String tmp = items[count - 1];
        --count;
        return tmp;
    }
}
