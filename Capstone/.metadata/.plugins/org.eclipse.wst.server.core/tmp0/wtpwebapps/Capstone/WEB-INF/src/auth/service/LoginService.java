package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.*;
import member.model.*;
import group.groupnum.*;

public class LoginService {
	
	private Groupnum Group = new Groupnum();
	
	private ProfessorDao professorDao = new ProfessorDao();
	private StudentDao studentDao = new StudentDao();
	
	public User login(int id, String password, int group) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			if(group == Group.pronumber){
				Professor professor = professorDao.selectById(conn, id);
				if (professor == null) {
					throw new LoginFailException();
				}
				if (!professor.matchPassword(password)) {
					throw new LoginFailException();
				}
				return new User(professor.getProId(), professor.getProname(), 
						professor.getGroupNumber());
			}
			else if(group == Group.stunumber){
				Student student = studentDao.selectById(conn, id);
				if (student == null) {
					throw new LoginFailException();
				}
				if (!student.matchPassword(password)) {
					throw new LoginFailException();
				}
				return new User(student.getStuId(), student.getStuname(), 
						student.getGroupNumber());
			}
			else{	//그룹 선택 안하면 로그인 못하게 해야함.
				throw new LoginFailException();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
