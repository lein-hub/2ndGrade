package codingwithscpark.collection;
import java.util.*;

public class DequeTest {
	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();
		
		for (int i=1; i<=10; i++) {
			dq.add(i);
//			dq.push(i);
//			dq.addFirst(i);
//			dq.addLast(i);
		}
//		dq.pop();
//		dq.remove();
		
		dq.removeFirst();
//		dq.removeLast();
		
		System.out.println(dq.peekFirst());
		
		while (dq.size()!=0) {
			Integer val = dq.poll();  // First in First out
//			Integer val = dq.pollLast(); // Last in First out
			System.out.println(val);
		}
	}
}
