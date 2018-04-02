package member.model;

import java.util.Date;

public class Professor {
	private int proId;				//교번
	private String proname;			//교수이름
	private String password;		//패스워드
	private int GroupNumber;		//등급(교수 : 1)
	private String phonenumber;		//핸드폰 번호
	private String proemail;		//교수 이메일
	private Date proJoinDate;		//교수 가입일자
	
	public Professor(int id, String name, String password, 
			String phonenumber, String email, Date regDate) {
		this.proId = id;
		this.proname = name;
		this.password = password;
		this.GroupNumber = 1;				//초기값 : 1
		this.phonenumber = phonenumber;
		this.proemail = email;
		this.proJoinDate = regDate;
	}

	public Professor(int id, String name, String password, int GroupNumber,
			String phonenumber, String email, Date regDate) {
		this.proId = id;
		this.proname = name;
		this.password = password;
		this.GroupNumber = GroupNumber;				
		this.phonenumber = phonenumber;
		this.proemail = email;
		this.proJoinDate = regDate;
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
	public int getProId() {
		return proId;
	}
	public String getProname() {
		return proname;
	}
	public String getPassword() {
		return password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public String getProemail() {
		return proemail;
	}
	public Date getProJoinDate() {
		return proJoinDate;
	}
	public int getGroupNumber() {
		return GroupNumber;
	}
}