package bond.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;
import bond.dao.*;

public class LoginProc implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/main.bond";
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLogin(sid, spw);
		if(cnt != 1) {
			view = "/member/login.bond";
			return view;
		}
		req.getSession().setAttribute("SID", sid);
		return view;
	}

}
