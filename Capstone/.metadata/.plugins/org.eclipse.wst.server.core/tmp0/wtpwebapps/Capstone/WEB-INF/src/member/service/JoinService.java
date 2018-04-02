package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.*;
import member.model.*;

public class JoinService {
	
	final private int DEFAULT_TEAM = 0;

	private ProfessorDao professorDao = new ProfessorDao();
	private StudentDao studentDao = new StudentDao();
	
	public void join_pro(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Professor professor = professorDao.selectById(conn, joinReq.getId());
			if (professor != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			professorDao.insert(conn, 
					new Professor(
							joinReq.getId(), 
							joinReq.getName(), 
							joinReq.getPassword(),
							joinReq.getGroupnumber(),
							joinReq.getPhonenumber(),
							joinReq.getEmail(),
							new Date())
					);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public void join_stu(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Student student = studentDao.selectById(conn, joinReq.getId());
			if (student != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			studentDao.insert(conn, 
					new Student(
							joinReq.getId(), 
							joinReq.getName(), 
							joinReq.getPassword(),
							joinReq.getGroupnumber(),
							joinReq.getPhonenumber(),
							joinReq.getTeamnumber(),
							joinReq.getEmail(),
							new Date())
					);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
