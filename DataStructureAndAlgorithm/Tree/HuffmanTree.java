package DataStructureAndAlgorithm.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
/**
 * 用哈夫曼算法构造的扩充二叉树称为哈夫曼编码树or哈夫曼树
 * 哈夫曼算法：
 * 1、用给定的一组权值{w1，w2 ... wn}，生成一个有n棵树组成的森林F={T1，T2， ... Tn}，其中每棵二叉树Ti只有一个结点，即权值为wi的根节点（也是叶子）
 * 2、从F中选择两棵根结点权值最小的树，作为新树根的左、右子树，新树根的权值是左、右子树根结点的权值之和
 * 3、从F中删除这两棵树，并将新二叉树加入F中
 * 4、重复（2）（3），直至F中只包含一棵树为止
 * 
 * 哈夫曼树主类：createHuffmanTree：创建哈夫曼树；breadthFirst：宽度优先遍历
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
