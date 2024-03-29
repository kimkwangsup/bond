package bond.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;

public class Logout implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/main.bond";
		req.setAttribute("isRedirect", true);
		HttpSession session = req.getSession();
		if(session.getAttribute("SID") != null) {
			session.removeAttribute("SID");
		}
		return view;
	}

}
