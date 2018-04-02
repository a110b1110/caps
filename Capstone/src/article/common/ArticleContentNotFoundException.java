package article.common;


public class ArticleContentNotFoundException extends RuntimeException {
	public ArticleContentNotFoundException() {
		System.out.println("해당 글내용을 찾을 수가 없어요.");	
	}
}
