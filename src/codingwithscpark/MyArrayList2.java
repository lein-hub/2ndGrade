package codingwithscpark;

public class MyArrayList2 <T> {
	T[] array;
	private int capacity = 10;
	private int size = 0;
	
	public MyArrayList2() {
		array = (T[]) new Object[capacity];
	}
	
	public void add(T value) {
		if (size >= capacity) {
			int increasedCapacity = (int)(capacity * 1.5);
			T[] tmpArray = (T[]) new Object[increasedCapacity];
			
//			for (int i=0; i<size; i++) {
//				tmpArray[i] = array[i];
//			}s
			
			System.arraycopy(array, 0, tmpArray, 0, size);
			array = tmpArray;
			capacity = increasedCapacity;
			
		}
		array[size++] = value;
			
			
	}
	
	public int size() {
		return size;
	}
	
	public void add(T value, int idx) {
		
	}
	
	public void remove(int idx) {
		
	}
	
	public T get (int idx) {
		if (idx <= size) return array[idx];
		else return null;
	}
}
