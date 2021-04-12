package codingwithscpark.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SetTest2 {
	
	
	public static void main(String[] args) {
//		test1();
		testPriorityQueue();
	}
	
	private static void testPriorityQueue() {
		Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
			
		});
		for (int i=10; i>0; i--) {
			pq.add(i);
		}
		System.out.println(pq);
		
		for (Integer n : pq) System.out.print(n+" ");
		System.out.println();
		
		int length = pq.size();
		for (int i=0; i<length; i++) {
			System.out.println((i+1)+"번째 원소: "+pq.poll()); // poll로 반환받을 때에는 내부적으로 정렬된 뒤 받아온다
		}
	}

	private static void test1() {
		/*
		합집합: addAll()
		교집합: retainAll()
		차집합: removeAll()
		*/
		
		/*
		 * set1 : {1, 3, 4, 5, 7, 9, 10}
		 * set2 : {2, 4, 10}
		 * 
		 * set1 U set2 : {1, 2, 3, 4, 5, 7, 9, 10}
		 * set1 intersection set2 : {4, 10}
		 * set1 - set2 : {1, 3, 5, 7, 9}
		 */
		
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		int[] one = {1, 3, 4, 5, 7, 9, 10};
		int[] two = {2, 4, 10};
		for (int i : one) set1.add(i);
		for (int i : two) set2.add(i);
		
		// 합집합
//		set1.addAll(set2); // 원본(set1)데이터가 변경됨
		Set<Integer> unionSet = new HashSet<>(set1); // 원본 데이터를 유지함
		unionSet.addAll(set2);
		System.out.println(unionSet);
		
		// 교집합
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println(intersectionSet);
		
		// 차집합
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println(diffSet);
		
		// set1이 set2의 원소를 하나도 빠짐없이 다 가지고 있는가?
		System.out.println(set1.containsAll(set2));
		
		if (set1.containsAll(set2)) System.out.printf("집합 %s는 집합 %s의 모든 원소를 포함합니다.\n", set1, set2);
		else System.out.printf("집합 %s는 집합 %s의 모든 원소를 포함하지 않습니다.\n", set1, set2);
		
	}
}
class myComparator2 implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.intValue() - o1.intValue();
	}
}
