package codingwithscpark;

public class ExceptionTest {
	
	public static void main (String[] args) {
		String id = "id";
		String pw = "pw";
		
		try {
			login(id, pw);
			System.out.println("ȯ���մϴ�..");
		} catch (LoginIDException e) {
			System.out.println(e.getMessage()+": "+e.getErrorCode());
			System.out.println("�ùٸ� ID�� �Է��Ͻÿ�.");
		} catch (LoginPasswordException e) {
			System.out.println(e.getMessage()+": "+e.getErrorCode());
			System.out.println("�ùٸ� �н����带 �Է��Ͻÿ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void login(String id, String pw) throws LoginIDException, LoginPasswordException {
//		try {
//			checkDB(id, pw);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		checkDB(id, pw);
	}

	private static void checkDB(String id, String pw) throws LoginIDException, LoginPasswordException {
		if (!id.equals("scpark")) {
			// id error
			throw new LoginIDException("ID Error");
		} else if (!pw.equals("1111")) {
			// pw error
			throw new LoginPasswordException("Password Error");
		} else {
			System.out.println("�α��� �Ϸ�");
		}
	}
}
