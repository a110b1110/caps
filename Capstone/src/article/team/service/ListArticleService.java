package article.team.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.team.dao.TeamArticleDao;
import article.team.model.TeamArticle;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {

	private TeamArticleDao articleDao = new TeamArticleDao();
	private int size = 10;

	public ArticlePage getArticlePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(conn);
			List<TeamArticle> content = articleDao.select(
					conn, (pageNum - 1) * size, size);
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
