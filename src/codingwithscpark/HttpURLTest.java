package codingwithscpark;

import java.net.*;
import java.io.*;

public class HttpURLTest {

	public static void main(String[] args) {
		String site = "https://www.google.com/search?q=java";
		try {
			URL url = new URL(site);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			int responseCode = con.getResponseCode();
			System.out.println("Response code : " + responseCode);
			
			InputStreamReader isr = new InputStreamReader(con.getInputStream());
			
			BufferedReader reader = new BufferedReader(isr);
			
			String line;
			StringBuffer buf = new StringBuffer();
			while ((line = reader.readLine()) != null ) {
				buf.append(line);
			}
			reader.close();
			
			System.out.println(buf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
