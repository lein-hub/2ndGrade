package codingwithscpark.collection;
import java.util.*;
import java.util.Map.Entry;

public class PhoneBook {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<String, String> class1 = new TreeMap<>();
		Map<String, String> class2 = new TreeMap<>();
		
		Map<String, Map<String, String>> classes = new TreeMap<>();
		
		class1.put("박동재", "01085057403");
		class1.put("고길동", "01156173558");
		
		class2.put("강감찬", "01045682165");
		class2.put("최무선", "01048613154");
		
		classes.put("c1", class1);
		classes.put("c2", class2);
		
		
//		while (true) {
//			System.out.println("어느반");
//			String c = input.nextLine();
//			if (classes.get(c) == null) {
//				System.out.println("그런반 없다, 다시");
//				continue;
//			}
//			System.out.println("누구");
//			String w = input.nextLine();
//			if (classes.get(c).get(w) == null) {
//				System.out.println("그런애 없다, 다시");
//				continue;
//			}
//			System.out.println(w+":"+classes.get(c).get(w));
//			break;
//		}
//		input.close();
//		System.out.println(class1);
//		System.out.println(class2);
//		System.out.println(classes);
		
		Set<Map.Entry<String, Map<String, String>>> es = classes.entrySet();
		Iterator<Map.Entry<String, Map<String, String>>> iter = es.iterator();
		
		while (iter.hasNext()) {
			Map.Entry<String, Map<String, String>> entry = iter.next();
			System.out.println(entry.getKey());
			Set<Map.Entry<String, String>> set = entry.getValue().entrySet();
			Iterator<Entry<String, String>> iter2 = set.iterator();
			while (iter2.hasNext()) {
				System.out.println(iter2.next());
			}
			
		}
	}
}
