package codingwithscpark.collection;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class SolutionCorrectBracket {
	public static void main(String[] args) {
//		String s = "Apple, Grape, Banana, Melon, Strawberry";
		String s = "12 + ( 3 - 2 ) * ( ( 5 * 2 ) / 2 ) 4 + 2 )";
		System.out.println(solution(s));
	}
	
	public static boolean solution(String expression) {
		boolean result = false;
		
//		StringTokenizer st = new StringTokenizer(expression, ", ");
//		while (st.hasMoreTokens()) {
//			System.out.println("[" + st.nextToken()+"]");
//		}
		
		StringTokenizer st = new StringTokenizer(expression);
//		Stack<String> stack = new Stack<>();
//		while (st.hasMoreTokens()) {
//			String nt = st.nextToken();
//			if (nt.equals("(")) stack.push(nt);
//			else if (nt.equals(")")) {
//				if (stack.empty()) return result;
//				stack.pop();
//			}
//		}
//		if (stack.empty()) result = true;
		
		int count = 0;
		while (st.hasMoreTokens() && count >= 0) {
			String nt = st.nextToken();
			if (nt.equals("(")) count++;
			else if (nt.equals(")")) count--;
		}
		if (count == 0) result = true;
		return result;
	}
}
