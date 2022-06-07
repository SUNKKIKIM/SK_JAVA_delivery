package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.login.bt1_up;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class mem_search extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JLabel lblNewLabel = new JLabel("회원정보");
	JLabel lblNewLabel_1 = new JLabel("아이디를 입력해주세요 :");
	JTextField te_id = new JTextField(8);
	JButton btnNewButton = new JButton("나가기");
	JButton btnNewButton_1 = new JButton("확인");
	JLabel birthday = new JLabel("New label");
	JLabel name = new JLabel("New label");
	JLabel phone = new JLabel("New label");
	JLabel address = new JLabel("New label");
	

	public mem_search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 10, 150, 40);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1.setBounds(12, 70, 150, 30);
		contentPane.add(lblNewLabel_1);
		
		te_id.setBounds(12, 100, 130, 20);
		contentPane.add(te_id);
		te_id.setColumns(10);
		
		btnNewButton.setBounds(100, 210, 90, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1.setBounds(220, 210, 90, 25);
		contentPane.add(btnNewButton_1);
		birthday.setBounds(239, 60, 130, 30);
		
		contentPane.add(birthday);
		name.setBounds(238, 88, 130, 30);
		
		contentPane.add(name);
		phone.setBounds(238, 118, 130, 30);
		
		contentPane.add(phone);
		address.setBounds(238, 147, 130, 30);
		
		contentPane.add(address);
		
		btnNewButton.addActionListener(new btnNewButton());
		btnNewButton_1.addActionListener(new btnNewButton_1());
		setVisible(true);
	}
	
	public class btnNewButton_1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			database db = null;
			String[] result = null;
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("확인"))
			{
				try {
					db = new database();
					result = db.select_member(te_id.getText());
					if (result[4]!=null && result[4].equals(te_id.getText()) ) {
						birthday.setText(result[0]);
						name.setText(result[1]);
						phone.setText(result[2]);
						address.setText(result[3]);
					}
					else {
						JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
			}			
		}
	}
	
	public class btnNewButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("나가기"))
			{
				dispose();
			}
		}
	}
}

