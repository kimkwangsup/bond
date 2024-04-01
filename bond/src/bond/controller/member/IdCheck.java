package bond.controller.member;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bond.controller.*;
import bond.dao.*;

public class IdCheck implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", null);
		String sid = req.getParameter("id");
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getIdCnt(sid);
		String view = "{\"result\": \"YES\"}";
		
		if(cnt != 0 ) {
			view = "{\"result\": \"NO\"}";
		}
		return view;
	}

}
