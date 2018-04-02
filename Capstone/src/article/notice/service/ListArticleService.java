package article.notice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.notice.dao.NoticeDao;
import article.notice.model.Notice;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {

	private NoticeDao articleDao = new NoticeDao();
	private int size = 10;

	public ArticlePage getArticlePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(conn);
			List<Notice> content = articleDao.select(
					conn, (pageNum - 1) * size, size);
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
