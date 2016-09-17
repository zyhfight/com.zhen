package DataStructureAndAlgorithm.Tree;

import java.util.Scanner;

public class BSTree {
	private BSTree rchild, lchild;
	private int data;
	public BSTree(){}
	public BSTree(int data) {
		this.data = data;
	}
	//创建二叉搜索树
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
	//二叉搜索树的搜索
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
	//二叉搜索树的插入
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
	//二叉搜索树的删除
	/*
	 * (1)若结点p有两棵非空子树，需搜索结点p的中序遍历次序下的直接后继结点，设为结点s。将s的值复制到p中，称为替代。
	 * (因为结点s最多只有一棵非空子树，这样问题转化为“被删除的结点最多只有一棵非空子树”的情形)
	 * （2）若结点p只有一棵非空子树或p是叶子结点，以结点p的唯一孩子(设为结点c)或（c=null）取代p。
	 * （3）若被删除的结点p是根结点，则删除后，结点c成为新的根；否则，若p是其双亲q的左孩子，则结点c也应该成为q的左孩子，
	 * 不然，c成为q的右孩子。
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
		}//寻找替代结点
		if(p.lchild!=null){
			c=p.lchild;
		}else{
			c=p.rchild;
		}//实现删除操作
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
