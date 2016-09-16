/**
 * 后缀表达式计算
 */
package DataStructureAndAlgorithm.Expression;
public class SuffixMain {
	public static void main(String[] args) {
		SuffixExpression obj = new SuffixExpression();
		obj.pushOperand(6);
		obj.pushOperand(4);
		obj.pushOperand(2);
		obj.doOperator('-');
		obj.doOperator('/');
		obj.pushOperand(3);
		obj.pushOperand(2);
		obj.doOperator('*');
		obj.doOperator('+');
		double result=obj.getStack().pop();
		System.out.println("计算结果："+result);
	}
}
