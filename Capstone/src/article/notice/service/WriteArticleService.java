package article.notice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import article.notice.dao.NoticeContentDao;
import article.notice.dao.NoticeDao;
import article.notice.model.Notice;
import article.notice.model.NoticeContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteArticleService {

   private NoticeDao articleDao = new NoticeDao();
   private NoticeContentDao contentDao = new NoticeContentDao();

   public Integer write(WriteRequest req) {
      Connection conn = null;
      try {
         conn = ConnectionProvider.getConnection();
         conn.setAutoCommit(false);

         Notice article = toNotice(req);
         Notice savedArticle = articleDao.insert(conn, article);
         if (savedArticle == null) {
            throw new RuntimeException("fail to insert notice");
         }
         NoticeContent content = new NoticeContent(
               savedArticle.getPostNo(),
               req.getContent(), req.getOrigin(), req.getStored(),
               req.getFileSize(), req.getFileExt());
         NoticeContent savedContent = contentDao.insert(conn, content);
         if (savedContent == null) {
            throw new RuntimeException("fail to insert noticecontent");
         }
         conn.commit();
         
         return savedArticle.getPostNo();
      } catch (SQLException e) {
         JdbcUtil.rollback(conn);
         throw new RuntimeException(e);
      } catch (RuntimeException e) {
         JdbcUtil.rollback(conn);
         throw e;
      } finally {
         JdbcUtil.close(conn);
      }
   }

   private Notice toNotice(WriteRequest req) {
      Date now = new Date();
      return new Notice(0, req.getWriter(), req.getTitle(), now, now, 0);
   }
}