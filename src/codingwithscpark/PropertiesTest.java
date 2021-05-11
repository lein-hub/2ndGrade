package codingwithscpark;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class PropertiesTest {
	
	public static void main(String[] args) {
//		Map<String, String> env = System.getenv();
//		Set<String> keys = env.keySet();
//		for (String key : keys) {
//			System.out.println(key + " : " + env.get(key));
//		}
		
		
		// Properties는 <key, value>의 타입이 각각 String, String으로 고정된 일종의 Map객체이다
		
		
		Properties props = new Properties();
		try (FileReader reader = new FileReader("dict.props")) {
			props.load(reader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		props.put("name", "홍길동");
//		props.put("age", "20");
		
		Set<Object> keys = props.keySet();
		for (Object key : keys) {
			System.out.println(key + " : " + props.get(key));
		}
		
		props.put("나무", "tree");
		props.put("사과", "apple");
		try (PrintWriter out = new PrintWriter(new File("dict.props"))) {
			props.store(out, "My Dictionary");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
