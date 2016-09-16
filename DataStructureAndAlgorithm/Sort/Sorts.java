package Sort;

import java.util.Stack;

public class Sorts {
	/*
	 * ð������
	 */
	public void bubbSort(int a[])
	{
		if(a==null)return;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[i])
				{
				/*	int temp=a[i];
					a[i]=a[j];
					a[j]=temp;*/
					
					a[i]=a[i]^a[j];
					a[j]=a[i]^a[j];
					a[i]=a[i]^a[j];
					 
				}
			}
		}
	}
	/*
	 * ѡ������
	 */
	public void selectSort(int a[])
	{
		if(a==null)return;
		for(int i=0;i<a.length;i++)
		{
			int minIndex=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[minIndex])
				{
					minIndex=j;
				}
			}
			if(minIndex!=i)
			{
				int temp=a[i];
				a[i]=a[minIndex];
				a[minIndex]=temp;
			}
		}
	}
	/*
	 * ��������
	 */
	public void insertSort(int a[])
	{
		int j=0;
		if(a==null) return;
		for(int i=1;i<a.length;i++)
		{
			int temp=a[i];
			for(j=i;j>0;j--)
			{
				if(a[j-1]>temp)
					a[j]=a[j-1];
				else
					break;
			}
			a[j]=temp;
		}
	}
	/*
	 * ϣ������
	 */
	public void shellSort(int a[])
	{
		int j=0;
		if(a==null) return;
		for(int rise=a.length/2;rise>0;rise/=2)
		{
			for(int i=rise;i<a.length;i++)
			{
				int temp=a[i];
				for(j=i;j>=rise;j-=rise)
				{
					if(a[j-rise]>temp)
						a[j]=a[j-rise];
					else
						break;
				}
				a[j]=temp;
			}
		}
	}
	/*
	 * ��������
	 */
	//��ȡ���ŷָ���
	private int partition(int a[],int low,int high)
	{
		int key=a[low];
		while(low<high)
		{
			while(low<high&&a[high]>=key)
				high--;
			a[low]=a[high];
			while(low<high&&a[low]<=key)
				low++;
			a[high]=a[low];
		}
		a[low]=key;
		return low;
	}
	 //�ݹ�ʵ��
	public void quickSortRecursion(int a[],int low,int high)
	{
		if(a==null) return;
		if(low<high)
		{
			int mid=partition(a,low,high);
			quickSortRecursion(a,low,mid-1);
			quickSortRecursion(a,mid+1,high);
		}
	}
	//�ǵݹ�ʵ��
	public void quickSortNonRecursion(int a[])
	{
		if(a==null) return;
		int low=0,high=a.length-1,mid=0;
		Stack<Integer> stack1=new Stack<Integer>();
		Stack<Integer> stack2=new Stack<Integer>();
		stack1.push(low);
		stack2.push(high);
		while(!stack1.isEmpty())
		{
			low=stack1.pop();
			high=stack2.pop();
			mid=partition(a,low,high);
			if(mid+1<high)
			{
				stack1.push(mid+1);
				stack2.push(high);
			}
			if(mid-1>low)
			{
				stack1.push(low);
				stack2.push(mid-1);
			}
		}
	}
	/*
	 * ������
	 */
	private int heapPartition(int a[],int n)
	{
		for(int i=n/2;i>0;i--)
		{
			if(a[2*i-1]>a[i-1])
			{
				int temp=a[2*i-1];
				a[2*i-1]=a[i-1];
				a[i-1]=temp;
			}
			if(2*i<n&&a[2*i]>a[i-1])
			{
				int temp=a[2*i];
				a[2*i]=a[i-1];
				a[i-1]=temp;
			}
		}
		return a[0];
	}
	public void heapSort(int a[])
	{
		if(a==null) return;
		int n=a.length;
		while(n>1)
		{
			int temp=heapPartition(a,n);
			a[0]=a[n-1];
			a[n-1]=temp;
			n--;
		}
	}
	/*
	 * �鲢����
	 */
	private void mergePartition(int a[],int p,int q,int r)
	{
		int b[]=new int[r-p+1];
		int s=p;
		int t=q+1;
		int k=0;
		while(s<=q&&t<=r)
		{
			if(a[s]<a[t])
				b[k++]=a[s++];
			else
				b[k++]=a[t++];
		}
		while(s<=q)
			b[k++]=a[s++];
		while(t<=r)
			b[k++]=a[t++];
		for(int i=0;i<b.length;i++)
			a[p+i]=b[i];
	}
	public void mergeSort(int a[],int low,int high)
	{
		if(a==null) return;
		if(low<high)
		{
			mergeSort(a,low,(low+high)/2);
			mergeSort(a,(low+high)/2+1,high);
			mergePartition(a,low,(low+high)/2,high);
		}
	}
}
