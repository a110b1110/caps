package article.team.service;

import java.util.Map;

import article.team.model.TeamArticleWriter;

/*writerequest랑 똑같음*/
public class ModifyRequest {
	
	private String fileNo;
	private String title;
	private String origin;				//파일 이름
	private String stored;				//파일 고유 이름(시스템)
	private TeamArticleWriter writer;	//작성자(팀번호, 학번)
	private long fileSize;				//파일 크기
	private String fileExt;				//파일 확장자
	
	public ModifyRequest(String fileNo, String title, String origin, String stored, 
			TeamArticleWriter writer, long size, String ext) {
		this.fileNo = fileNo;
		this.title = title;
		this.origin = origin;
		this.stored = stored;
		this.writer = writer;
		this.fileSize = size;
		this.fileExt = ext;
	}

	public String getFileNo() {
		return this.fileNo;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public TeamArticleWriter getWriter() {
		return writer;
	}
	
	public String getOrigin() {
		return origin;
	}

	public String getStored() {
		return stored;
	}

	public long getFileSize() {
		return fileSize;
	}

	public String getFileExt() {
		return fileExt;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if (origin == null || origin.trim().isEmpty()) {
			errors.put("origin", Boolean.TRUE);
		}
	}
}
