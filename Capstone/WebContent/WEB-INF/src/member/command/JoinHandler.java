package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;
import group.groupnum.*;

public class JoinHandler implements CommandHandler {
	final private int TEAM_DEFAULT = 0;	
	
	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";
	private JoinService joinService = new JoinService();
	private Groupnum groupnum;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(parseint(req.getParameter("id").trim()));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		joinReq.setGroupnumber(parseint(req.getParameter("groupnumber")));
		joinReq.setPhonenumber(req.getParameter("phonenumber"));
		joinReq.setEmail(req.getParameter("email"));
		if(joinReq.getGroupnumber()==groupnum.stunumber){
			joinReq.setTeamnumber(TEAM_DEFAULT);
		}
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			if(joinReq.getGroupnumber()==groupnum.pronumber){
				joinService.join_pro(joinReq);	
				return "/WEB-INF/view/joinSuccess.jsp";
			}
			else if(joinReq.getGroupnumber()==groupnum.stunumber){
				joinService.join_stu(joinReq);
				return "/WEB-INF/view/joinSuccess.jsp";
			}
			else{
				errors.put("choose group!!", Boolean.TRUE);
				return FORM_VIEW;
			}
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	private int parseint(String str) {
		String temp = str;
		try{
			return Integer.parseInt(temp);
		} catch(NumberFormatException nfe){
			System.err.println(nfe);
			throw new LoginFailException();
		}
	}
}
