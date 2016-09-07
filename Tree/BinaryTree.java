package DataStructureAndAlgorithm.Tree;

import java.util.*;

public class BinaryTree {
	private Stack<BinaryTree> stack = new Stack<>();
	private Queue<BinaryTree> queue = new LinkedList<>();
	private BinaryTree rchild, lchild;
	private int data;
	public BinaryTree() {
	}
	public BinaryTree(int data) {
		this.data = data;
	}
	//创建二叉树
	@SuppressWarnings("resource")
	public BinaryTree createBinaryTree() {
		BinaryTree root = null;
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		if (m > 0) {
			root = new BinaryTree(m);
			root.lchild = createBinaryTree();
			root.rchild = createBinaryTree();
		}
		return root;
	}

	// 递归遍历
	//先序遍历
	public void beforeTraversal(BinaryTree root) {
		if (root != null) {
			System.out.print(root.data);
			beforeTraversal(root.lchild);
			beforeTraversal(root.rchild);
		}

	}
	//中序遍历
	public void centreTraversal(BinaryTree root) {
		if (root == null)
			return;
		centreTraversal(root.lchild);
		System.out.print(root.data);
		centreTraversal(root.rchild);
	}
	//后序遍历
	public void afterTraversal(BinaryTree root) {
		if (root == null)
			return;
		afterTraversal(root.lchild);
		afterTraversal(root.rchild);
		System.out.println(root.data);
	}

