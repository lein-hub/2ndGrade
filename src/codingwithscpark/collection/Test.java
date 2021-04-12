package codingwithscpark.collection;
import java.util.*;
import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
		// HashSet
		// 순서 없고, 중복 허용하지 않는 집합 HashSet
		// LinkedHashSet은 중복은 허용하지 않지만 입력된 순서는 유지된다. (입력된 순서대로 인출된다)
		// TreeSet은 중복은 허용하지 않지만 값의 순서대로 출력된다. (자동 정렬)
		Set<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		
		String[] strArr = {"단어", "중복", "구절", "중복"};
		for (String s : strArr) {
			set.add(s);
		}
		
		System.out.println(set);
		
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		iter = set.iterator();
		System.out.println(iter.next());
		System.out.println("끝...");
	}
	
	private static void test() {
		List<Integer> list = new ArrayList<>();
		IntStream.rangeClosed(1, 10000).forEach(i -> list.add(i));
		
		long startTime = System.currentTimeMillis();
		
		for (int i=0; i<10000; i++) {
			list.add(100, (i+1)*1000);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("elapsed time:" + (endTime-startTime));
	}
	
	public void test0() {
		List<String> list = new ArrayList<>();
		
		list.add("Milk");
		list.add("Bread");
		list.add("Butter");
		System.out.println(list);
		
		list.add(1, "Apple");
		System.out.println(list);
		
		list.set(2, "Grape");
		System.out.println(list);
		
		list.remove(3);
		System.out.println(list);
		
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println();
		
		for (String s : list) {
			System.out.print(s+" ");
		}
		
		System.out.println();
		
		Iterator<String> iter = list.iterator();
		
		while (iter.hasNext()) {
			iter.next();
		}
	}
}
