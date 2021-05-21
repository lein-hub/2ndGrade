package codingwithscpark;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class TableViewer extends JFrame implements ActionListener{
	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton prevBtn, nextBtn, insBtn, finBtn;
	private ResultSet rs = null;
	private Connection con = null;
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/oop3";
	
	
	public TableViewer() {
		//각 컴포넌트를 프레임에 추가하기
		this.setLayout(new GridLayout(0, 2));
		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField(10);
		this.add(idField);
		this.add(new JLabel("TITLE", JLabel.CENTER));
		titleField = new JTextField(10);
		this.add(titleField);
		this.add(new JLabel("PUBLISHER", JLabel.CENTER));
		publisherField = new JTextField(10);
		this.add(publisherField);
		this.add(new JLabel("YEAR", JLabel.CENTER));
		yearField = new JTextField(10);
		this.add(yearField);
		this.add(new JLabel("PRICE", JLabel.CENTER));
		priceField = new JTextField(10);
		this.add(priceField);
		
		prevBtn = new JButton("Previous");
		prevBtn.addActionListener(this);
		this.add(prevBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		insBtn = new JButton("Insert");
		insBtn.addActionListener(this);
		this.add(insBtn);
		
		finBtn = new JButton("Finish");
		finBtn.addActionListener(this);
		this.add(finBtn);
		
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		/*
		 * TableViewr 객체가 생성될 때, DB의 books 테이블의 레코드들을 읽어온다.
		 */
		
		// 1. 데이터 베이스 연결
		// 2. select 문 실행하고 반환된 ResultSet 객체를 갖고있어야 함
		try {
			Class.forName(JDBC_CLASS_NAME);
			readTableFromDB();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void readTableFromDB() {
		// 데이터베이스에 연결하기
			try {
				con = DriverManager.getConnection(DB_URL, "root", "");
				String sql = "select * from books";  // 쿼리
				PreparedStatement pst = con.prepareStatement(sql);  // PreparedStatement 는 실행준비가 완료된 SQL 객체 (실행된게 아님)
				
				// Insert, Delete, Update 문의 실행은 executeUpdate() 메서드를 실행
				// select 문은 executeQuery() 메서드를 실행
				rs = pst.executeQuery();
					
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("DB연결에 문제가 있어 프로그램을 종료합니다.");
				System.exit(1);
			}
	}

	public static void main(String[] args) {
		new TableViewer();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == prevBtn) {
			getPrev(rs);
		}
	}

	private void getPrev(ResultSet rs) {
		
	}
	
	

}
