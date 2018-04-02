package team.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.*;
import member.model.*;
import team.service.MakeTeamRequest;;


public class MakeTeamService {

	private ProfessorDao professorDao = new ProfessorDao();
	private StudentDao studentDao = new StudentDao();
	
	public void MakeTeam(MakeTeamRequest mtReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ArrayList<String> students = mtReq.getStuIds();
			
			for(int i = 0 ; i < students.size() ; i++) {
				Student stu = studentDao.selectById(conn, students.get(i));
				if(true) {
					/* 이부분은 만약 추가하려는 팀원이 이미 다른 팀에 있는 경우 오류 처리하기 위해 작성 */
				}
			}
			
			Professor professor = professorDao.selectById(conn, mtReq.getAdvisor());
			if (professor != null) {
				JdbcUtil.rollback(conn);
				
				/*해당 교수님이 없음에 대한 에러 처리 부분*/
				/*	throw new DuplicateIdException(); */
			}
			
			professorDao.insert(conn, 
					new Professor(
							joinReq.getId(), 
							joinReq.getName(), 
							joinReq.getPassword(),
							joinReq.getGroupNo(),
							joinReq.getPhoneNo(),
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
							joinReq.getGroupNo(),
							joinReq.getPhoneNo(),
							joinReq.getTeamNo(),
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
