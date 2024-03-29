package bond.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;

public class Join implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object sid = req.getSession().getAttribute("SID");
		if(sid != null) {
			req.setAttribute("isRedirect", true);
			return "/main.bond";
		}
		
		String view = "member/join";
		return view;
	}

}
