package team.model;

import java.util.Date;

/*이거 권한 인가? */
public class Group {
	private int groupNumber;			//그룹번호?
	private String groupName;			//팀이름이랑 다른가?? 팀이름 문자열 20byte // 그룹이름 문자열 10byte?
	
	/*생성자*/
	public  Group(int groupNumber, String groupName) {
		this.groupNumber = groupNumber;
		this.groupName = groupName;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
