package Login;

import java.sql.*;
import javax.swing.JOptionPane;

public class database {
   Connection conn;
   Statement st;
   // 처음 데이터 베이스 연결을 위한 메서드
   public database() throws SQLException {
      
         String user = "root";
         String password = "1234";
         String url = "jdbc:mysql://localhost:3306/sunki";
         conn = DriverManager.getConnection(url, user, password);
         st = conn.createStatement();
         System.out.println(conn.toString());
         
   }
   //로그인 했을때 아이디 체크 메소드
   public int login_check(String id, String pswd) throws SQLException{
      
      String sql = "select * from member where id=? and pswd=?";
      PreparedStatement sm = conn.prepareStatement(sql);
      sm.setString(1, id);
      sm.setString(2, pswd);
      ResultSet rs = sm.executeQuery();
      
      if(rs.next()) {
         if(id.equals(rs.getString(5)) && pswd.equals(rs.getString(6))) {
            return 1;
         }
         else {
            return 0;
         }
      }
      if(rs != null)
             rs.close();
       if(sm != null)
            sm.close();
       if(conn != null)
            conn.close();
      return 0;
      
   }
   //특정 회원 정보를 검색하는 메소드
   public String[] select_member(String id) throws SQLException{
	      String[] query = new String[6];

	      String sql = "select * from member where id = ?";
	      PreparedStatement sm = conn.prepareStatement(sql);
	      
	      sm.setString(1,id);
	      ResultSet rs = sm.executeQuery();
	      
	      if(rs.next()) {
	         query[0] = rs.getString(1);
	         query[1] = rs.getString(2);
	         query[2] = rs.getString(3);
	         query[3] = rs.getString(4);
	         query[4] = rs.getString(5);
	         query[5] = rs.getString(6);
	         
	      }
	       return query;
	   }

   
   public String[] select_kiosk (String name) throws SQLException{
	      String[] query = new String[6];

	      String sql = "select * from kiosk where name=?";
	      PreparedStatement sm = conn.prepareStatement(sql);
	      
	      sm.setString(1,name);
	      ResultSet rs = sm.executeQuery();
	      
	      if(rs.next()) {
	         query[0] = rs.getString(1);
	         query[1] = rs.getString(2);
	         query[2] = rs.getString(3);
	         query[3] = rs.getString(4);       
	      }
	       return query;
	   }
   
// 회원 정보 수정을 위한 메서드
   public int modifyDB(String name, String phone, String address, String pswd) throws SQLException
   {
	   String sql = "update member set name=?, phone=?, address=? where pswd=?";
	   PreparedStatement sm = null;
	   int count = 0;
	   try {
		   sm = conn.prepareStatement(sql);
		   sm.setString(1, name);
		   sm.setString(2, phone);
		   sm.setString(3, address);
		   sm.setString(4, pswd);
		   count = sm.executeUpdate();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return 1;
	}
   
   public void insertDB(String birth, String name, String phone, String address, String id, String pswd) throws SQLException
   {
      String sql = "insert into member values(?,?,?,?,?,?)";
      PreparedStatement sm = conn.prepareStatement(sql);
      
      sm.setString(1, birth);
      sm.setString(2, name);
      sm.setString(3, phone);
      sm.setString(4, address);
      sm.setString(5, id);
      sm.setString(6, pswd);
      int rs = sm.executeUpdate();
   }
   public void DeleteDB(String id, String pswd) throws SQLException{
      
      String sql = "delete from member where id=? and pswd=?";
      PreparedStatement sm = conn.prepareStatement(sql);
      sm.setString(1, id);
      sm.setString(2, pswd);
      int rs = sm.executeUpdate();
      
      if(rs>0) {
         System.out.println("삭제되었습니다.");
      }
      else {
         System.out.println("값이 없습니다.");
      }
   }
   
   // 주문한 메뉴 집어넣기
   public void insert(String name, int price, int num) throws SQLException 
   {
	   String sql = "insert into kiosk(name,price,num) values(?,?,?)";
	   PreparedStatement sm = conn.prepareStatement(sql);
	      
	   sm.setString(1, name);
	   sm.setInt(2,price);
	   sm.setInt(3, num);

	   int rs = sm.executeUpdate();
   }
   
   // 주문한 메뉴 삭제
   public void Delete(String name, String time) throws SQLException{
	      
	      String sql = "delete from kiosk where name=? and time=?";
	      PreparedStatement sm = conn.prepareStatement(sql);
	      sm.setString(1, name);
	      sm.setString(2, time);
	      int rs = sm.executeUpdate();
	      
	      if(rs>0) {
	         System.out.println("삭제되었습니다.");
	      }
	      else {
	         System.out.println("값이 없습니다.");
	      }
	   }
   
   // 주문 목록 넣기
public String[] kiosk_list() throws SQLException{
	   String[] query = new String[3];

	      String sql = "select * from kiosk";
	      PreparedStatement sm = conn.prepareStatement(sql);
	      ResultSet rs = sm.executeQuery();
	      
	      while (rs.next()) {
	         query[0] = rs.getString(1);
	         query[1] = rs.getString(2);
	         query[2] = rs.getString(3);
	      }
	       return query;
	   }
}