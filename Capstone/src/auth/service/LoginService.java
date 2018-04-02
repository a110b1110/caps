package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.*;
import member.model.*;
import team.teamnum;

public class LoginService {
	
	private teamnum Group = new teamnum();
	
	private ProfessorDao professorDao = new ProfessorDao();
	private StudentDao studentDao = new StudentDao();
	
	public User login(String id, String password, int grade) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			if(grade == Group.pronumber){
				Professor professor = professorDao.selectById(conn, id);
				if (professor == null) {
					throw new LoginFailException();
				}
				if (!professor.matchPassword(password)) {
					throw new LoginFailException();
				}
				return new User(professor.getProId(), professor.getProname(), 
						professor.getGroupNo());
			}
			else if(grade == Group.stunumber){
				Student student = studentDao.selectById(conn, id);
				if (student == null) {
					throw new LoginFailException();
				}
				if (!student.matchPassword(password)) {
					throw new LoginFailException();
				}
				return new User(student.getStuId(), student.getStuname(), student.getGroupNo());
			}
			else{	//그룹 선택 안하면 로그인 못하게 해야함.
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}