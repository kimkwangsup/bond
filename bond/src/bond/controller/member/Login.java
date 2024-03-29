package bond.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;

public class Login implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object sid = session.getAttribute("SID");
		if(sid != null) {
			req.setAttribute("isRedirect", true);
			return "/main.bond";
		}
		req.setAttribute("isRedirect", false);
		return "member/login";
	}

}
