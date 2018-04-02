package article.team.model;

public class TeamArticleWriter {

	private String teamNo;
	private String writerId;

	public TeamArticleWriter(String teamNo, String writerId) {
		this.teamNo = teamNo;
		this.writerId = writerId;
	}

	public String getTeamNo() {
		return teamNo;
	}

	public String getWriterId() {
		return writerId;
	}

}
