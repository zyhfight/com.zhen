package DataStructureAndAlgorithm.Tree;

import java.util.Scanner;

public class BSTree {
	private BSTree rchild, lchild;
	private int data;
	public BSTree(){}
	public BSTree(int data) {
		this.data = data;
	}
	//��������������
	@SuppressWarnings("resource")
	public BSTree createBSTree() {
		BSTree root = null;
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		if (m > 0) {
			root = new BSTree(m);
			root.lchild = createBSTree();
			root.rchild = createBSTree();
		}
		return root;
	}
	//����������������
	public BSTree search(int x,BSTree root){
		BSTree p=root;
		while(p!=null){
			if(x<p.data){
				p=p.lchild;
			}else if(x>p.data){
				p=p.rchild;
			}else{
				System.out.println("Success search!");
				return p;
			}
		}
		System.out.println("No present!");
		return null;
	}
	//�����������Ĳ���
	public void insert(int x,BSTree root){
		BSTree p=root,q=null;
		while(p!=null){
			q=p;
			if(x<p.data){
				p=p.lchild;
			}else if(x>p.data){
				p=p.rchild;
			}else{
				System.out.println("Duplicate!");
			}
		}
		p=new BSTree(x);
		if(root==null){
			root=p;
		}else if(x<q.data){
			q.lchild=p;
		}else{
			q.rchild=p;
		}
		System.out.println("Success insert!");
	}
	//������������ɾ��
	/*
	 * (1)�����p�����÷ǿ����������������p��������������µ�ֱ�Ӻ�̽�㣬��Ϊ���s����s��ֵ���Ƶ�p�У���Ϊ�����
	 * (��Ϊ���s���ֻ��һ�÷ǿ���������������ת��Ϊ����ɾ���Ľ�����ֻ��һ�÷ǿ�������������)
	 * ��2�������pֻ��һ�÷ǿ�������p��Ҷ�ӽ�㣬�Խ��p��Ψһ����(��Ϊ���c)��c=null��ȡ��p��
	 * ��3������ɾ���Ľ��p�Ǹ���㣬��ɾ���󣬽��c��Ϊ�µĸ���������p����˫��q�����ӣ�����cҲӦ�ó�Ϊq�����ӣ�
	 * ��Ȼ��c��Ϊq���Һ��ӡ�
	 */
	public void remove(int x,BSTree root){
		BSTree c,s,r,p=root,q=null;
		while(p!=null&&p.data!=x){
			q=p;
			if(x<p.data){
				p=p.lchild;
			}else{
				p=p.rchild;
			}
		}
		if(p==null){
			System.out.println("No present!");
		}
		x=p.data;
		if(p.lchild!=null&&p.rchild!=null){
			s=p.rchild;
			r=p;
			while(s.lchild!=null){
				r=s;
				s=s.lchild;
			}
			p.data=s.data;
			p=s;
			q=r;
		}//Ѱ��������
		if(p.lchild!=null){
			c=p.lchild;
		}else{
			c=p.rchild;
		}//ʵ��ɾ������
		if(p==root){
			root=c;
		}else if(p==q.lchild){
			q.lchild=c;
		}
		else{
			q.rchild=c;
		}
		System.out.println("Success delete!");
	}
	public void printBSTree(BSTree root) {
		if (root == null)
			return;
		printBSTree(root.lchild);
		System.out.print(root.data+" ");
		printBSTree(root.rchild);
	}
}
