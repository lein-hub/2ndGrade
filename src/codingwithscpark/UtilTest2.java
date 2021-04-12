package codingwithscpark;
import java.util.*;

public class UtilTest2 {

	public static void main(String[] args) {
		Number n = Integer.valueOf(100);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Double> list2 = new ArrayList<Double>();

		ArrayList<Student> list3 = new ArrayList<>();
		
		process1(list);
		process2(list2);
		
		// Generic 의 사용 의의
		// 로직은 길고 내부적을 사용하는 데이터의 타입만 다른 경우에
		// 하나의 클래스만 생성하여 사용할 수 있도록 하기 위해
		// 실제로 사용할 데이터 타입은 객체 생성 시에 type parameter로 받아서 처리.
		// 그리고 , 명시적인 type casting도 안해도 되도록 하기 위해
	}
	
	public static void process(ArrayList<? extends Number> list) {
		
	}
	
	public static void process1(ArrayList<Integer> list) {
		
	}
	
	public static void process2(ArrayList<Double> list) {
		
	}
}
