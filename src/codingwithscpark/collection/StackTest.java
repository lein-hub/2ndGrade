package codingwithscpark.collection;
import java.util.*;

public class StackTest {
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		Stack<Character> stack = new Stack<>();
		for (int i = 'a'; i < 'a'+10; i++) {
			stack.push((char)i);
		}
		System.out.println(stack);
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
//		while (stack.size()>0) {
//			Character nextVal = stack.pop();
//			System.out.println(nextVal);
//		}
		
		Iterator<Character> iter = stack.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(stack);
	}
	
}
