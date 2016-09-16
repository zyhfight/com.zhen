/**
 * ��׺���ʽ����
 */
package DataStructureAndAlgorithm.Expression;

import java.util.Stack;
/**
 * ��������˳��ɨ���׺���ʽ����������������ջ�������������ʹ�ջ�е���������������
 * ִ�иò������涨�����㣬���������ջ�����������ֱ��������#��������
 * ����ջ��Ԫ�ؼ�Ϊ������˴�ֻ����˫Ŀ���㣬�ȵ����Ĳ��������ұߣ����ջ����ߡ�
 * @author zhen
 *
 */
public class SuffixExpression {
	private Stack<Double>stack=new Stack<>();
	public Stack<Double> getStack() {
		return stack;
	}

	public void setStack(Stack<Double> stack) {
		this.stack = stack;
	}
	public void pushOperand(double op){
		stack.push(op);
	}
	public void doOperator(char ch){
		if(stack.isEmpty()||stack.size()==1){
			return;
		}
		double frontOperator,rearOperator;
		rearOperator=stack.pop();
		frontOperator=stack.pop();
		switch (ch) {
		case '+':
			stack.push(frontOperator+rearOperator);
			break;
		case '-':
			stack.push(frontOperator-rearOperator);
			break;
		case '*':
			stack.push(frontOperator*rearOperator);
			break;
		case '/':
			if(Math.abs(rearOperator)<1e-6){
				System.err.println("��ĸΪ0��");
				stack.clear();
			}else{
				stack.push(frontOperator/rearOperator);
			}
			break;
		case '^':
			stack.push(Math.pow(frontOperator, rearOperator));
			break;
		default:
			break;
		}
		
	}
}
