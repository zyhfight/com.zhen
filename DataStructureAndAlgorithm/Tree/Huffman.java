package DataStructureAndAlgorithm.Tree;
/**
 * 哈夫曼树结构：data结点数值；left、right：左子树、右子树；weight：结点权重
 * @author zhen
 *
 * @param <T>
 */
public class Huffman<T> {
	private Object data;
	private double weight;
	private Huffman<T>left;
	private Huffman<T>right;
	public Huffman(Object data, double weight) {
		super();
		this.data = data;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Huffman [data=" + data + ", weight=" + weight + ", left=" + left + ", right=" + right + "]";
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Huffman<T> getLeft() {
		return left;
	}
	public void setLeft(Huffman<T> left) {
		this.left = left;
	}
	public Huffman<T> getRight() {
		return right;
	}
	public void setRight(Huffman<T> right) {
		this.right = right;
	}
	
}
