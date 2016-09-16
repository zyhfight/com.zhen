/**
 * 后缀表达式计算
 */
package DataStructureAndAlgorithm.Expression;

import java.util.Stack;
/**
 * 从左往右顺序扫描后缀表达式，遇到操作数就入栈，遇到操作符就从栈中弹出两个操作数，
 * 执行该操作符规定的运算，并将结果进栈，如此往复，直到遇到“#”结束。
 * 弹出栈顶元素即为结果。此处只讨论双目运算，先弹出的操作数放右边，后出栈放左边。
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
				System.err.println("分母为0！");
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
