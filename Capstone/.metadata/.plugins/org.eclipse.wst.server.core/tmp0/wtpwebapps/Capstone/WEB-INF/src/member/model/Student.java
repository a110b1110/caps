package member.model;

import java.util.Date;

/* 시스템 회원 : 학생(기본키 : stuId) */
public class Student {
	private int stuId;				//학번
	private String stuname;			//학생이름
	private String password;		//패스워드
	private int GroupNumber;		//등급
	private String phonenumber;		//핸드폰 번호
	private int TeamNumber;			//팀번호
	private String stuemail;		//학생 이메일
	private Date stuJoinDate;		//학생 가입일자
	
	public Student(int id, String name, String password, int GroupNumber,
			String phonenumber, int TeamNumber, String email, Date regDate) {
		this.stuId = id;
		this.stuname = name;
		this.password = password;
		this.GroupNumber = GroupNumber;
		this.phonenumber = phonenumber;
		this.TeamNumber = TeamNumber;
		this.stuemail = email;
		this.stuJoinDate = regDate;
	}
	public Student(int id, String name, String password,
			String phonenumber, String email, Date regDate) {
		this.stuId = id;
		this.stuname = name;
		this.password = password;
		this.phonenumber = phonenumber;
		this.stuemail = email;
		this.stuJoinDate = regDate;
		/* 그룹, 팀 - 초기값 : 0 */
		this.GroupNumber = 2;
		this.TeamNumber = 0;
	}
	
	/* 비밀번호 확인 */
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	/* 비밀번호 변경 */
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	
	/* 멤버변수 -> get메소드 */
	public int getStuId() {
		return stuId;
	}
	public String getStuname() {
		return stuname;
	}
	public String getPassword() {
		return password;
	}
	public int getGroupNumber() {
		return GroupNumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public int getTeamNumber() {
		return TeamNumber;
	}
	public String getStuemail() {
		return stuemail;
	}
	public Date getStuJoinDate() {
		return stuJoinDate;
	}
	
}
