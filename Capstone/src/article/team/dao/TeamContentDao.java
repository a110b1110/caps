package article.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import article.common.ArticleNotFoundException;
import article.team.model.TeamContent;
import jdbc.JdbcUtil;

public class TeamContentDao {

	public TeamContent insert(Connection conn, TeamContent content) 
	throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"insert into writeteam " + 
					"(fileNo, original_Filename, stored_Filename, file_Size, file_Ext) values (?,?,?,?,?)");
			pstmt.setString(1, content.getFileNo());
			pstmt.setString(2, content.getOrigin());
			pstmt.setString(3, content.getStored());
			pstmt.setLong(4, content.getFileSize());
			pstmt.setString(5, content.getFileExt());
			int insertedCount = pstmt.executeUpdate();
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public TeamContent selectById(Connection conn, String fileNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from writeteam where fileNo = ?");
			pstmt.setString(1, fileNo);
			rs = pstmt.executeQuery();
			TeamContent content = null;
			if (rs.next()) {
				content = new TeamContent(
						rs.getString("fileNo"), rs.getString("original_Filename"), 
						rs.getString("stored_Filename"), rs.getLong("file_Size"), rs.getString("file_Ext"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int update(Connection conn, String fileNo, String origin, String stored, long size, String ext) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update writeteam set original_Filename = ?, stored_Filename = ?, "
						+ "file_Size = ?, file_Ext = ?"+
						"where fileNo = ?")) {
			pstmt.setString(1, origin);
			pstmt.setString(2, stored);
			pstmt.setLong(3, size);
			pstmt.setString(4, ext);
			pstmt.setString(5, fileNo);
			return pstmt.executeUpdate();
		}
	}
	
	public TeamContent deleteByFileNo(Connection conn, String fileNo) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			TeamContent teamcontent = selectById(conn, fileNo);
			if(teamcontent == null) {
				throw new ArticleNotFoundException();
			}
			
			pstmt = conn.prepareStatement("delete from writeteam where fileNo = ? ");
			pstmt.setString(1, fileNo);
			int insertedCount = pstmt.executeUpdate();		//리턴값은 성골했을 때 : 성공한 행의 개수, 실패시 : 0
			
			if(insertedCount>0) {
					return teamcontent;
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
}
