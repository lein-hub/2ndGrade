package codingwithscpark;

import java.net.*;
import java.io.*;

public class URLConnectionReader {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			// 1. URL 객체를 생성
			URL site = new URL("https://www.naver.com");
			
			// 2. 연결 설립
			URLConnection url = site.openConnection();
			
			// 버퍼드리더 = 버퍼드리더(인풋스트림리더(인풋스트림))
			reader = new BufferedReader(new InputStreamReader(url.getInputStream()));
			// 왜 버퍼드리더를 쓰냐?
			// 인풋스트림 리더는 읽어낼 때 귀찮은 과정이 많다.
			
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception ignore) {
				
			}
		}
	}
}
