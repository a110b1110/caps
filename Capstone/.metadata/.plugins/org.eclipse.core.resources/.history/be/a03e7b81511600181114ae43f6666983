package article.team.model;

import java.util.Date;

public class TeamArticle {

	private String fileNo;				//파일 고유 번호
	private String origin;				//파일 이름
	private String stored;				//파일 고유 이름(시스템)
	private TeamArticleWriter writer;	//작성자(팀번호, 학번)
	private long fileSize;				//파일 크기
	private String fileExt;				//파일 확장자
	private Date regDate;				//등록일자
	private Date modifiedDate;			//수정일자
	private int downCount;				//조회수
	
	public TeamArticle(String fileNo, String origin, String stored, TeamArticleWriter writer, 
			long size, String ext, Date regDate, Date modifiedDate, int downCount) {
		this.fileNo = fileNo;
		this.origin = origin;
		this.stored = stored;
		this.writer = writer;
		this.fileSize = size;
		this.fileExt = ext;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.downCount = downCount;
	}

	public String getFileNo() {
		return fileNo;
	}

	public String getOrigin() {
		return origin;
	}

	public String getStored() {
		return stored;
	}

	public TeamArticleWriter getWriter() {
		return writer;
	}

	public long getFileSize() {
		return fileSize;
	}

	public String getFileExt() {
		return fileExt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getDownCount() {
		return downCount;
	}
}
