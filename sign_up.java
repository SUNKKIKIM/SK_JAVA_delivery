package Login;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class sign_up extends JFrame{
	String tele[] = {"KT", "SKT", "LGU+"}; 
	JLabel la_bd = new JLabel("생년월일 : ");
	JLabel la_name = new JLabel("이름 : ");
	JLabel la_pn = new JLabel("연락처 : ");
	JLabel la_phone1 = new JLabel("-");
	JLabel la_phone2 = new JLabel("-");
	JLabel la_adress = new JLabel("주소 : ");
	JLabel la_sex = new JLabel("성별 : ");
	JLabel la_id = new JLabel("아이디 : ");
	JLabel la_pw = new JLabel("비밀번호 : ");
	JTextField te_bd = new JTextField();
	JTextField te_name = new JTextField();
	JTextField te_pn1 = new JTextField();
	JTextField te_pn2 = new JTextField();
	JTextField te_pn3 = new JTextField();
	JTextField te_adress = new JTextField();
	JTextField te_id = new JTextField();
	JTextField te_pw = new JTextField();
	JComboBox<String> co_te = new JComboBox<String> (tele);
	
	JButton bt1 = new JButton("가입하기");
	
	Container c = getContentPane();
	
	public sign_up() {
		setTitle("개인 정보 입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		c.setLayout(null);

		setSize(300, 400);
		setVisible(true);
	
		la_bd.setLocation(10, 0);
		la_bd.setSize(100, 30);
		c.add(la_bd);
		
		la_name.setLocation(10, 50);
		la_name.setSize(100, 30);
		c.add(la_name);
		
		la_pn.setLocation(10, 100);
		la_pn.setSize(100, 30);
		c.add(la_pn);
		
		la_adress.setLocation(10, 150);
		la_adress.setSize(100, 40);
		c.add(la_adress);
		
		la_id.setLocation(10, 200);
		la_id.setSize(100, 40);
		c.add(la_id);
		
		la_pw.setLocation(10, 250);
		la_pw.setSize(100, 40);
		c.add(la_pw);
		
		te_bd.setLocation(10, 30);
		te_bd.setSize(80, 20);
		c.add(te_bd);
		
		te_name.setLocation(10, 80);
		te_name.setSize(80, 20);
		c.add(te_name);
		
		co_te.setBounds(10, 130, 60, 20);
		c.add(co_te);
		
		te_pn1.setLocation(80, 130);
		te_pn1.setSize(30, 20);
		c.add(te_pn1);
		la_phone1.setLocation(116, 130);
		la_phone1.setSize(50, 20);
		c.add(la_phone1);
		
		te_pn2.setLocation(130, 130);
		te_pn2.setSize(50, 20);
		c.add(te_pn2);
		la_phone2.setLocation(186, 130);
		la_phone2.setSize(50, 20);
		c.add(la_phone2);
		
		te_pn3.setLocation(200, 130);
		te_pn3.setSize(50, 20);
		c.add(te_pn3);
		
		te_adress.setLocation(10, 185);
		te_adress.setSize(220, 20);
		c.add(te_adress);
		
		te_id.setLocation(10, 235);
		te_id.setSize(100, 20);
		c.add(te_id);
		
		te_pw.setLocation(10, 285);
		te_pw.setSize(100, 20);
		c.add(te_pw);
		
		bt1.setLocation(80, 320);
		bt1.setSize(95, 20);
		c.add(bt1);
		
		
		bt1.addActionListener(new bt1_up());
	}
	public class bt1_up implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("가입하기"))
			{
				sign_up s = new sign_up();
			}
		}
	}
}
