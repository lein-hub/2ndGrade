package codingwithscpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SimpleDictionary extends JPanel implements ActionListener{
	// 입력필드, 버튼 2개
	private JTextField inputField = new JTextField(30);
	private JLabel label = new JLabel();
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	private Properties props;
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/oop3";
	
	// 한영사전 : 한글단어와 대응되는 영어단어의 쌍을 저장
	private Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";
	
	public SimpleDictionary() {
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		
		this.setPreferredSize(new Dimension(600, 50));
//		buildDictionaryFromFile();
		
		// JDBC 드라이버를 메모리에 적재하기
		// JDBC 드라이버 클래스이름은 DBMS마다 다르다
		try {
			Class.forName(JDBC_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buildDictionaryFromDB();
	}
	
	private void buildDictionaryFromDB() {
		// 데이터베이스에 연결하기
		try (Connection con = DriverManager.getConnection(DB_URL, "root", "")) {
			String sql = "select * from dict";  // 쿼리
			PreparedStatement pst = con.prepareStatement(sql);  // PreparedStatement 는 실행준비가 완료된 SQL 객체 (실행된게 아님)
			
			// Insert, Delete, Update 문의 실행은 executeUpdate() 메서드를 실행
			// select 문은 executeQuery() 메서드를 실행
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
//				rs.getString(1);
				String key = rs.getString("kor");
				String value = rs.getString("eng");
				dict.put(key, value);
				System.out.println(key + ":" + value);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void addWordToDB(String key, String value) {
		/*
		 * 드라이버를 메모리에 적재한다 <- 이미 생성자에서 했다.
		 * DB에 연결해서 Connection 객체를 반환받는다.
		 * Connection 객체에게 PreparedStatement 객체를 요청한다.
		 * PreparedStatement 객체의 executeUpdate() 메서드를 호출해서 DB에 저장한다.
		 */
		try(Connection con = DriverManager.getConnection(DB_URL, "root", "")) {
			String sql = "insert into dict values(?, ?)";
			/*
			 * 실행 준비
			 * 1. 문법 검사 (sql변수의 문법을 검사)
			 * 2. 정당성 검사(테이블, 칼럼 등이 실제로 있는지, 있다면 이 사용자가 레코드를 삽입할 권한이 있는지)
			 * 3. 실행 계획을 세운다. (execution plan)
			 */
			PreparedStatement pst = con.prepareStatement(sql);
			// ? 자리의 칼럽 데이터 타입에 따라 적절한 set~ 메소드를 호출해야한다
			// 예를 들어, 칼럼이 char 또는 varchar타입이면 setString()
			// 칼럼이 TimeStamp 타입이면 setData(), setTimestamp()
			// 칼럼이 int 타입이면 setInt()
			pst.setString(1, key);
			pst.setString(2, value);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addWorldToFile(String key, String value) {
		try(FileWriter writer = new FileWriter(DIC_FILE_NAME, true)) {
			String str = key + "=" + value + "\n";
			writer.write(str);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void buildDictionaryFromFile() {
		props = new Properties();
		try(FileReader reader = new FileReader(DIC_FILE_NAME)) {
			props.load(reader);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Set<Object> set = props.keySet();
		
		for (Object key : set) {
			Object value = props.get(key);
			dict.put((String) key, (String) value);
		}
	}

	public static void main(String[] args) {
		JFrame fr = new JFrame();
		SimpleDictionary dict = new SimpleDictionary();
		fr.add(dict);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setTitle("나의 한영사전");
		fr.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String key = inputField.getText();
		if (key.trim().length() == 0) return;
		System.out.println(key);
		if (e.getSource() == searchBtn) {
			// inputField에 입력된 단어를 추출
			// dict 맵 객체에서 그 단어에 대응되는 영단어를 디스플레이
			String val = dict.get(key);
			if (val == null) {
				System.out.println("존재하지 않는 단어입니다");
				JOptionPane.showMessageDialog(this, "존재하지 않는 단어입니다", key, JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, val, key, JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == addBtn) {
			// inputField에 입력된 단어 추출
			// 그 단어에 대응되는 영단어를 입력받고
			// dict 맵 객체에 <한글단어, 영어단어>쌍 추가
			String eng = JOptionPane.showInputDialog(this, key + "에 대응하는 영어단어를 입력하세요");
			if (eng == null || eng.trim().length()==0) return;
			dict.put(key, eng);
			dict.put(eng, key);
//			try (PrintWriter out = new PrintWriter(new File(DIC_FILE_NAME))) {
//				props.put(key, eng);
//				props.store(out, "My Dictionary");
//			} catch(Exception e1) {
//				System.out.println(e1.getMessage());
//			}
			
			// addWordToFile
			try(FileWriter writer = new FileWriter(DIC_FILE_NAME, true)) {
				String str = key + "=" + eng + "\n";
				writer.write(str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// addWordToDB
			addWordToDB(key, eng);
			JOptionPane.showMessageDialog(this, "영어단어가 추가되었습니다");
		}
		inputField.requestFocus();
	}
	
	
}