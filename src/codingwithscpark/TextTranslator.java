package codingwithscpark;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TextTranslator extends JFrame {
	JButton translator, canceler;
	JTextArea textIn, textOut;
	
	public TextTranslator() {
		super("텍스트 변환");
		
		
		textIn = new JTextArea(10,14);
		textOut = new JTextArea(10,14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		translator = new JButton("번역");
		canceler = new JButton("취소");
		translator.addActionListener(new ButtonActionListener());
		canceler.addActionListener(new ButtonActionListener());
		
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(translator);
		btnPanel.add(canceler);
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == translator) {
				textOut.setText("");
				String result = toEnglish(textIn.getText());
				textOut.append(result);
			}
			if (e.getSource() == canceler) {
				textOut.setText("");
			}
			
		}

		private String toEnglish(String input) {
			ApiExamTranslateNmt api = new ApiExamTranslateNmt();
			String jsonData = api.answer(input);
			String output = "";
			
			try {
				JSONParser jsonParse = new JSONParser();
				
				JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData);
				
				JSONObject msgObj = (JSONObject) jsonObj.get("message");
				
				JSONObject resultObj = (JSONObject) msgObj.get("result");
				
				output = resultObj.get("translatedText").toString();
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
//			output = jsonData.substring(jsonData.indexOf("translatedText\":\"")+"translatedText\":\"".length(), jsonData.indexOf("\",\"engineType"));
			
			return output;
		}
		
	}
	
	public static void main(String[] args) {
		new TextTranslator();
	}
}
