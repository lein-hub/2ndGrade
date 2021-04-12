package codingwithscpark;

public class MyArrayTest {
	public static void main(String[] args ) {
		MyArrayList2<Integer> list = new MyArrayList2<>();
		
		for (int i=0; i<100; i++) {
			list.add(i);
		}
		
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		MyArrayList2<Student> list2 = new MyArrayList2<>();
		
		for (int i=0; i<20; i++) {
			list2.add(new Student(i+"", (i+1)*10));
		}
		
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
