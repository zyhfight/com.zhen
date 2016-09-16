/**
 * ��׺���ʽ->��׺���ʽ
 */
package DataStructureAndAlgorithm.Expression;

import java.util.Stack;

/**
 * 1�������������ɨ����׺���ʽ�и��������������#��ת��6����������� 2���������������
 * 3�������������š���������������ջ�����ֱ�����������š�����Ϊֹ��ע�⣺�����ų�ջ�����������
 * 4���������������������ջ���Ĳ������Ƚ����ȼ�����С��ջ�������������ȼ�����������ջ�����ֱ����������ջ�������������ȼ���������������ջ 5��ת��1��
 * 6�����ջ��ʣ�������������#�����⣩
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
	// ջ�����ȼ�
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

	// ջ�����ȼ�
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
