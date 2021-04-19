package codingwithscpark.collection;
import java.util.*;

public class MapTest2 {
	
	public static void main(String[] args) {
		String[] str = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		// Map에다가 단어를 키로, 그 단어가 출현한 횟수를 값으로 저장.
		// Generic의 타입 파라미터는 기본 타입을 허용하지 않는다.
		
		Map<String, Integer> map = new HashMap<>();
		// str 배열에 각 원소에 대해서
		// 그 원소를 키(key)로 가지는 엔트리가 있는지 검사
		// 만약에 그러한 엔트리가 있으면
		//			있다라는 것은 map.get(key)가 반환디는 값이 null이 아니라는 의미
		//			Integer count = map.get(key); // Integer 값인데 int 변수에 넣어도 돼?
		//									  // auto unboxing...
		//									  // 객체타입의 값을 대응되는 기본 타입의 변수에 저장하려고 하면
		//									  // 자바는 자동으로 그 객체타입의 값을 기본 타입의 값으로 변환.
		
		
		// 그러한 에트리가 없으면
		// 			이 key에 해당하는 단어는 처음 나온거다. 그럼, map에 추가한다.
		//			map.put(key, 1); // 자바는 auto boxing.. -> 기본 타입 값을 대응되는 객체 타입 값으로 자동변환
		
		for (String key : str) {
			Integer count = map.get(key);
			if (count != null) {
				map.put(key, count+1);
			} else {
				map.put(key, 1);
			}
		}
	}
}
