package article.common;

public class ArticleNotFoundException extends RuntimeException {
	public ArticleNotFoundException() {
		System.out.println("해당 글을 찾을 수가 없어요.");	
	}
}
