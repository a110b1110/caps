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
	public Student selectById(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from student where stuId = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Student student = null;
			if (rs.next()) {
				student = new Student(
						rs.getInt("stuId"), 
						rs.getString("stuname"), 
						rs.getString("password"),
						rs.getInt("GroupNumber"),
						rs.getString("phonenumber"),
						rs.getInt("TeamNumber"),
						rs.getString("stuemail"),
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

	public void insert(Connection conn, Student pro) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into student(stuId,stuname,password,GroupNumber,phonenumber,TeamNumber ,stuemail,stuJoinDate) values(?,?,?,?,?,null,?,?)")) {
			pstmt.setInt(1, pro.getStuId());
			pstmt.setString(2, pro.getStuname());
			pstmt.setString(3, pro.getPassword());
			pstmt.setInt(4, pro.getGroupNumber());
			pstmt.setString(5, pro.getPhonenumber());
			pstmt.setString(6, pro.getStuemail());
			pstmt.setTimestamp(7, new Timestamp(pro.getStuJoinDate().getTime()));
			pstmt.executeUpdate();
		}
	}
	/* 정보 변경 메소드 */
	public void update(Connection conn, Student member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set name = ?, password = ? where memberid = ?")) {
			pstmt.setString(1, member.getStuname());
			pstmt.setString(2, member.getPassword());
			pstmt.setInt(3, member.getStuId());
			pstmt.executeUpdate();
		}
	}
}