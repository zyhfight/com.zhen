package demo;

/**
 * @author : zyh
 * @Description : 数组的插入、删除、按照下标随机访问；数组中的数据是int类型的；
 * @date : 2018-10-04 15:11
 */
public class ArrayTest {

    public static void main(String[] args) {
//        array();

        ArrayTest arrayTest = new ArrayTest(10);
        arrayTest.insert(0, 0);
        arrayTest.insert(1, 1);
        arrayTest.insert(2, 2);
        arrayTest.printAll();
        arrayTest.delete(4);
        arrayTest.printAll();
        arrayTest.insertToTail(3);
        arrayTest.printAll();

    }

    private int data[];
    private int n; //存储数组length
    private int count; //存储数组元素个数 

    public ArrayTest (int capacity) {
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    /**
     * 根据下标随机访问
     * @param index
     * @return
     */
    public int find (int index) {
        if (index < 0 || index >= count){
            return -1;
        }

        return data[index];
    }

    public boolean delete (int index) {

        if (index < 0 || index >= n) {
            return false;
        }

        //index后的元素向前顺移
        for (int i = index + 1; i < count; ++i){
            data[i-1] = data[i];
        }

        //数组中元素个数-1
        --count;

        return true;
    }


    public boolean insert (int index, int value) {

        if (index < 0 || index >= n) {
            return false;
        }

        if (count == n) {
            return false;
        }

        //数组index后的元素向后顺移
        for (int i = count -1; i >= index; --i){
            data[i+1] = data[i];
        }

        data[index] = value;

        //数组中元素个数+1
        ++count;

        return true;

    }

    public boolean insertToTail (int value) {

        if (count == n){
            return false;
        }

        data[count++] = value;

        return true;
    }

    public void printAll () {
        for (int i = 0; i < count; ++i) {
            System.out.println(data[i] + " ");
        }
        System.out.println();
    }

    /**
     * java.lang.ArrayIndexOutOfBoundsException
     * @return
     */
    static int array () {
        int i = 0;
        int[] arr = new int[3];
        for(; i <= 3; i++){
            arr[i] = 0;
            System.out.println("hello world!");
        }
        return 0;
    }
}
