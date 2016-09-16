package Linked;

import java.util.Scanner;

class Node{
	Node next;
	int data;
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}
public class LinkedList {
	/*
	 * 头插法建单链表
	 */
	public Node createHeadLinked()
	{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		Node p = null,head = null;
		int m=in.nextInt();
		while(m>0)
		{
			if(p==null)
			{
				p=new Node(m);
				head=p;
			}else
			{
				head=new Node(m);
				head.next=p;
				p=head;
			}
			
			m=in.nextInt();
		}
		return head;
				
	}
	/*
	 * 打印头插法链表
	 */
	public void printLinked(Node head)
	{
		while(head!=null)
		{
			if(head.next!=null)
			{
				System.out.print(head.data+"-->");
				head=head.next;
			}else
			{
				System.out.print(head.data);
				head=head.next;
			}
			
		}
	}
	/*
	 * 链表插入
	 * 
	 */
	public Node insertLinked(int m,Node head)
	{
		if(head==null) return head;
		Node p=head,q=p;
		/*
		 * 插在头部情况
		 */
		if(m<=p.data)
		{
			Node in=new Node(m);
			head=in;
			in.next=p;	
			return head;
		}
		/*
		 * 插在中间情况
		 */
		while(q!=null)
		{
			q=p.next;
			if(q==null)
				break;
			if(q!=null&&m<=q.data)
			{
				Node in=new Node(m);
				in.next=q;
				p.next=in;
				return head;
			}
			p=p.next;
		}
		/*
		 * 插在末尾情况
		 */
		if(q==null&&p!=null)
		{
			p.next=new Node(m);
		}
		return head;
	}
	/*
	 * 链表删除
	 */
	public Node deleteLinked(int m,Node head)
	{
		if(head==null)return null;
		Node p,q;
		p=head;
		q=head.next;
		while(p!=null&&q!=null&&p.data==m)
		{
			p=q;
			q=p.next;
			head=p;
		}
		while(q!=null)
		{
			while(q!=null&&q.data==m)
			{
				p.next=q.next;
				q=q.next;
			}
			if(q==null)
				break;
			p=q;
			q=p.next;
		}
		if(p!=null&&p.data==m&&head==p)
		{
			p=null;
			head=p;
		}
		return head;
	}
	/*
	 * 链表逆置
	 */
	public Node reverseLinked(Node head)
	{
		if(head==null)return null;
		Node p,q;
		p=head.next;
		q=p;
		head.next=null;
		while(p!=null)
		{
			p=q;
			if(p==null)
				return head;
			q=p.next;
			p.next=head;
			head=p;
		}
		return head;
	}
	/*
	 * 链表合并
	 */
	public Node mergeLinked(Node head1,Node head2)
	{
		if(head1==null&&head2==null) return null;
		if(head1!=null&&head2==null) return head1;
		if(head1==null&&head2!=null) return head2;
		Node h1=head1,h2=head2;
		Node p=null,head=null;
		while(h1!=null&&h2!=null)
		{
			if(h1.data<h2.data)
			{
				if(head==null)
				{
					head=h1;
					p=h1;
				}else
				{
	//				h1=p.next;
					p.next=h1;
	//				h1=p;
					p=h1;
				}
				h1=h1.next;
			}	
			else if(h1.data>=h2.data)
			{
				if(head==null)
				{
					head=h2;
					p=h2;
				}else
				{
	//				h2=p.next;
					p.next=h2;
	//				h2=p;
					p=h2;
				}
				h2=h2.next;
			}
		}
		if(h1!=null)
			p.next=h1;
		if(h2!=null)
			p.next=h2;
		return head;
	}
	/*
	 * 尾插法建链表
	 */
	public Node createTailLinked()
	{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		Node p = null,q = null,head = null;
		int m=in.nextInt();
		while(m>0)
		{
			if(p==null)
			{
				p=new Node(m);
				q=p;
				head=p;
			}else
			{
				p=new Node(m);
				q.next=p;
				q=p;
			}
			m=in.nextInt();
			
		}
		return head;
	}
}
