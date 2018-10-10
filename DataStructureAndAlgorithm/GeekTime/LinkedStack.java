package demo;

/**
 * @Description: 链式栈，可动态扩容
 * @author: zyh
 * @date: 2018-10-10
 */
public class LinkedStack {
    /**
     * 结点类
     */
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    private Node head = null;

    /**
     * 入栈
     * 头结点为栈顶
     * @param value
     */
    public void push(int value) {
        Node newNode = new Node(value,null);

        //栈空
        if (head == null) {
            head = newNode;
        } else { // 栈非空
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 出栈
     * 返回-1表示栈空，没有数据
     * @return
     */
    public int pop(){
        //栈空
        if (head == null) {
            return -1;
        }

        int value = head.data;
        Node tmp = head;
        head = head.next;
        tmp.next = null;

        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.printAll();

        linkedStack.pop();
        linkedStack.printAll();
    }
}
