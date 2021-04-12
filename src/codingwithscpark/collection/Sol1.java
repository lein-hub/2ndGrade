package codingwithscpark.collection;

import java.io.*;
import java.util.*;

public class Sol1 {

	public static void main(String[] args) {
		
		coundDistinctWord();
	}
	
	public static void genLotto() {
		Set<Integer> set = new TreeSet<>();
		
		while (set.size()<6) {
			set.add((int)(1+45*Math.random()));
		}
		System.out.println(set);
	}
	
	private static void coundDistinctWord() {
		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		File file = new File("wordbook.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s = null;
			while ((s=br.readLine()) != null) {
				if (map.get(s) == null) map.put(s, 1);
				else map.put(s, map.get(s)+1);
//				System.out.println(s);
				set.add(s);
			}
			System.out.println(set.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<String> set2 = map.keySet();
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + ":" + value + ", ");
		}
	}
}
