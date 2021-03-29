package codingwithscpark;

import java.util.Arrays;

public class UtilTest {

	public static void main(String[] args) {
		Integer[] arr = {3,4,2,10,38,76,92,124,13,25};
		Double[] arr2 = {3.0,4.0,2.0,10.0,38.0,76.0,92.0,124.0,13.0,25.0};
		String[] arr3 = {"가나다", "라마바", "사아자", "차카타", "파하"};
		Student[] arr4 = {new Student("Alice", 78), new Student("Bera", 90), new Student("Clara", 37)};
		
		System.out.println(Util.getMax(arr));
		Util.println(arr);
		
		Util.printValueOfMultifly5(15);
		
		Util.printSum(Arrays.asList(arr));
	}
}
