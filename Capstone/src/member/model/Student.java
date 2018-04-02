package member.model;

import java.util.Date;

/* 시스템 회원 : 학생(기본키 : stuId) */
public class Student {
   private String stuId;            //학번
   private String stuName;         //학생이름
   private String password;      //패스워드
   private int groupNo;      //등급(팀 없는 학생 : 2, 팀 있는 학생 : 3)
   private String phoneNo;      //핸드폰 번호
   private String teamNo;         //팀번호
   private String stuEmail;      //학생 이메일
   private Date stuJoinDate;      //학생 가입일자
   
   public Student(String id, String name, String password, int groupNo,
         String phoneNo, String teamNo, String email, Date regDate) {
      this.stuId = id;
      this.stuName = name;
      this.password = password;
      this.groupNo = groupNo;
      this.phoneNo = phoneNo;
      this.teamNo = teamNo;
      this.stuEmail = email;
      this.stuJoinDate = regDate;
   }
   public Student(String id, String name, String password,
         String phoneNo, String email, Date regDate) {
      this.stuId = id;
      this.stuName = name;
      this.password = password;
      this.phoneNo = phoneNo;
      this.stuEmail = email;
      this.stuJoinDate = regDate;
      /* 그룹, 팀 - 초기값 */
      this.groupNo = 2;            //팀 없는 학생 : 2
      this.teamNo = "00000";         //초기값 : 00000
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
   public String getStuId() {
      return stuId;
   }
   public String getStuname() {
      return stuName;
   }
   public String getPassword() {
      return password;
   }
   public int getGroupNo() {
      return groupNo;
   }
   public String getPhoneNo() {
      return phoneNo;
   }
   public String getTeamNo() {
      return teamNo;
   }
   public String getStuemail() {
      return stuEmail;
   }
   public Date getStuJoinDate() {
      return stuJoinDate;
   }
   
}