package codingwithscpark;

import java.net.*;
import java.io.*;

public class HttpURLPostTest {
	public static void main(String[] args) {
		String site = "http://localhost:9090/todos";
		try {
			URL url = new URL(site);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setDefaultUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			
			con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("id=scpark").append("&pw=1111");
			
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
			writer.println(buffer.toString());
			writer.flush();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
