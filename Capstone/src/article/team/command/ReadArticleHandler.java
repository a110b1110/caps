package article.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.common.ArticleContentNotFoundException;
import article.team.service.TeamWriteData;
import article.common.ArticleNotFoundException;
import article.team.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler {

	private ReadArticleService readService = new ReadArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String fileNo = req.getParameter("fileNo");
		try {
			TeamWriteData articleData = readService.getArticle(fileNo, true);
			req.setAttribute("articleData", articleData);
			return "/WEB-INF/view/readTeam.jsp";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
