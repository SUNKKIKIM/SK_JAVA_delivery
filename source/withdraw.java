package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Login.mem_search.btnNewButton_1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class withdraw extends JFrame {

	JPanel contentPane;
	JLabel lblNewLabel = new JLabel("회원탈퇴");
	JLabel lblNewLabel_1 = new JLabel("아이디를 입력하세요 : ");
	JLabel lblNewLabel_1_1 = new JLabel("비밀번호를 입력하세요 : ");
	JTextField te_id = new JTextField();
	JPasswordField te_pw = new JPasswordField(16);
	JButton btnNewButton = new JButton("나가기");
	JButton btnNewButton_1 = new JButton("확인");
	
	public withdraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(100, 10, 271, 39);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1.setBounds(150, 70, 153, 34);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1_1.setBounds(150, 150, 153, 34);
		contentPane.add(lblNewLabel_1_1);
		
		btnNewButton.setBounds(30, 240, 91, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1.setBounds(340, 240, 91, 23);
		contentPane.add(btnNewButton_1);
		
		te_id.setBounds(150, 110, 131, 21);
		contentPane.add(te_id);
		te_id.setColumns(10);
		
		te_pw.setBounds(150, 190, 131, 21);
		contentPane.add(te_pw);
		te_pw.setColumns(10);
		
		btnNewButton_1.addActionListener(new btnNewButton_1());
		btnNewButton.addActionListener(new btnNewButton());
		setVisible(true);
	}
	
	public class btnNewButton_1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			database db = null;
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("확인"))
			{
				try {
					db = new database();
					db.DeleteDB(te_id.getText(), te_pw.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "탈퇴되었습니다. 이용해주셔서 감사합니다.");
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