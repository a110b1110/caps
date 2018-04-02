package member.model;

import java.util.Date;

public class Professor {
   private String proId;            //교번
   private String proName;         //교수이름
   private String password;      //패스워드
   private int groupNo;      //등급(교수 : 1)
   private String phoneNo;      //핸드폰 번호
   private String proEmail;      //교수 이메일
   private Date proJoinDate;      //교수 가입일자
   
   public Professor(String id, String name, String password, 
         String phoneNo, String email, Date regDate) {
      this.proId = id;
      this.proName = name;
      this.password = password;
      this.groupNo = 1;            //초기값 : 1
      this.phoneNo = phoneNo;
      this.proEmail = email;
      this.proJoinDate = regDate;
   }

   public Professor(String id, String name, String password, int groupNo,
         String phoneNo, String email, Date regDate) {
      this.proId = id;
      this.proName = name;
      this.password = password;
      this.groupNo = groupNo;            
      this.phoneNo = phoneNo;
      this.proEmail = email;
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
   public String getProId() {
      return proId;
   }
   public String getProname() {
      return proName;
   }
   public String getPassword() {
      return password;
   }
   public String getPhoneNo() {
      return phoneNo;
   }
   public String getProemail() {
      return proEmail;
   }
   public Date getProJoinDate() {
      return proJoinDate;
   }
   public int getGroupNo() {
      return groupNo;
   }
}