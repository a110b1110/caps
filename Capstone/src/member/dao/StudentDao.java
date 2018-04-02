package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Student;

public class StudentDao {
   public Student selectById(Connection conn, String id) throws SQLException {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = conn.prepareStatement(
               "select * from student where stuId = ?");
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         Student student = null;
         if (rs.next()) {
            student = new Student(
                  rs.getString("stuId"), 
                  rs.getString("stuName"), 
                  rs.getString("password"),
                  rs.getInt("groupNo"),
                  rs.getString("phoneNo"),
                  rs.getString("teamNo"),
                  rs.getString("stuEmail"),
                  toDate(rs.getTimestamp("stuJoinDate")));
         }
         return student;
      } finally {
         JdbcUtil.close(rs);
         JdbcUtil.close(pstmt);
      }
   }

   private Date toDate(Timestamp date) {
      return date == null ? null : new Date(date.getTime());
   }

   public void insert(Connection conn, Student stu) throws SQLException {
      try (PreparedStatement pstmt = 
            conn.prepareStatement("insert into student(stuId,stuName,password,groupNo,phoneNo,teamNo ,stuEmail,stuJoinDate) values(?,?,?,?,?,null,?,?)")) {
         pstmt.setString(1,  stu.getStuId());
         pstmt.setString(2,  stu.getStuname());
         pstmt.setString(3,  stu.getPassword());
         pstmt.setInt(4,  stu.getGroupNo());
         pstmt.setString(5,  stu.getPhoneNo());
         pstmt.setString(6,  stu.getStuemail());
         pstmt.setTimestamp(7, new Timestamp(stu.getStuJoinDate().getTime()));
         pstmt.executeUpdate();
      }
   }
   /* 정보 변경 메소드 */
   public void update(Connection conn, Student member) throws SQLException {
      try (PreparedStatement pstmt = conn.prepareStatement(
            "update student set password = ?, phoneNo = ?, stuEmail = ? where stuId = ?")) {
         pstmt.setString(1, member.getPassword());
         pstmt.setString(2, member.getPhoneNo());
         pstmt.setString(3, member.getStuemail());
         pstmt.setString(4, member.getStuId());
         pstmt.executeUpdate();
      }
   }
}