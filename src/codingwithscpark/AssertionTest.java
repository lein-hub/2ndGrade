package codingwithscpark;

import java.util.Scanner;

public class AssertionTest {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("��¥�� �Է��Ͻʽÿ�:");
			int date = input.nextInt();
			
			assert(date >= 1 && date <= 31);
			
			System.out.printf("�Էµ� ��¥�� %d �Դϴ�.\n", date);
		}
	}
}
