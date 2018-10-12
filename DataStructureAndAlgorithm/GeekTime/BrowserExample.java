package demo;

/**
 * @Description: 使用双栈实现浏览器的前进后退
 * @author: zyh
 * @date: 2018-10-10
 */
public class BrowserExample {

    public static void main(String[] args) {
        BrowserExample browser = new BrowserExample();
        browser.open("www.baidu.com");
        browser.open("www.github.com");
        browser.open("www.gitee.com");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("www.weixin.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.showCurrentPage();
    }

    private String currentPage;
    private LinkedStack backStack;
    private LinkedStack forwardStack;

    public BrowserExample () {
        this.backStack = new LinkedStack();
        this.forwardStack = new LinkedStack();
    }

    /**
     * 打开新页面，后退栈：当前页面入栈；前进栈：清空;新开页无法前进
     * @param url
     */
    public void open(String url) {
        if (this.currentPage != null) {
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url,"Open");
    }

    /**
     * 判断是否可以回退
     * @return
     */
    public boolean canGoBack() {
        return this.backStack.getSize() > 0;
    }

    /**
     * 判断是否可以前进
     * @return
     */
    public boolean canGoForward() {
        return this.forwardStack.getSize() > 0;
    }

    /**
     * 浏览器回退
     * @return
     */
    public String goBack() {
        if (this.canGoBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }

        System.out.println("无法后退");
        return null;
    }

    /**
     * 浏览器前进
     * @return
     */
    public String goForward() {
        if (this.canGoForward()) {
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "Forward");
            return forwardUrl;
        }

        System.out.println("无法前进");
        return null;
    }


    /**
     * 跳转页面
     * @param url
     * @param prefix
     */
    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    //展示当前页
    public void showCurrentPage () {
        System.out.println("Current page is：" + this.currentPage);
    }

    public static class LinkedStack {
        private int size;
        private Node head;

        public int getSize() {
            return size;
        }

        static Node createNode (String data, Node next) {
            return new Node(data, next);
        }

        /**
         * 清空栈
         */
        public void clear() {
            this.head = null;
            this.size = 0;
        }

        /**
         * 入栈
         * @param data
         */
        public void push(String data) {
            //新建结点，插入链表头
            Node node = createNode(data,this.head);
            this.head = node;
            this.size++;
        }

        /**
         * 出栈
         * @return
         */
        public String pop() {
            Node popNode = this.head;
            if (popNode == null) {
                System.out.println("空栈");
                return null;
            }
            this.head = popNode.next;
            if (this.size > 0) {
                this.size--;
            }

            popNode.next = null;
            return popNode.data;
        }

        /**
         * 获取栈顶元素，不出栈。
         * @return
         */
        public String getHeadData () {
            if (this.head == null) {
                return null;
            }

            return this.head.data;
        }

        public static class Node {
            private String data;
            private Node next;

            public Node (String data){
                this(data,null);
            }

            public Node (String data, Node next){
                this.data = data;
                this.next = next;
            }

            public Node getNext() {
                return next;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }
}
