package article.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.common.ArticleContentNotFoundException;
import article.common.ArticleNotFoundException;
import article.team.service.DeleteArticleService;
import article.team.service.ReadArticleService;
import article.team.service.TeamWriteData;
import auth.service.User;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
	
	private DeleteArticleService deleteService = new DeleteArticleService();
	private ReadArticleService readService = new ReadArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String fileNo = req.getParameter("fileNo");
		try {
			
			TeamWriteData articleData = readService.getArticle(fileNo, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canDelete(authUser, articleData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
			deleteService.deleteArticle(fileNo);
			//TeamWriteData articleData = deleteService.deleteArticle(fileNo);
			//req.setAttribute("articleData", articleData);
			return "/WEB-INF/view/deleteTeamboardSuccess.jsp";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	private boolean canDelete(User authUser, TeamWriteData articleData) {
		String writerId = articleData.getArticle().getWriter().getWriterId();
		//정수 -> 문자열 변환함
		String temp = authUser.getId();
		return temp.equals(writerId);
	}
}
