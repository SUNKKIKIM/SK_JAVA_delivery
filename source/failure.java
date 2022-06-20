package Login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.mem_modify.btnNewButton;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class failure extends JFrame {
	JPanel contentPane;
	JButton bt1 = new JButton("리스트 보기");
	JButton bt2 = new JButton("나가기");
	JLabel lblNewLabel = new JLabel("주문 리스트");
	JLabel t_name = new JLabel("New label");
	JLabel t_price = new JLabel("New label");
	JLabel t_num = new JLabel("New label");
	
	public failure() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 10, 150, 50);
		contentPane.add(lblNewLabel);
		
		t_name.setHorizontalAlignment(SwingConstants.CENTER);
		t_name.setBounds(20, 60, 100, 30);
		contentPane.add(t_name);
		
		t_price.setHorizontalAlignment(SwingConstants.CENTER);
		t_price.setBounds(170, 60, 100, 30);
		contentPane.add(t_price);
		
		t_num.setHorizontalAlignment(SwingConstants.CENTER);
		t_num.setBounds(320, 60, 100, 30);
		contentPane.add(t_num);
		
		bt1.setBounds(250, 280, 100, 25);
		contentPane.add(bt1);
		
		bt2.setBounds(100, 280, 100, 25);
		contentPane.add(bt2);
		
		bt1.addActionListener(new bt1());
		bt2.addActionListener(new bt2());
		setVisible(true);
	}
	
	public class bt1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
			database db = null;
			String[] result = null;
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("리스트 보기"))
			{
				try {
					db = new database();
					result = db.kiosk_list();
					t_name.setText(result[0]);
					t_price.setText(result[1]);
					t_num.setText(result[2]);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} 	
		}
    }
	
	public class bt2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("나가기"))
			{
				dispose();
			}
		}
	}
}
