package DataStructureAndAlgorithm.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
/**
 * �ù������㷨����������������Ϊ������������or��������
 * �������㷨��
 * 1���ø�����һ��Ȩֵ{w1��w2 ... wn}������һ����n������ɵ�ɭ��F={T1��T2�� ... Tn}������ÿ�ö�����Tiֻ��һ����㣬��ȨֵΪwi�ĸ��ڵ㣨Ҳ��Ҷ�ӣ�
 * 2����F��ѡ�����ø����Ȩֵ��С��������Ϊ��������������������������Ȩֵ����������������Ȩֵ֮��
 * 3����F��ɾ�����������������¶���������F��
 * 4���ظ���2����3����ֱ��F��ֻ����һ����Ϊֹ
 * 
 * �����������ࣺcreateHuffmanTree����������������breadthFirst��������ȱ���
 * @author zhen
 *
 */
public class HuffmanTree {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Huffman<T> createHuffmanTree(List<Huffman<T>>huffmans){
		if(huffmans==null||huffmans.size()==0){
			return null;
		}
		if(huffmans.size()==1){
			return huffmans.get(0);
		}
		while(huffmans.size()>1){
			Collections.sort(huffmans,new SortHuffman());
			Huffman<T>left=huffmans.get(huffmans.size()-1);
			Huffman<T>right=huffmans.get(huffmans.size()-2);
			Huffman<T>parent=new Huffman<T>(null, left.getWeight()+right.getWeight());
			parent.setLeft(left);
			parent.setRight(right);
			huffmans.remove(left);
			huffmans.remove(right);
			huffmans.add(parent);
		}
		return huffmans.get(0);
		
	}
	public static <T> List<Huffman<T>> breadthFirst(Huffman<T>root){
		if(root==null){
			return null;
		}
		List<Huffman<T>>list=new ArrayList<>();
		Queue<Huffman<T>>queue=new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			list.add(queue.peek());
			Huffman<T> parent=queue.poll();
			if(parent.getLeft()!=null){
				queue.offer(parent.getLeft());
			}
			if(parent.getRight()!=null){
				queue.offer(parent.getRight());
			}
		}
		return list;
	}
}
class SortHuffman<T> implements Comparator<Huffman<T>>{

	@Override
	public int compare(Huffman<T> o1, Huffman<T> o2) {
		return o1.getWeight()>o2.getWeight()?-1:o1.getWeight()<o2.getWeight()?1:0;
	}

	

	
}
