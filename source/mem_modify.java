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

public class mem_modify extends JFrame {

	JPanel contentPane;
	JPasswordField te_pw = new JPasswordField(16);
	JLabel lblNewLabel_2 = new JLabel("New label");
	JLabel lblNewLabel_2_1 = new JLabel("New label");
	JLabel lblNewLabel_2_2 = new JLabel("New label");
	JButton btnNewButton = new JButton("나가기");
	JButton btnNewButton_1 = new JButton("확인");
	JLabel lblNewLabel_1_2 = new JLabel("수정할 이름을 입력하세요 : ");
	JLabel lblNewLabel_1_2_1 = new JLabel("수정할 전화번호를 입력하세요 : ");
	JLabel lblNewLabel_1_2_2 = new JLabel("수정할 주소를 입력하세요 : ");
	JTextField te_name = new JTextField();
	JTextField te_phone = new JTextField();
	JTextField te_address = new JTextField();
	
	public mem_modify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원정보 수정");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(174, 10, 271, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호를 입력하세요 : ");
		lblNewLabel_1.setBounds(12, 120, 153, 34);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton.setBounds(189, 356, 91, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1.setBounds(313, 356, 91, 23);
		contentPane.add(btnNewButton_1);
		
		te_pw.setBounds(12, 155, 131, 21);
		contentPane.add(te_pw);
		te_pw.setColumns(10);
		
		lblNewLabel_2.setBounds(430, 84, 123, 27);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2_1.setBounds(430, 160, 123, 27);
		contentPane.add(lblNewLabel_2_1);
		
		lblNewLabel_2_2.setBounds(430, 241, 123, 27);
		contentPane.add(lblNewLabel_2_2);
		
		lblNewLabel_1_2.setBounds(210, 60, 170, 35);
		contentPane.add(lblNewLabel_1_2);
		
		lblNewLabel_1_2_1.setBounds(210, 140, 170, 35);	
		contentPane.add(lblNewLabel_1_2_1);
		
		lblNewLabel_1_2_2.setBounds(210, 220, 170, 35);
		contentPane.add(lblNewLabel_1_2_2);
		
		te_name.setBounds(210, 95, 150, 20);
		te_name.setColumns(10);
		contentPane.add(te_name);
		
		te_phone.setColumns(10);
		te_phone.setBounds(210, 175, 150, 20);
		contentPane.add(te_phone);
		
		te_address.setColumns(10);
		te_address.setBounds(210, 255, 150, 20);
		contentPane.add(te_address);
		
		btnNewButton_1.addActionListener(new btnNewButton_1());
		btnNewButton.addActionListener(new btnNewButton());
		setVisible(true);
	}
	
	public class btnNewButton_1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			database db = null;
			int result = 0;
			String[] show = null;
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("확인"))
			{
				try {
					db = new database();
					result = db.modifyDB(te_name.getText(), te_phone.getText(), te_address.getText(), te_pw.getText());
					if (result == 1) {
						show = db.select_member(te_pw.getText());
						lblNewLabel_2.setText(show[1]);
						lblNewLabel_2_1.setText(show[2]);
						lblNewLabel_2_2.setText(show[3]);
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