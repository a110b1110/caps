package article.notice.model;

import java.util.Date;
import article.notice.model.Writer;

public class Notice {

	private int postNo;
	private Writer writer;
	private String title;
	private Date regDate;
	private Date modDate;
	private int readCnt;

	public Notice(int postNo, Writer writer, String title, 
			Date regDate, Date modDate, int readCnt) {
		this.postNo = postNo;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.readCnt = readCnt;
	}

	public int getPostNo() {
		return postNo;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public int getReadCnt() {
		return readCnt;
	}

}
