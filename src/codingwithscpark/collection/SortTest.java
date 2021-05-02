package codingwithscpark.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<100; i++) {
			list.add((int)(1+99*Math.random()));
		}
		System.out.println(list);
		System.out.println(selectionSort(list));
	}

	private static <T extends Comparable<T>> List<T> selectionSort(List<T> list) {
		
		for (int i=0; i<list.size(); i++) {
			int idx = i;
			for (int j=i; j<list.size(); j++) {
				if (list.get(idx).compareTo(list.get(j))>0) {
					idx = j;
				}
			}
			T tmp = list.get(idx);
			list.set(idx, list.get(i));
			list.set(i, tmp);
		}
		return list;
	}
	
	private static void test1() {
		ArrayList<Student2> list = new ArrayList<>();
		for (int i=0; i<10; i++) {
			list.add(new Student2("이름"+i, (int)(99*Math.random())));
		}
		for (int i=0; i<list.size(); i++) {
			int idx = i;
			for (int j=i; j<list.size(); j++) {
				if (list.get(idx).compareTo(list.get(j))>0) {
					idx = j;
				}
			}
			Student2 tmp = list.get(idx);
			list.set(idx, list.get(i));
			list.set(i, tmp);
		}
	}
}

class Student2 implements Comparable<Student2> {
	private String name;
	private int grade;
	
	
	@Override
	public String toString() {
		return "[name: "+name+", grade: "+grade+"]";
	}

	public Student2(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
	}

	@Override
	public int compareTo(Student2 o) {
		return this.grade-o.grade;
	}
	
}
