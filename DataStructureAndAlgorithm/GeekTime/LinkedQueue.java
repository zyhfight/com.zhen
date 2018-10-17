package demo;

/**
 * @author : zyh
 * @Description : 链表实现队列
 * @date : 2018-10-17 22:26
 */
public class LinkedQueue {
    private static class Node {
        private String data;
        private Node next;
        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    private Node head = null;
    private Node tail = null;

    //入队
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value,null);
            tail = tail.next;
        }
    }

    //出队
    public String dequeue() {
        if (head == null) {//队空
            return null;
        }

        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;//队已空
        }

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
}
