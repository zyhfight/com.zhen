/**
 * 中缀表达式->后缀表达式
 */
package DataStructureAndAlgorithm.Expression;

import java.util.Stack;

/**
 * 1、从左向右逐个扫描中缀表达式中各项，遇到结束符“#”转（6），否则继续 2、遇到操作数输出
 * 3、若遇到右括号“）”，则连续出栈输出，直至遇到左括号“（”为止（注意：左括号出栈但并不输出）
 * 4、若是其他操作符，则和栈顶的操作符比较优先级，若小于栈顶操作符的优先级，则连续出栈输出，直到遇到大于栈顶操作符的优先级结束，操作符入栈 5、转（1）
 * 6、输出栈中剩余操作符，（“#”除外）
 * 
 * @author zhen
 *
 */
public class InfixToSuffix {
	private Stack<Character>stack=new Stack<>();
	{
		stack.push('#');
	}
	public void printSuffixExpression(char ch){
		if(Character.isDigit(ch)){
			System.out.println(ch);
		}else if(ch==')'){
			for(char c=stack.pop();c!='(';c=stack.pop()){
				System.out.println(c);
			}
		}else{
			char c;
			for( c=stack.pop();icp(ch)<=isp(c);c=stack.pop()){
				if(c!='#'){
					System.out.println(c);
				}else{
					return;
				}
			}
			stack.push(c);
			stack.push(ch);
		}
	
	}
	// 栈外优先级
	public int icp(char ch) {
		int result = 0;
		switch (ch) {
		case '+':
			result = 2;
			break;
		case '-':
			result = 2;
			break;
		case '*':
			result = 4;
			break;
		case '/':
			result = 4;
			break;
		case '(':
			result = 7;
			break;
		case ')':
			result = 1;
			break;
		case '#':
			result = 0;
			break;
		default:
			break;
		}
		return result;
	}

	// 栈内优先级
	public int isp(char ch) {
		int result = 0;
		switch (ch) {
		case '+':
			result = 3;
			break;
		case '-':
			result = 3;
			break;
		case '*':
			result = 5;
			break;
		case '/':
			result = 5;
			break;
		case '(':
			result = 1;
			break;
		case ')':
			result = 7;
			break;
		case '#':
			result = 0;
			break;
		default:
			break;
		}
		return result;
	}

}
