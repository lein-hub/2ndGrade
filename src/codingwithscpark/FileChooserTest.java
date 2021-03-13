package codingwithscpark;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class FileChooserTest extends JFrame implements ActionListener {
	JButton openBtn, saveBtn;
	JFileChooser fc;
	JLabel dir;
	File file;
	
	public FileChooserTest() {
		this.setTitle("파일 선택기 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		
		fc = new JFileChooser();
		
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		openBtn = new JButton("파일 열기");
		openBtn.addActionListener(this);
		
		saveBtn = new JButton("파일 저장");
		saveBtn.addActionListener(this);
		
		dir = new JLabel("현재 경로: ");
		
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(openBtn);
		panel.add(saveBtn);
		panel.add(dir);
		this.add(panel);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openBtn) {
			int returnVal = fc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				dir.setText("현재 경로: " + file.getPath());
			}
		}
		
		if (e.getSource() == saveBtn) {
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new FileChooserTest();
	}

}
