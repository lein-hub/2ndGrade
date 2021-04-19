package codingwithscpark.collection;
import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * 	Map 인터페이스이고 요놈을 구현한 구현 클래스가
		 * 	HashMap, TreeMap, LinkedHashMap 3개가 있다.
		 * 	그래서 Map 타입의 변수는 위의 3개 타입의 객체를
		 * 	수용할 수 있다.
		 * 	Map은 값을 <key, value> 쌍으로 저장한다.
		 * 	Map은 Generic이다.
		 * 
		 * 	Generic이란?
		 * 	클래스, 메소드 내부에서 사용할 데이터타입을 정하지 않고
		 * 	실제 그 클래스의 객체를 만들거나 메소드를 호출할 때
		 *  사용할 데이터 타입을 파라미터로 받아서 처리하는 것.
		 */
		Map<String, Student> st = new HashMap<>();
		
		// Map에 원소 (<key, value>로 구성된 entry)를 넣을 때는
		// put 메소드를 사용 : put 메소드는 원소 삽입과 변경에 모두 사용된다.
		// Map에서 원소(엔트리)를 읽을 때는 get(key) 메소드를 사용
		
		// 이미 존재하는 키값으로 put 하면 기존 value에 덮어씌운다
		
		st.put("20201234", new Student(20201234, "홍길동"));
		st.put("20201235", new Student(20201235, "일지매"));
		st.put("20201236", new Student(20201236, "성춘향"));
		st.put("20201239", new Student(20201237, "이몽룡"));
		st.put("20201238", new Student(20201238, "임꺽정"));
		
		System.out.println(st);
		Student std = st.get("20201237");
		System.out.println(std);
		
		// map 객체에게 니가 가진 key값 다 줘...
		Set<String> keyset = st.keySet();
		System.out.println(keyset);
		// keyset에 있는 각 원소를 통해서 map에게 값을 요구하면 된다.
		// 왜냐하면 그 원소가 map에 저장된 값을 key니까
		
		Iterator<String> iter = keyset.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Student stdd = st.get(key);
			System.out.println(stdd);
		}
		
		Set<Map.Entry<String, Student>> entrySet = st.entrySet();
		
		Iterator<Map.Entry<String, Student>> iter2 = entrySet.iterator();
		
		while (iter2.hasNext()) {
			Map.Entry<String, Student> entry = iter2.next();
			String mykey = entry.getKey();
			Student mystd = entry.getValue();
			System.out.println("key:"+mykey+", value:"+mystd);
		}
	}
}

class Student {
	int number;
	String name;
	
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[number: "+number+", name: "+name+"]";
	}
	
	
}