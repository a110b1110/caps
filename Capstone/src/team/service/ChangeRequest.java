package team.service;

import java.util.Map;
import java.util.ArrayList;

public class ChangeRequest {

	private ArrayList<String> stuIds = new ArrayList<String> ();			//최소 3명 ~ 최대 5명으로 팀생성이 가능하게 최대크기 5로 배열 생성 후 나머지 null값
	private String teamName;
	private String teamSubject;
	private String advisor;
	
	//이거 느낌이 뷰랑 ""안에 이름이 같아야 할듯
	public void validate(Map<String, Boolean> errors) {
		if(stuIds.size()<2||stuIds.size()>5) {
			errors.put("the number of members isn't satified.", Boolean.TRUE);
		}
		for(int i = 0; i<stuIds.size();i++) {
			checkEmpty(errors, stuIds.get(i), "id");
		}
		checkEmpty(errors, teamName, "name");
		checkEmpty(errors, teamSubject, "teamSubject");
		checkEmpty(errors, advisor, "advisor");
	}
	
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}

	public ArrayList<String> getStuIds() {
		return stuIds;
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
	
	/* 정수형이 없어서 아래 오버로딩된 함수는 주석 처리*/
	/* id, group의 입력값이 0인지 아닌지 확인 */
	/*
	private void checkEmpty(Map<String, Boolean> errors, 
			Integer id, String fieldName) {
		if (id == 0)
			errors.put(fieldName, Boolean.TRUE);
	}*/
}