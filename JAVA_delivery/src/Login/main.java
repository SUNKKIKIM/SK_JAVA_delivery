package Login;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
 
public class main{
    int count = 0;
    String show = "";
 
    public main() {
 
        JFrame frame = new JFrame("햄버거 자동 판매기");
        frame.setBounds(0, 0, 625, 1000);
        frame.setBackground(Color.black);
 
        // 폰트
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // 북쪽
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(255, 255, 215)); // 북쪽 패널 배경색
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
        pNorth.setFont(font);
 
        // 배열 설정 부분
        String menu[] = { "빅맥버거", "싸이버거", "새우버거", "치즈버거", "고기버거", "더블버거", "군대리아", "치킨버거" };
        int price[] = { 5000, 5500, 6000, 6500, 7000, 7500, 8000, 8500 };
        JButton bt[] = new JButton[menu.length]; // 햄버거 버튼
        TextField suja[] = new TextField[menu.length]; // 가격 텍스트필드
        Button minus[] = new Button[menu.length]; // - 버튼
        Button plus[] = new Button[menu.length]; // + 버튼
        JButton ok[] = new JButton[menu.length]; // 확인 버튼
        JLabel l[] = new JLabel[menu.length]; // (가격 + 원) 라벨
 
        // 버튼 설정 부분
        for (int i = 0; i < menu.length; i++) { // 메뉴 길이 만큼 반복
 
            // 햄버거 버튼
            bt[i] = new JButton(menu[i]);
            if (i < 4) {
                bt[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }

            // 숫자 txt 버튼
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
 
            // "-" 버튼
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // 가격
            l[i] = new JLabel(price[i] + "원");
            l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);
 
            // 확인 버튼
            ok[i] = new JButton("확인");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
 
            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(l[i]);
            pNorth.add(ok[i]);
        }
 
        // 중앙
        JTextField tt = new JTextField();
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명   단가   수량   합계\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);
        ta.setFont(font1);
 
        // 남쪽
        Panel pSouth = new Panel();
        FlowLayout flowLayout = (FlowLayout) pSouth.getLayout();
        flowLayout.setHgap(40);
        flowLayout.setVgap(55);
        flowLayout.setAlignment(FlowLayout.LEFT);
        pSouth.setFont(font);
        pSouth.setBackground(new Color(255, 255, 215));
 
        JButton bt1 = new JButton("주문");
        JButton bt2 = new JButton("주문취소");
        JButton bt3 = new JButton("초기화");
        JButton bt4 = new JButton("닫기");
        pSouth.add(bt1);
        pSouth.add(bt2);
        pSouth.add(bt3);
        pSouth.add(bt4);
 
        // 주문버튼
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					database db = new database();
					String s[] = ta.getText().split("\n");
	            	ArrayList<String[]> split =new ArrayList<>();
	            	for (int i=1;i<s.length;i++) {
	            		split.add(s[i].split("   "));
	            		db.insert(split.get(i-1)[1],Integer.parseInt(split.get(i-1)[2]), Integer.parseInt(split.get(i-1)[3]));
	            	}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
                JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   상품명   단가   수량   합계\n");
 
                }
            }
        });
        
        // 주문취소 버튼
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					database db = new database();
					String s[] = ta.getText().split("\n");
					String[] a;
	            	ArrayList<String[]> split =new ArrayList<>();
	            	
	            	for (int i=1;i<s.length;i++) {
	            		split.add(s[i].split("   "));
	            		a = db.select_kiosk(split.get(i-1)[1]);
	            		db.Delete(split.get(i-1)[1], a[3]);
	            	}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    
                JOptionPane.showMessageDialog(null, ta.getText() + " 주문취소되었습니다. \n이용해주셔서 감사합니다.");
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   상품명   단가   수량   합계\n");
 
                }
            }
        });
 
        // 초기화 버튼
        bt3.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					database db = new database();
	            		db.Reset();
	            	}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   상품명   단가   수량   합계\n");
 
                }
            }
        });
 
 
        // 닫기버튼
        
        bt4.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
 
 
        // 컴포넌트
        frame.getContentPane().add(pNorth, BorderLayout.NORTH);
        frame.getContentPane().add(ta, BorderLayout.CENTER);
        frame.getContentPane().add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
 
        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            int j = i;
 
            // 햄버그 버튼 이벤트
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    bt[j].setEnabled(false);
                    ok[j].setEnabled(true);
 
                    count = 0;
                }
            });
 
            // "-" 버튼 이벤트
            minus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        suja[j].setText(count + "");
                        ok[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
            
            // "+" 버튼 이벤트
            plus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    suja[j].setText(count + "");
                    ok[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
            
            //확인 버튼 이벤트
            ok[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    show = bt[j].getActionCommand(); // 햄버거 버튼 이벤트를 발생시킨 객체의 문자열을 가져온다
                    ta.append("   " + show + "   " + price[j] + "   " + count + "   " + price[j] * count
                            + "원" + "\n");
                    ok[j].setEnabled(false);
                }
            });
        }
 
        // 끄기
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
 
    // 메인
    public static void main(String[] args) {
        new main();
    }
 
}