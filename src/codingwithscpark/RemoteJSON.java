package codingwithscpark;

import java.net.*;
import java.io.*;
import com.google.gson.*;
import java.net.*;
import java.sql.*;

public class RemoteJSON {
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/oop3";

	public static void main(String[] args) throws Exception {
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);
		
		URLConnection con = url.openConnection();
		
		InputStream stream = con.getInputStream();
		
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(stream));
		
		String line = null;
		StringBuffer buf = new StringBuffer();
		while ((line = buffReader.readLine()) != null) {
			System.out.println(line);
			buf.append(line);
		}
		
		Gson gson = new Gson();
//		Person person = gson.fromJson("{'name':'gison', 'age':10, 'isGraduated':true}", Person.class);
//		
//		System.out.println(person.getName());
//		System.out.println(person.getAge());
//		System.out.println(person.isGraduated());
		
		Post[] posts = gson.fromJson(buf.toString(), Post[].class);
		
		
//		insertIntoDB(posts);
		
		
		insertIntoDB(posts);
		
		
		
		buffReader.close();
	}

	private static void insertIntoDB(Post[] posts) {
		/*
		 * create table posts (
		 * userId int,
		 * id int primary key,
		 * title varchar(20),
		 * body text
		 */
		
		try {
			Class.forName(JDBC_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(DB_URL, "root", "")) {
			String sql = "insert into posts values(?, ?, ?, ?)";
			
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			for (Post post : posts) {
				pst.setInt(1, post.getUserId());
				pst.setInt(2, post.getId());
				pst.setString(3, post.getTitle());
				pst.setString(4, post.getBody());
				pst.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Person {
	// JavaBean 형태로 클래스를 정의
	// 1. private 멤버 변수에 대한 public getter와 setter를 가진다.
	// 2. default 생성자를 가진다.
	
	private String name;
	private int age;
	private boolean isGraduated;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGraduated() {
		return isGraduated;
	}
	public void setGraduated(boolean isGraduated) {
		this.isGraduated = isGraduated;
	}
	
	
}