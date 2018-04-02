package team.model;

import java.util.Date;

/* 팀  */
public class Team {
	private String teamNo;				//팀번호???-> 그룹번호랑 무슨 상관?
	private String teamName;			//팀이름
	private String teamSubject;			//TeamSubject????
	private String advisor;				//지도교수
	private boolean state;				//팀상태
	private int groupNo;			//그룹번호?
	private Date teamJoinDate;			//팀생성일
	
	/*생성자*/
	public Team(String teamNum, String teamName, String TeamSubject, String proId, 
			 boolean state, int GroupNumber, Date teamJoinDate) {
		this.teamNo = teamNum;
		this.teamName = teamName;
		this.teamSubject = TeamSubject;
		this.advisor = proId;
		this.state = state;
		this.groupNo = GroupNumber;
		this.teamJoinDate = teamJoinDate;
	}

	public String getTeamNo() {
		return teamNo;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getTeamSubject() {
		return teamSubject;
	}

	public String getAdvisor() {
		return advisor;
	}

	public boolean isState() {
		return state;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public Date getTeamJoinDate() {
		return teamJoinDate;
	}
	
}
