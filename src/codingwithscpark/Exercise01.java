package codingwithscpark;

import java.util.Scanner;

public class Exercise01 {

	public static void main(String[] args) {
		while(true) {
			try {
				int val = getInput();
				switch (val) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					System.out.println("5이하의 수 : " + val);
					break;
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					System.out.println("10이하의 수 : " + val);
					break;
				default:
					System.out.println("1~10사이의 값을 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("문자 말고 숫자");
			}
		}
		
	}

	private static int getInput() {
		Scanner scanner = new Scanner(System.in);
//		String val = scanner.nextLine();
//		
//		for (int i=0; i<val.length(); i++) {
//			if (!Character.isDigit(val.charAt(i))) {
//				return -1;
//			}
//		}
//		
//		return Integer.parseInt(val);
		
		return scanner.nextInt();
	}
}
