package article.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.notice.model.NoticeContent;
import jdbc.JdbcUtil;

public class NoticeContentDao {

   public NoticeContent insert(Connection conn, NoticeContent content) 
   throws SQLException {
      PreparedStatement pstmt = null;
      try {
         pstmt = conn.prepareStatement(
               "insert into writenotice " + 
               "(postNo, content, original_Filename, "
               + "stored_Filename, file_Size, file_Ext) values (?,?,?,?,?,?)");
         pstmt.setLong(1, content.getPostId());
         pstmt.setString(2, content.getContent());
         pstmt.setString(3, content.getOrigin());
         pstmt.setString(4, content.getStored());
         pstmt.setLong(5, content.getFileSize());
         pstmt.setString(6, content.getFileExt());
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
   
   public NoticeContent selectById(Connection conn, int no) throws SQLException {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = conn.prepareStatement(
               "select * from writenotice where postNo = ?");
         pstmt.setInt(1, no);
         rs = pstmt.executeQuery();
         NoticeContent content = null;
         if (rs.next()) {
            content = new NoticeContent(
                  rs.getInt("postId"), rs.getString("content"), rs.getString("original_Filename"),
                  rs.getString("stored_Filename"), rs.getLong("file_Size"), rs.getString("file_Ext"));
         }
         return content;
      } finally {
         JdbcUtil.close(rs);
         JdbcUtil.close(pstmt);
      }
   }

   public int update(Connection conn, int postNo, String content, String origin, String stored, long size
		   , String ext) throws SQLException {
      try (PreparedStatement pstmt = 
            conn.prepareStatement(
                  "update writenotice set content = ?, original_Filename = ?, stored_Filename = ?,"
                  + "file_Size = ?, file_Ext = ? where postId = ?")) {
         pstmt.setString(1, content);
         pstmt.setString(2, origin);
         pstmt.setString(3, stored);
         pstmt.setLong(4, size);
         pstmt.setString(5, ext);
         pstmt.setLong(6, postNo);
         return pstmt.executeUpdate();
      }
   }
}