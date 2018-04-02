package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.*;
import member.model.*;

public class ChangePasswordService {
	
	//14번째 라인 필요 없음 나중에 수정
	private ProfessorDao professorDao = new ProfessorDao();
	private StudentDao studentDao = new StudentDao();
	
	public void changePassword_Pro(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Professor professor = professorDao.selectById(conn, userId);
			if (professor == null) {
				throw new MemberNotFoundException();
			}
			if (!professor.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			professor.changePassword(newPwd);
			professorDao.update(conn, professor);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public void changePassword_Stu(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Student student = studentDao.selectById(conn, userId);
			if (student == null) {
				throw new MemberNotFoundException();
			}
			if (!student.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			student.changePassword(newPwd);
			studentDao.update(conn, student);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}