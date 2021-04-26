package codingwithscpark.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapTest3 {
	
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		String sample = "What a radical idea, the great gift that our Founders gave to us. " +
				"The freedom to chase our individual dreams through our sweat, and toil, " +
				"and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
				"For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
				"It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
				"It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
				"It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
				"It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
				"Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";
		
		StringTokenizer st = new StringTokenizer(sample, " -.,;");
		
		Map<String, Integer> map = new HashMap<>();
		
		while (st.hasMoreTokens()) {
			String key = st.nextToken();
			Integer value = map.get(key);
			map.put(key, value==null?1:value+1);
		}
		System.out.println(map.size() + "개의 단어가 있습니다.");
		System.out.println(map);
		
		TreeSet<String> ts = new TreeSet<>();
		for (String key : map.keySet()) {
			ts.add(key);
		}
		System.out.println(ts);
		
//		PriorityQueue<String> pq = new PriorityQueue<>();
//		for (String key : map.keySet()) {
//			pq.add(key);
//		}
//		while (!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		Set<Map.Entry<String, Integer>> et = map.entrySet();
//		List<Integer> list = new ArrayList<>();
//		for (int i=10; i>0; i--) list.add(i);
		
		
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
		Iterator<Map.Entry<String, Integer>> iter = et.iterator();
		
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		System.out.println("정렬하기 전");
		System.out.println(list);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				return o2.getValue()-o1.getValue();
			}
			
		});
		System.out.println("정렬 후");
		System.out.println(list);
	}
}
