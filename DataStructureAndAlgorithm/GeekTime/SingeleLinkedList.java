package demo;

/**
 * @Description: 1）单链表反转 2）链表中环的检测
 *               3）两个有序的链表(从小到打)合并 4）删除链表倒数第k个结点
 *               5）求链表的中间结点
 * @author: zyh
 * @date: 2018-10-8
 */
public class SingeleLinkedList {
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

    /**
     * 单链表反转
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }

            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }

    /**
     * 检查环;如果有环，fast和slow最终一定会相遇
     * @param head
     * @return
     */
    public boolean checkCircle(Node head) {

        if (head == null) {
            return false;
        }

        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     *  两个有序的链表合并，顺序增长。
     * @param la
     * @param lb
     * @return
     */
    public Node mergeSortedLink(Node la,Node lb) {
        if (la == null) {
            return lb;
        }

        if (lb == null) {
            return la;
        }

        Node p =la;
        Node q = lb;
        Node head;

        //确定头结点
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node r = head;

        //遍历链表，按数值顺序移动指针；
        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }

            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    /**
     * 删除倒数第k个结点；
     * 找到倒数第k个结点，然后删除。
     * 先找到第k个结点，然后从第k个结点往后遍历；fast结点到链尾，slow结点就是倒数第k个结点
     * @param head
     * @param k
     * @return
     */
    public Node deleteLastKNode(Node head, int k) {
        Node fast  = head;
        int i = 1;
        //找到第k个结点
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        //链表长度小于k
        if (fast == null) {
            return head;
        }

        Node slow = head;
        Node preNode = null;

        //找到倒数第k个结点：slow；preNode存储倒数第k个结点的前置结点
        while (fast.next != null) {
            fast = fast.next;
            preNode = slow;
            slow = slow.next;
        }

        if (preNode == null) { //删除头结点
            head = head.next;
        } else { //删除倒数第k个结点
            Node tmpNode = preNode;
            preNode.next = preNode.next.next;
            tmpNode.next = null;
        }

        return head;
    }

    /**
     * 查找中间结点
     * @param head
     * @return
     */
    public Node findMinddleNode(Node head) {
        if (head == null) {
            return head;
        }

        Node fast = head;
        Node slow = head;

        //fast每次前进2个结点，slow每次前进1个结点，fast遍历结束，slow刚好处于中间位置
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
