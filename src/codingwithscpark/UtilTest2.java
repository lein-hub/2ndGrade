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
		
		// Generic �� ��� ����
		// ������ ��� �������� ����ϴ� �������� Ÿ�Ը� �ٸ� ��쿡
		// �ϳ��� Ŭ������ �����Ͽ� ����� �� �ֵ��� �ϱ� ����
		// ������ ����� ������ Ÿ���� ��ü ���� �ÿ� type parameter�� �޾Ƽ� ó��.
		// �׸��� , ������� type casting�� ���ص� �ǵ��� �ϱ� ����
	}
	
	public static void process(ArrayList<? extends Number> list) {
		
	}
	
	public static void process1(ArrayList<Integer> list) {
		
	}
	
	public static void process2(ArrayList<Double> list) {
		
	}
}
