package codingwithscpark;

public class MyResource implements AutoCloseable {
	
	public int getValue() throws Exception {
		int val = (int) Math.random()*100;
		if (val > 1) { return val;}
		else { throw new Exception("������ �߻��߽��ϴ�.");}
	}

	@Override
	public void close() throws Exception {
		System.out.println("MyResource closed...");
	}
	
	
}
