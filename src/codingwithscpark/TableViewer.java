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
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
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
		try {
			if (e.getSource() == nextBtn) {
				if (rs.next()) {}
				else rs.first();
				setTexts();
				
			}
			else if (e.getSource() == prevBtn) {
				if (rs.previous()) {}
				else rs.last();
				setTexts();
			}
			else if (e.getSource() == insBtn) {
				// 이미 DB는 연결되어 있고
				// 이미 연결 정보를 가지고 있는 Connection 객체를
				// insert 문을 이용해 prepare 하고
				// 반환된 PreparedStatement 객체를 이용해서
				// 실행요청을 서버에 보낸다
				String sql = "insert into books(title, publisher, year, price) values(?, ?, ?, ?)";
				PreparedStatement pst = con.prepareStatement(sql);
				
				try {
					pst.setString(1, this.titleField.getText());
					pst.setString(2, this.publisherField.getText());
					pst.setDate(3, Date.valueOf(this.yearField.getText()));
					pst.setInt(4, Integer.valueOf(this.priceField.getText()));
					pst.executeUpdate();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "등록 실패 ["+e1.getMessage()+"]");
					e1.printStackTrace();
				}
				
				pst = con.prepareStatement("select * from books order by book_id");
				rs.close();
				rs = pst.executeQuery();
				rs.last();
				setTexts();
			}
			else if (e.getSource() == finBtn) {
				con.close();
				this.dispose();
				System.exit(EXIT_ON_CLOSE);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void setTexts() {
		try {
			this.idField.setText(rs.getString("book_id"));
			this.titleField.setText(rs.getString("title"));
			this.publisherField.setText(rs.getString("publisher"));
			this.yearField.setText(rs.getDate("year").toString());
			this.priceField.setText(String.valueOf(rs.getInt("price")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
