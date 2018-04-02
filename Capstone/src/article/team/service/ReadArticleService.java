package article.team.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.common.ArticleNotFoundException;
import article.common.ArticleContentNotFoundException;
import article.team.dao.TeamContentDao;
import article.team.dao.TeamArticleDao;
import article.team.model.TeamArticle;
import article.team.model.TeamContent;
import article.team.service.TeamWriteData;
import jdbc.connection.ConnectionProvider;

public class ReadArticleService {

	private TeamArticleDao articleDao = new TeamArticleDao();
	private TeamContentDao contentDao = new TeamContentDao();
	
	public TeamWriteData getArticle(String fileNo, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			TeamArticle article = articleDao.selectById(conn, fileNo);
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			TeamContent content = contentDao.selectById(conn, fileNo);
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			if (increaseReadCount) {
				articleDao.increaseDownCount(conn, fileNo);
			}
			return new TeamWriteData(article, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
