package DataStructureAndAlgorithm.Expression;

import java.util.Scanner;

public class InToSuMain {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	InfixToSuffix obj=new InfixToSuffix();
	while(in.hasNext()){
		String str=in.next();
		char ch=str.charAt(0);
		obj.printSuffixExpression(ch);
		if(ch=='#'){
			break;
		}
	}
	in.close();
}
}
