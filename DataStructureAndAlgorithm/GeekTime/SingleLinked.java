package demo;

/**
 * @Description: 单链表的插入、删除、查找操作；链表中存储的是int类型数据；删除、查找不考虑重复。
 * @author: zyh
 * @date: 2018-10-8
 */
public class SingleLinked {
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

    private Node head;

    public Node getHead() {
        return head;
    }

    /**
     * 遍历链表查找指定数值的结点
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node p = head;
        //遍历链表
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    /**
     * 遍历链表查找指定索引的结点
     * 链表不支持根据下标随机访问，需要遍历链表
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    /**
     * 将value插入头结点
     * @param value
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    /**
     * 将Node插入头结点
     * @param newNode
     */
    private void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 将value值插入p结点后
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    /**
     * newNode结点插入p结点后
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 将value值插入p结点前
     * @param p
     * @param value
     */
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    /**
     *  newNode结点插入p结点前
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        //如果p是头结点
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        //遍历链表，找到指向p的next指针
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        //链表中无p结点
        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    /**
     * 删除指定的p结点
     * @param p
     */
    public void deleteByNode (Node p) {
        if (p == null || head == null) {
            return;
        }

        //要删除的p结点为头结点;将已删除的原头结点next引用置null，以便GC。
        if (p == head) {
            Node tmp = head;
            head = head.next;
            tmp.next = null;
        }

        //遍历链表，找到要删除的p结点
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        //链表中无要删除的p结点
        if (q == null) {
            return;
        }

        q.next = q.next.next;
        p.next = null;//将已删除的p结点next引用置null，以便GC。
    }

    /**
     * 删除链表中指定数值value
     * @param value
     */
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;

        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        //链表中无指定value
        if (p == null) {
            return;
        }

        //要删除的value为头结点
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
            p.next = null;//将已删除的p结点next引用置null，以便GC。
        }
    }

    /**
     * 创建结点
     * @param value
     * @return
     */
    public Node createHead(int value) {
       return new Node(value, null);
    }

    /**
     * 打印链表
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.insertToHead(1);

        Node p = singleLinked.getHead();
        singleLinked.insertBefore(p,0);
        singleLinked.insertAfter(p,2);
        singleLinked.printAll();

        singleLinked.deleteByNode(p);
        singleLinked.printAll();

        singleLinked.deleteByValue(2);
        singleLinked.printAll();

    }

}
