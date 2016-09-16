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
	//����������
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

	// �ݹ����
	//�������
	public void beforeTraversal(BinaryTree root) {
		if (root != null) {
			System.out.print(root.data);
			beforeTraversal(root.lchild);
			beforeTraversal(root.rchild);
		}

	}
	//�������
	public void centreTraversal(BinaryTree root) {
		if (root == null)
			return;
		centreTraversal(root.lchild);
		System.out.print(root.data);
		centreTraversal(root.rchild);
	}
	//�������
	public void afterTraversal(BinaryTree root) {
		if (root == null)
			return;
		afterTraversal(root.lchild);
		afterTraversal(root.rchild);
		System.out.println(root.data);
	}

	public void frontVisit1(BinaryTree root)// ǰ��һ
	{
		if (root != null)// �жϸ����Ƿ�Ϊ��
		{
			stack.push(root);// ��ջ
		}
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.pop();// ��ջ
			visit(root);// ��ӡ��
			if (root.rchild != null) {// �Һ�����ջ
				stack.push(root.rchild);
			}
			if (root.lchild != null) {// ������ջ
				stack.push(root.lchild);
			}
		}

	}

	public void frontVisit2(BinaryTree root)// ǰ�򷨶�
	{
		while (root != null) {// ���������
			stack.push(root);
			visit(root);
			root = root.lchild;
		}
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.pop();
			if (root.rchild != null) {
				root = root.rchild;
				stack.push(root);// �Һ�����ջ����������
				visit(root);
				while (root.lchild != null) {
					root = root.lchild;
					stack.push(root);
					visit(root);
				}
			}
		}
	}

	public void centerPrint1(BinaryTree root)// ����һ
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

	public void centerPrint2(BinaryTree root)// ���򷨶�
	{
		if (root == null)
			return;
		while (root != null) {
			stack.push(root);
			root = root.lchild;
		}
		while (!stack.isEmpty())// root!=null�д˾����ֿ�ָ�룡
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

	public void centerPrint3(BinaryTree root)// ����3
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

	public void centerPrint4(BinaryTree root)// ����4
	{// rootָ���Ԫ�ؾ���ջ��pָ���Ԫ�ؾ���ӡ
		int flag = 0;
		BinaryTree p = null;
		if (root == null)
			return;
		else
			stack.push(root);
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.pop();
			if (root.lchild == null && root.rchild == null) {// �����Һ�
				visit(root);
				p = root;
			}
			if (!stack.isEmpty() && root.rchild != null && root.rchild.equals(stack.peek())) {// ���Ѵ�ӡ����Ϊ��;�Һ�����
				visit(root);
				p = root;

			}
			if (root.rchild == null && root.lchild != null && !stack.isEmpty() && root.lchild.equals(p)) {// �Һ��գ��󺢲���
				visit(root);
				p = root;// ����ʹroot.lchild.equals(p)��Ч�����Լ�flag��־���Ѵ�ӡ���伴ʹ������Ҳ���ܽ�ջ���ѱ���ӡ����
				flag = 1;
				stack.pop();

			}
			if (root.rchild == null && root.lchild != null && !root.lchild.equals(p) && flag != 1) {
				stack.push(root);
				stack.push(root);

			}
			if (root.rchild != null)// ��Ϊroot=root.rchild;�����Բ����ж��Һ����Ƿ񱻴�ӡ
			{
				if ((!stack.isEmpty() && root.rchild.equals(stack.peek()))) {

				} else {
					stack.push(root.rchild);
					stack.push(root);
				}

			}
			if (root.lchild != null && !root.lchild.equals(p) && flag != 1)// �������ѱ���ӡ���򲻽�ջ
			{
				if (!stack.isEmpty() && root.rchild != null && root.rchild.equals(stack.peek())) {

				} else {
					stack.push(root.lchild);
				}
			}
			flag = 0;
		}
	}
	public void afterPrint1(BinaryTree root)// ����һ
	{
		BinaryTree p = null;
		int flag = 0;
		while (root != null || !stack.isEmpty()) {
			if (root != null && flag != 1) {// ������
				stack.push(root);
				root = root.lchild;
			} // �����ջ��ֱ������Ϊֹ
			else {
				if (!stack.isEmpty()) {
					root = (BinaryTree) stack.peek();
					if (root.lchild == null || root.lchild.equals(p))// root.lchild==null��ֹ���ֿ�ָ��
					{// �ж��Ƿ����󺢣�û����ִ����䣬root.lchild.equals(p)�����󺢱���ӡ
						flag = 0;
					}
					if (root.rchild == null || flag == 1 || root.rchild.equals(p))// root.rchild.equals(p)�����Һ����Ѵ�ӡ
					{ // �ж��Ƿ����Һ� ��û����ִ�����
						root = (BinaryTree) stack.pop();
						visit(root);
						flag = 1;// ��־�˽�㱻��ӡ
						p = root;// �洢����ӡ���
					} else {// ���Һ���δ����ӡ�������Һ�
						root = root.rchild;
					}
				} else {// ջ�ѿգ�rootָ��null����֤�����˳�ѭ��
					root = null;
				}
			}
		}
	}
	public void afterPrint2(BinaryTree root)// ���򷨶�
	{
		BinaryTree p = null;
		int flag = 0;
		while (root != null) {
			stack.push(root);
			root = root.lchild;
		} // �����󺢣�ֱ���ý�����󺢡�
		while (!stack.isEmpty()) {
			root = (BinaryTree) stack.peek();// ��ȡջ��Ԫ��
			if (root.lchild == null || root.lchild.equals(p)) {// �����󺢻��󺢱���ӡ
				flag = 0;
			}
			if (root.rchild != null && flag != 1 && !root.rchild.equals(p)) {// �����Һ�
				root = root.rchild;
				while (root != null) {
					stack.push(root);
					root = root.lchild;
				}
			} else {// �����Һ�����ѱ���ӡ�����ӡ�ý��
				root = (BinaryTree) stack.pop();
				visit(root);
				flag = 1;// ��־�ý�㱻��ӡ
				p = root;// �洢����ӡ���
			}
		}
	}
	public void afterPrint3(BinaryTree root)// ������
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
				p = (BinaryTree) stack.pop();// ���汻��ӡ���
				flag = 1;// �˸�����ӡ
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
			if (flag == 0 && root.rchild != null)// ��������ӡ���Һ�Ϊ�����Һ�����ջ
			{
				stack.push(root.rchild);
			}
			if (flag == 0 && root.lchild != null) {
				stack.push(root.lchild);
			}
			flag = 0;

		}
	}
	public void hierarchicalTraversal(BinaryTree root)// ��α���
	{
		if (root != null)// �����
		{
			queue.offer(root);
		} else {
			return;
		}
		while (!queue.isEmpty()) {
			//���Ӳ���ӡ
			root = (BinaryTree) queue.poll();
			visit(root);
			if (root.lchild != null) {
				queue.offer(root.lchild);// �����
			}
			if (root.rchild != null) {
				queue.offer(root.rchild);// �Һ����
			}
		}
	}
	private void visit(BinaryTree root) {
		// ��ӡ����������
		System.out.print(root.data + " ");
	}
	
	//Ҷ����
	public  int leafNum(BinaryTree root){
		if(root!=null){
			if(root.lchild==null&&root.rchild==null){
				return 1;
			}
			return leafNum(root.lchild)+leafNum(root.rchild);
		}
		return 0;
	}
	//���������
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

