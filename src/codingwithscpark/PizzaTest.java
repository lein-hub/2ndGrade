package codingwithscpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaTest extends JFrame implements ActionListener {
	
	private int sum, tmp1=19000, tmp2=0, tmp3=-2000;
	private JButton orderBtn, cancelBtn;
	
	private JPanel downPnl;
	private JTextField text;
	
	WelcomePanel welcome = new WelcomePanel();
	TypePanel type = new TypePanel();
	ToppingPanel topping = new ToppingPanel();
	SizePanel size = new SizePanel();
	
	public PizzaTest() {
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("피자 주문");
		
		orderBtn = new JButton("주문");
		orderBtn.addActionListener(this);
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(this);
		
		text = new JTextField();
		text.setEditable(false);
		text.setColumns(6);
		
		downPnl = new JPanel();
		downPnl.add(orderBtn);
		downPnl.add(cancelBtn);
		downPnl.add(text);
		
		this.setLayout(new BorderLayout());
		
		this.add(welcome, BorderLayout.NORTH);
		this.add(type, BorderLayout.WEST);
		this.add(topping, BorderLayout.CENTER);
		this.add(size, BorderLayout.EAST);
		this.add(downPnl, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == orderBtn) {
			text.setText(String.valueOf(tmp1+tmp2+tmp3)+"원");
		} else if (e.getSource() == cancelBtn) {
			text.setText(null);
			type.combo.setSelected(true);
			size.small.setSelected(true);
			for (int i=0; i<topping.toppings.length; i++) {
				topping.toppings[i].setSelected(false);
			}
			tmp1=19000;
			tmp2=0;
			tmp3=-2000;
		}
		
	}
	
	class WelcomePanel extends JPanel {
		private JLabel message;
		
		public WelcomePanel() {
			message = new JLabel("자바 피자에 오신걸 환영합니다.");
			this.add(message);
		}
	}
	
	class TypePanel extends JPanel implements ActionListener {
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup bg;
		
		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));
			
			combo = new JRadioButton("콤보 (19000원)", true);
			combo.addActionListener(this);
			combo.setFocusable(false);
			potato = new JRadioButton("포테이토 (20000원)");
			potato.addActionListener(this);
			potato.setFocusable(false);
			bulgogi = new JRadioButton("불고기 (21000원)");
			bulgogi.addActionListener(this);
			bulgogi.setFocusable(false);
			
			bg = new ButtonGroup();
			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);
			
			this.setBorder(BorderFactory.createTitledBorder("종류"));
			
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == combo)
				tmp1 = 19000;
			if (e.getSource() == potato)
				tmp1 = 20000;
			if (e.getSource() == bulgogi)
				tmp1 = 21000;
			
		}
	}
	
	class ToppingPanel extends JPanel implements ItemListener{
		private JCheckBox[] toppings;
		private String[] igrd = {"pepper (1000원)", "cheese (2000원)", "peperoni (2000원)", "bacon (2000원)"};
		
		public ToppingPanel() {
			this.setLayout(new GridLayout(4,1));
			
			toppings = new JCheckBox[igrd.length];
			for (int i=0; i<igrd.length; i++) {
				toppings[i] = new JCheckBox(igrd[i]);
				toppings[i].addItemListener(this);
				toppings[i].setFocusable(false);
				this.add(toppings[i]);
			}
			
			this.setBorder(BorderFactory.createTitledBorder("추가토핑"));
			
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			for (int i=0; i<toppings.length; i++) {
				if (e.getItemSelectable() == toppings[i]) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (i == 0) {
							sum += 1000;
						} else {
							sum += 2000;
						}
					} else {
						if (i == 0) {
							sum -= 1000;
						} else {
							sum -= 2000;
						}
					}
				}
			}
			
			tmp2 = sum;
			
		}
	}
	
	class SizePanel extends JPanel implements ActionListener {
		private JRadioButton small, medium, large;
		private ButtonGroup bg;
		
		public SizePanel() {
			this.setLayout(new GridLayout(3,1));
			
			small = new JRadioButton("Small (-2000원)", true);
			small.addActionListener(this);
			small.setFocusable(false);
			medium = new JRadioButton("Medium");
			medium.addActionListener(this);
			medium.setFocusable(false);
			large = new JRadioButton("Large (+3000원)");
			large.addActionListener(this);
			large.setFocusable(false);
			
			bg = new ButtonGroup();
			bg.add(small);
			bg.add(medium);
			bg.add(large);
			
			this.setBorder(BorderFactory.createTitledBorder("사이즈"));
			
			this.add(small);
			this.add(medium);
			this.add(large);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == small) {
				tmp3 = -2000;
			} else if (e.getSource() == medium) {
				tmp3 = 0;
			} else if (e.getSource() == large) {
				tmp3 = 3000;
			}
			
		}
	}
	
	public static void main(String[] args) {
		new PizzaTest();
	}
}
