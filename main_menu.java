package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main_menu extends JFrame{
	public main_menu() {
		ImageIcon icon = new ImageIcon(new ImageIcon("C:/Users/USER/OneDrive/바탕 화면/1.jpg")
				.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		ImageIcon icon2 = new ImageIcon(new ImageIcon("C:/Users/USER/OneDrive/바탕 화면/3.jpg")
				.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		JLabel label1 = new JLabel(icon);
		JLabel label2 = new JLabel(icon2);
		Container c = getContentPane();
		label1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				ImageIcon icon3 = new ImageIcon(new ImageIcon("C:/Users/USER/OneDrive/바탕 화면/2.jpg")
						.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
				label1.setIcon(icon3);
			}
			public void mouseReleased(MouseEvent me) {
				ImageIcon icon3 = new ImageIcon(new ImageIcon("C:/Users/USER/OneDrive/바탕 화면/1.jpg")
						.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
				label1.setIcon(icon3);
			}
		});
		label1.setLocation(0, 0);
		label1.setSize(300, 300);
		c.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(label1);
		setSize(1000, 1000);
		setVisible(true);
	}
}