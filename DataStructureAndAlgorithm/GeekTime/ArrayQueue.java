package demo;

/**
 * @author : zyh
 * @Description : 数组实现队列
 * @date : 2018-10-17 21:53
 */
public class ArrayQueue {

    private String[] items;
    private int n = 0; // 记录数组大小

    private int head = 0; //队头
    private int tail = 0; //队尾

    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队;无法复用空间
    public boolean enqueue(String item) {
        if (tail == n) { //队列已满
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //入队；数据搬移，复用空间
    public boolean enqueue2(String item) {
        if (tail == n) {//队尾没空间了
            if (head == 0) {//tail==n && head==0 表明整个队列都已满
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i-head] = items[i];
            }
            //搬移结束，重新更新head和tail
            tail -= head;
            head = 0;
        }
        //数据入队
        items[tail] = item;
        ++tail;
        return true;
    }

    //循环队列，入队
    public boolean enqueue3(String item) {
        if ((tail + 1) % n == head) {//队列已满
            return false;
        }
        //数据入队
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //循环队列，出队
    public String dequeue2() {
        if (head == tail) {//队列已空
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }


    //出队
    public String dequeue() {
        if (head == tail) {//队列为空
            return null;
        }
        String item = items[head];
        ++head;
        return item;
    }

    //循环队列打印
    public void printAll2() {
        if (n == 0) {
            return;
        }

        for (int i = head; i % n != tail; ++i) {
            System.out.println(items[i] + " ");
        }

        System.out.println();
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.enqueue("1");
        arrayQueue.printAll();
        arrayQueue.enqueue("2");
        arrayQueue.dequeue();
        arrayQueue.printAll();

    }
}
