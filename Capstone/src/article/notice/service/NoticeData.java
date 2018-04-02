package article.notice.service;

import article.notice.model.*;

public class NoticeData {

	private Notice article;
	private NoticeContent content;

	public NoticeData(Notice article, NoticeContent content) {
		this.article = article;
		this.content = content;
	}

	public Notice getArticle() {
		return article;
	}

	public String getContent() {
		return content.getContent();
	}

}
