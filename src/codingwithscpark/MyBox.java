package codingwithscpark;

public class MyBox <T> {
	T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}
