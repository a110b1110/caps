package team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import team.model.Team;

public class TeamDao {
   public Team selectById(Connection conn, String id) throws SQLException {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = conn.prepareStatement(
               "select * from team where teamNo = ?");
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         Team team = null;
         if (rs.next()) {
            team = new Team(
                  rs.getString("teamNo"),			//이거 db int -> str 수정해야함 
                  rs.getString("teamName"), 
                  rs.getString("teamSubject"),
                  rs.getString("advisor"),
                  Boolean.parseBoolean(rs.getString("state")),
                  rs.getInt("groupNo"),			//이거 db 수정해야함.(int가 맞는지)
                  toDate(rs.getTimestamp("TeamJoinDate")));		//db 이름을 teamRegDate로 바꿧으면함.
 		}
         return team;
      } finally {
         JdbcUtil.close(rs);
         JdbcUtil.close(pstmt);
      }
   }

   private Date toDate(Timestamp date) {
      return date == null ? null : new Date(date.getTime());
   }

   public void insert(Connection conn, Team team) throws SQLException {
      try (PreparedStatement pstmt = 
            conn.prepareStatement("insert into team(teamNo,teamName,teamSubject,advisor,state,groupNo,TeamJoinDate) values(?,?,?,?,?,null,?,?)")) {
         pstmt.setString(1,  team.getTeamNo());
         pstmt.setString(2,  team.getTeamName());
         pstmt.setString(3,  team.getTeamSubject());
         pstmt.setString(4,  team.getAdvisor());
         pstmt.setBoolean(5,  team.isState());				//boolean 값 db에 어떻게 저장하는지
         pstmt.setInt(6,  team.getGroupNo());
         pstmt.setTimestamp(7, new Timestamp(team.getTeamJoinDate().getTime()));
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