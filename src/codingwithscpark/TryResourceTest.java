package codingwithscpark;
import java.io.*;

public class TryResourceTest {
	
	public static void main (String[] args) {
		writeList();
	}
	
	public static void writeList() {
//		PrintWriter out = null;
//		try {
//			out = new PrintWriter("C:/myfile/outfile.txt");
//			for (int i=0; i<10; i++) {
//				out.println("배열 원소" + i + "=" + i);
//			}
//		} catch (FileNotFoundException e) {
////			System.out.println(e.getMessage());
//			e.printStackTrace();
//		} finally {
//			if (out != null)
//				out.close();
//			System.out.println("파일을 닫았습니다.");
//		}
		
//		try (PrintWriter out = new PrintWriter("outfile.txt")) {
//			for (int i=0; i<10; i++) {
//				out.println("스타크래프트립버전1.16다운로드" + i + "=" + i);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		try (MyResource rc = new MyResource()) {
			System.out.println(rc.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