	public void frontVisit1(BinaryTree root)// 前序法一
	{
		if (root != null)// 判断该树是否为空
		{
			stack.push(root);// 入栈
		}
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.pop();// 出栈
			visit(root);// 打印根
			if (root.rchild != null) {// 右孩子入栈
				stack.push(root.rchild);
			}
			if (root.lchild != null) {// 左孩子入栈
				stack.push(root.lchild);
			}
		}

	}

	public void frontVisit2(BinaryTree root)// 前序法二
	{
		while (root != null) {// 遍历最左边
			stack.push(root);
			visit(root);
			root = root.lchild;
		}
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.pop();
			if (root.rchild != null) {
				root = root.rchild;
				stack.push(root);// 右孩子入栈；否则会出错！
				visit(root);
				while (root.lchild != null) {
					root = root.lchild;
					stack.push(root);
					visit(root);
				}
			}
		}
	}

	public void centerPrint1(BinaryTree root)// 中序法一
	{
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.lchild;
			} else {
				root = (BinaryTree) stack.pop();
				visit(root);
				root = root.rchild;
			}
		}
	}

	public void centerPrint2(BinaryTree root)// 中序法二
	{
		if (root == null)
			return;
		while (root != null) {
			stack.push(root);
			root = root.lchild;
		}
		while (!stack.isEmpty())// root!=null有此句会出现空指针！
		{
			root = (BinaryTree) stack.pop();
			visit(root);
			if (root.rchild != null) {
				root = root.rchild;
				stack.push(root);
				while (root.lchild != null) {
					root = root.lchild;
					stack.push(root);
				}
			}
		}
	}

	public void centerPrint3(BinaryTree root)// 中序3
	{
		if (root == null)
			return;
		else
			stack.push(root);
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.pop();
			if (root.rchild == null && root.lchild == null) {
				visit(root);
			}
			if (root.rchild != null) {
				stack.push(root.rchild);
			}
			if (root.rchild != null || root.lchild != null) {
				stack.push(new BinaryTree(root.data));
			}

			if (root.lchild != null) {
				stack.push(root.lchild);
			}
		}
	}

	public void centerPrint4(BinaryTree root)// 中序4
	{// root指向的元素均出栈，p指向的元素均打印
		int flag = 0;
		BinaryTree p = null;
		if (root == null)
			return;
		else
			stack.push(root);
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.pop();
			if (root.lchild == null && root.rchild == null) {// 无左右孩
				visit(root);
				p = root;
			}
			if (!stack.isEmpty() && root.rchild != null && root.rchild.equals(stack.peek())) {// 左孩已打印或左孩为空;右孩不空
				visit(root);
				p = root;

			}
			if (root.rchild == null && root.lchild != null && !stack.isEmpty() && root.lchild.equals(p)) {// 右孩空，左孩不空
				visit(root);
				p = root;// 可能使root.lchild.equals(p)无效，所以加flag标志根已打印，其即使有左孩子也不能进栈（已被打印）！
				flag = 1;
				stack.pop();

			}
			if (root.rchild == null && root.lchild != null && !root.lchild.equals(p) && flag != 1) {
				stack.push(root);
				stack.push(root);

			}
			if (root.rchild != null)// 因为root=root.rchild;，所以不用判断右孩子是否被打印
			{
				if ((!stack.isEmpty() && root.rchild.equals(stack.peek()))) {

				} else {
					stack.push(root.rchild);
					stack.push(root);
				}

			}
			if (root.lchild != null && !root.lchild.equals(p) && flag != 1)// 若左孩子已被打印，则不进栈
			{
				if (!stack.isEmpty() && root.rchild != null && root.rchild.equals(stack.peek())) {

				} else {
					stack.push(root.lchild);
				}
			}
			flag = 0;
		}
	}
	public void afterPrint1(BinaryTree root)// 后序法一
	{
		BinaryTree p = null;
		int flag = 0;
		while (root != null || !stack.isEmpty()) {
			if (root != null && flag != 1) {// 访问左孩
				stack.push(root);
				root = root.lchild;
			} // 左根入栈，直到无左孩为止
			else {
				if (!stack.isEmpty()) {
					root = (BinaryTree) stack.peek();
					if (root.lchild == null || root.lchild.equals(p))// root.lchild==null防止出现空指针
					{// 判断是否还有左孩，没有则执行语句，root.lchild.equals(p)代表左孩被打印
						flag = 0;
					}
					if (root.rchild == null || flag == 1 || root.rchild.equals(p))// root.rchild.equals(p)代表右孩子已打印
					{ // 判断是否还有右孩 ，没有则执行语句
						root = (BinaryTree) stack.pop();
						visit(root);
						flag = 1;// 标志此结点被打印
						p = root;// 存储被打印结点
					} else {// 有右孩且未被打印，访问右孩
						root = root.rchild;
					}
				} else {// 栈已空，root指向null；保证可以退出循环
					root = null;
				}
			}
		}
	}
	public void afterPrint2(BinaryTree root)// 后序法二
	{
		BinaryTree p = null;
		int flag = 0;
		while (root != null) {
			stack.push(root);
			root = root.lchild;
		} // 遍历左孩，直到该结点无左孩。
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.peek();// 获取栈顶元素
			if (root.lchild == null || root.lchild.equals(p)) {// 若无左孩或左孩被打印
				flag = 0;
			}
			if (root.rchild != null && flag != 1 && !root.rchild.equals(p)) {// 访问右孩
				root = root.rchild;
				while (root != null) {
					stack.push(root);
					root = root.lchild;
				}
			} else {// 无左右孩或均已被打印，则打印该结点
				root = (BinaryTree) stack.pop();
				visit(root);
				flag = 1;// 标志该结点被打印
				p = root;// 存储被打印结点
			}
		}
	}
	public void afterPrint3(BinaryTree root)// 后序法三
	{
		int flag = 0;
		BinaryTree p = null;
		if (root == null) {
			return;
		} else {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.peek();
			if (root.lchild == null && root.rchild == null) {
				visit(root);
				p = (BinaryTree) stack.pop();// 保存被打印结点
				flag = 1;// 此根被打印
			}
			if (root.rchild == null && root.lchild != null && root.lchild.equals(p)) {
				visit(root);
				p = (BinaryTree) stack.pop();
				flag = 1;
			}
			if (root.rchild != null && root.rchild.equals(p)) {
				visit(root);
				flag = 1;
				p = (BinaryTree) stack.pop();
			}
			if (flag == 0 && root.rchild != null)// 若根被打印或右孩为空则右孩不入栈
			{
				stack.push(root.rchild);
			}
			if (flag == 0 && root.lchild != null) {
				stack.push(root.lchild);
			}
			flag = 0;

		}
	}
	public void hierarchicalTraversal(BinaryTree root)// 层次遍历
	{
		if (root != null)// 根入队
		{
			queue.offer(root);
		} else {
			return;
		}
		while (!queue.isEmpty()) {
			//出队并打印
			root = (BinaryTree) queue.poll();
			visit(root);
			if (root.lchild != null) {
				queue.offer(root.lchild);// 左孩入队
			}
			if (root.rchild != null) {
				queue.offer(root.rchild);// 右孩入队
			}
		}
	}
	private void visit(BinaryTree root) {
		// 打印根（即树）
		System.out.print(root.data + " ");
	}
	
	//叶子数
	public  int leafNum(BinaryTree root){
		if(root!=null){
			if(root.lchild==null&&root.rchild==null){
				return 1;
			}
			return leafNum(root.lchild)+leafNum(root.rchild);
		}
		return 0;
	}
	//二叉树深度
	public int deep(BinaryTree root){
		int h1,h2;
		if(root==null){
			return 0;
		}else{
			h1=deep(root.lchild);
			h2=deep(root.rchild);
			return (h1<h2)?h2+1:h1+1;
		}
	}
}

