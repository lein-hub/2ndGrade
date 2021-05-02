package codingwithscpark.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MyLinkedList {
	
	Node head = null;
	private int size = 0;
	
	public void add(Integer val) {
		Node newNode = new Node();
		newNode.value = val;
		
		if (head == null) {
			head = newNode;
		} else {
			Node tmp = head;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		size++;
	}
	
	private class Node {
		Integer value;
		Node next;
	}
	
	public String toString() {
		String result = "[";
		Node tmp = head;
		while (tmp != null) {
			result += tmp.value+", ";
			tmp = tmp.next;
		}
		result += "]";
		
		return result;
	}
	
	public int size() {
		return size;
	}
	
	public Integer get(int index) {
		int idx = 0;
		Node tmp = head;
		while (idx < index && tmp.next != null) {
			tmp = tmp.next;
			idx++;
		}
		if (idx == index) {
			return tmp.value;			
		} else {
			return null;
		}
	}
	
	public void remove() {
		Node tmp = head;
		if (size <= 1) {
			head = null;
			if (size != 0) size--;
			return;
		}
		while (tmp.next.next != null) {
			tmp=tmp.next;
		}
		tmp.next = null;
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		IntStream.rangeClosed(1,  10).forEach(i -> list.add(i));
		
		System.out.println(list);
		
		Set<Integer> set = new HashSet<>();
		
		

		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove();
		System.out.println(list);
	}
}
