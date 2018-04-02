package article.team.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.common.ArticleContentNotFoundException;
import article.common.ArticleNotFoundException;
import article.team.dao.TeamArticleDao;
import article.team.dao.TeamContentDao;
import article.team.model.TeamArticle;
import article.team.model.TeamContent;
import jdbc.connection.ConnectionProvider;

public class DeleteArticleService {
	
	private TeamArticleDao articleDao = new TeamArticleDao();
	private TeamContentDao contentDao = new TeamContentDao();
	
	public TeamWriteData deleteArticle(String fileNo) {
		try (Connection conn = ConnectionProvider.getConnection()){
			
			TeamContent content = contentDao.deleteByFileNo(conn, fileNo);
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			
			TeamArticle article = articleDao.deleteByFileNo(conn, fileNo);
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			
			return new TeamWriteData(article, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
	
	
