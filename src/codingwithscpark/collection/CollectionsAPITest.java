package codingwithscpark.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsAPITest {
	public static void main(String[] args) {
//		sortTest();
//		shuffleTest();
//		String a = "abc";
//		String b = "acf";
//		System.out.println(a.compareTo(b));
		
		binarySearch();
	}
	
	private static void binarySearch() {
		List<Integer> list = new ArrayList<>();
		int num = 15;
		for (int i=0; i<=10000; i++) {
			list.add(i);
		}
//		int idx = Collections.binarySearch(list, 7);
//		
//		if (idx >= 0) {
//			System.out.println((idx+1)+"번째 위치에 있습니다.");
//		} else {
//			System.out.println("리스트에 존재하지 않습니다.");
//		}
		System.out.println(myBinarySearch2(list, num));
		find(list, num);
	}
	
	public static int myBinarySearch2(List<Integer> list, Integer key) {
		int left = 0;
		int right = list.size()-1;
		
		// left가 right이하인 동안 다음을 반복
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) == key) return mid;
			else if (list.get(mid) > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left*(-1); // 이 값의 절대값이 key가 와야될 위치.
	}

	private static <T extends Comparable<T>> void find(List<T> list, T num) {
		T result = null;
		int count = 0;
		int left = 0, right = list.size()-1;
		int mid = 0;
		int limit = (int)Math.ceil((Math.log(list.size()) / Math.log(2)));
		while (true) {
			mid = (left + right) / 2;
			result = list.get(mid);
			
			if (result.compareTo(num) > 0) right = mid-1;
			else if (result.compareTo(num) < 0) left = mid+1;
			
			count++;
			
			if (count > limit) {
				System.out.println("리스트에 존재하지 않습니다.");
				break;
			} else if (result == num) {
				System.out.println(mid+"번 인덱스, "+count+"번 탐색");
				break;
			}
		}
		
	}

	private static void shuffleTest() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=1; i<=10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		System.out.println("After shuffling");
		Collections.shuffle(list);
		
		System.out.println(list);
	}

	public static void sortTest() {
		String[] sample = {"i", "walk", "the", "line"};
		
		List<String> list = Arrays.asList(sample);
		sortTest(list);
		
//		Collections.sort(list, (o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));
		System.out.println(list);
	}

	private static <T extends Comparable<T>> List<T> sortTest(List<T> list) {
		T temp;
		for (int i=0; i<list.size()-1; i++) {
			int result = list.get(i).compareTo(list.get(i+1));
			if (result > 0) {
				temp = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
			}
		}
		
		return list;
	}

}
