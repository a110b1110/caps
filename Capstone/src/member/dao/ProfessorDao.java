package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Professor;

public class ProfessorDao {
   public Professor selectById(Connection conn, String id) throws SQLException {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = conn.prepareStatement(
               "select * from professor where proId = ?");
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         Professor professor = null;
         if (rs.next()) {
            professor = new Professor(
                  rs.getString("proId"), 
                  rs.getString("proName"), 
                  rs.getString("password"),
                  rs.getInt("groupNo"),
                  rs.getString("phoneNo"),
                  rs.getString("proEmail"),
                  toDate(rs.getTimestamp("proJoinDate")));
         }
         return professor;
      } finally {
         JdbcUtil.close(rs);
         JdbcUtil.close(pstmt);
      }
   }

   private Date toDate(Timestamp date) {
      return date == null ? null : new Date(date.getTime());
   }

   public void insert(Connection conn, Professor pro) throws SQLException {
      try (PreparedStatement pstmt = 
            conn.prepareStatement("insert into professor(proId,proName,password,groupNo,phoneNo,proEmail,proJoinDate) values(?,?,?,?,?,?,?)")) {
         pstmt.setString(1, pro.getProId());
         pstmt.setString(2, pro.getProname());
         pstmt.setString(3, pro.getPassword());
         pstmt.setInt(4, pro.getGroupNo());
         pstmt.setString(5, pro.getPhoneNo());
         pstmt.setString(6, pro.getProemail());
         pstmt.setTimestamp(7, new Timestamp(pro.getProJoinDate().getTime()));
         pstmt.executeUpdate();
      }
   }
   /* 정보 변경 메소드 */
   public void update(Connection conn, Professor member) throws SQLException {
      try (PreparedStatement pstmt = conn.prepareStatement(
            "update professor set password = ?, phoneNo = ?, proEmail = ? where proId = ?")) {
         pstmt.setString(1, member.getPassword());
         pstmt.setString(2, member.getPhoneNo());
         pstmt.setString(3, member.getProemail());
         pstmt.setString(3, member.getProId());
         pstmt.executeUpdate();
      }
   }
}