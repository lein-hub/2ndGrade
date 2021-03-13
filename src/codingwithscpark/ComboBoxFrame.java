package codingwithscpark;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;

public class ComboBoxFrame extends JFrame implements ActionListener{
	JLabel label2 = new JLabel();
	
	public ComboBoxFrame() {
		this.setTitle("콤보 박스");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		
		String[] animals = { "dog" , "apple", "grape" };
		
		JComboBox<String> animalList = new JComboBox<>(animals);
		animalList.addActionListener(this);
		animalList.setSelectedIndex(0);
		animalList.setEditable(true);
		animalList.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String item = animalList.getEditor().getItem().toString();
					boolean canAdd = true;
					for (int i=0; i<animalList.getItemCount(); i++) {
						if (animalList.getItemAt(i).toString().equals(item)) {
							canAdd = false;
							break;
						}
					}
					if (canAdd) {
						animalList.addItem(item);
						animalList.setSelectedItem(item);
					}
				}
			}
		});
		
		
		label2.setHorizontalAlignment(JLabel.CENTER);
		chagePicture(animals[animalList.getSelectedIndex()]);
		
		this.add(animalList, BorderLayout.PAGE_START);
		this.add(label2, BorderLayout.PAGE_END);
		this.setVisible(true);
	}

	private void chagePicture(String string) {
		File file = new File(string+".gif");
		ImageIcon icon = new ImageIcon(file.getPath());
		this.label2.setIcon(icon);
		
		if (file.isFile()) {
			this.label2.setText(null);
		} else {
			this.label2.setText("이미지를 찾을 수 없습니다");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		
		String name = (String) cb.getSelectedItem();
		chagePicture(name);
		
	}
	
	public static void main(String[] args) {
		new ComboBoxFrame();
	}
}
