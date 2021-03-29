package codingwithscpark;

public class BoxTest {

	public static void main(String[] args) {
		Box box = new Box();
		box.setValue("ȫ�浿");
		String v = box.getValue();
		System.out.println(v);
		
		BoxInteger box2 = new BoxInteger();
		box2.setValue(100);
		
		MyBox <String> box1 = new MyBox<>();
		box1.setValue("ȫ�浿");
//		box1.setValue(100);
//		box1.setValue(14.1);
//		box1.setValue(new JFrame());
		
		print(Integer.valueOf(100));
		openBox(box1);
		
	}
	
	private static void print(int val) {
		System.out.println(val);
	}
	
	private static void openBox(MyBox<String> box) {
//		Object obj = box.getValue()	;
		String dble = box.getValue();
		System.out.println(dble);
	}
}
