package codingwithscpark;

public class ThreadTest {

	public static void main(String[] args) {
		Counter c1 = new Counter(1);
		Counter c2 = new Counter(11);
		
		c1.start();
		c2.start();
		
		System.out.println("main thread over");

	}

}

class Counter extends Thread {
	private int start;
	
	public Counter(int start) {
		this.start = start;
	}
	
	public void run() {
		for (int i = start; i < start + 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(start + "~ " + (start+9) + "까지 count 종료합니다.");
	}
}