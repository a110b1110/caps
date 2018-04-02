package article.team.model;

public class TeamContent {

	private String fileNo;
	private String origin;
	private String stored;
	private long fileSize;
	private String fileExt;

	public TeamContent(String fileNo, String origin, String stored, 
			long fileSize, String fileExt) {
		this.fileNo = fileNo;
		this.origin = origin;
		this.stored = stored;
		this.fileSize = fileSize;
		this.fileExt = fileExt;
		
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

	public long getFileSize() {
		return fileSize;
	}

	public String getFileExt() {
		return fileExt;
	}
}
