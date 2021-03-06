package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame{	
	JLabel la_id = new JLabel("아이디 : ");
	JLabel la_pw = new JLabel("비밀번호 : ");
	JTextField te_id = new JTextField(8);
	JPasswordField te_pw = new JPasswordField(16);
	JButton bt1 = new JButton("로그인");
	JButton bt2 = new JButton("회원가입");
	Container c = getContentPane();
	
	public login() {
		setTitle("배달의 만족");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(null);

		setSize(250, 180);
		setVisible(true);
		
		la_id.setLocation(20, 0);
		la_id.setSize(100, 20);
		c.add(la_id);
		
		la_pw.setLocation(20, 50);
		la_pw.setSize(100, 20);
		c.add(la_pw);
		
		te_id.setLocation(20, 25);
		te_id.setSize(150, 20);
		c.add(te_id);
		
		te_pw.setLocation(20, 75);
		te_pw.setSize(150, 20);
		c.add(te_pw);
		te_pw.setEchoChar('*');
		
		
		bt1.setLocation(20, 110);
		bt1.setSize(95, 20);
		c.add(bt1);
		
		bt2.setLocation(120, 110);
		bt2.setSize(95, 20);
		c.add(bt2);
		
		bt2.addActionListener(new bt2_up());
		bt1.addActionListener(new bt1_up());
	}
	
	public class bt2_up implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("회원가입"))
			{
				sign_up s = new sign_up();
			}
		}
	}
	
	public class bt1_up implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("로그인"))
			{
				main_menu s = new main_menu();
			}
		}
	}
	
	public static void main(String[] args) {
		new login();
	}
}
