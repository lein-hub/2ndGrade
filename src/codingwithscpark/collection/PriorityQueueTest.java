package codingwithscpark.collection;
import java.util.*;

public class PriorityQueueTest {
	public static void main(String[] args) {
//		test1();
		test2();
	}

	private static void test2() {
		
		// 우선순위 큐에 들어갈 원소를 정렬하는 방법은 2가지가 있다.
		// 1. 그 원소의 클래스에 Comparable 인터페이스를 구현하는 것
		// 2. 우선순위 큐에게 그 원소를 비교하는 방법을 따로 알려주는 것
		//  => Comparator 인터페이스를 구현하는 것이다. (무명 클래스)
		// 참고로, 원소가 Comparable 인터페이스를 구현하고있고, 우선순위 큐에서 원소를 비교하는 방법이 있다면
		// 우선순위 큐의 비교방법을 따라간다.
		
//		Queue<Task> q = new PriorityQueue<>(new Comparator<Task>() {
//
//			@Override
//			public int compare(Task o1, Task o2) {
//				return o2.compareTo(o1);
//			}
//			
//		});
		
		Queue<Task> q = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
		q.add(new Task(5, "작업1"));
		q.add(new Task(1, "작업2"));
		q.add(new Task(2, "작업3"));
		q.add(new Task(4, "작업4"));
		q.add(new Task(6, "작업5"));
		q.add(new Task(3, "작업6"));
		
		Queue<Integer> iq = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
		
		while (q.size()>0) {
			Task task = q.poll();
			System.out.println(task);
		}
		
		
	}

	private static void test1() {
		Queue<Integer> q = new PriorityQueue<>();
		
		// 무작위로 1~100사이의 정수 넣기
		
		for (int i=0; i<100; i++) {
			int rand = (int)(1+100*Math.random());
			q.add(rand);
		}
		// 큐 안의 내용물 출력
		System.out.println(q);
		
		// 큐의 원소를 하나씩 순서대로 빼보자
		while (q.size()>0) {
			System.out.println(q.poll());
		}
	}
}
class Task implements Comparable<Task>{
	int priority;
	String desc;
	
	public Task(int priority, String desc) {
		this.priority = priority;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "[Priority: "+this.priority+", desc: "+this.desc+"]";
	}

	@Override
	public int compareTo(Task o) {
		
		return this.priority-o.priority;
	}
	
}

interface MyInterface {
	void add(int a, int b);
	void print();
}