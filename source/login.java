package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class login extends JFrame{	
	JLabel la_id = new JLabel("아이디 : ");
	JLabel la_pw = new JLabel("비밀번호 : ");
	JTextField te_id = new JTextField(8);
	JPasswordField te_pw = new JPasswordField(16);
	JButton bt1 = new JButton("로그인");
	JButton bt2 = new JButton("회원가입");
	JButton bt3 = new JButton("회원정보");
	Container c = getContentPane();
	
	public login() {
		setTitle("자동 판매기 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램도 함께 종료
		
		c.setLayout(null);

		setSize(392, 212);
		setVisible(true);
		
		la_id.setLocation(20, 20);
		la_id.setSize(100, 20);
		c.add(la_id);
		
		la_pw.setLocation(20, 70);
		la_pw.setSize(100, 20);
		c.add(la_pw);
		
		te_id.setLocation(20, 40);
		te_id.setSize(150, 20);
		c.add(te_id);
		
		te_pw.setLocation(20, 90);
		te_pw.setSize(150, 20);
		c.add(te_pw);
		te_pw.setEchoChar('*');
		
		bt1.setLocation(20, 130);
		bt1.setSize(95, 20);
		c.add(bt1);
		
		bt2.setLocation(140, 130);
		bt2.setSize(95, 20);
		c.add(bt2);
		
		bt3.setBounds(260, 130, 91, 23);
		c.add(bt3);
		
		bt2.addActionListener(new bt2_up());
		bt1.addActionListener(new bt1_up());
		bt3.addActionListener(new bt3_up());
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
			database db;
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("로그인"))
			{
				try {
					db = new database();
					if (te_id.getText()!=null && db.login_check(te_id.getText(), te_pw.getText()) == 1) {
						JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
						main s = new main();
					}
					else {
						JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.");
						System.exit(0);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
			}			
		}
	}
	
	public class bt3_up implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mem_search s = new mem_search();
		}
	}
	
	public static void main(String[] args) {
		new login();
	}
}
