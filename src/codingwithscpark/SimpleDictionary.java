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
		buildDictionaryFromFile();
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
//			try (PrintWriter out = new PrintWriter(new File(DIC_FILE_NAME))) {
//				props.put(key, eng);
//				props.store(out, "My Dictionary");
//			} catch(Exception e1) {
//				System.out.println(e1.getMessage());
//			}
			
			try(FileWriter writer = new FileWriter(DIC_FILE_NAME, true)) {
				String str = key + "=" + eng + "\n";
				writer.write(str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "영어단어가 추가되었습니다");
		}
		inputField.requestFocus();
	}
}