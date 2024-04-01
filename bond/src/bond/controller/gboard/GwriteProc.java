package bond.controller.gboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;
import bond.dao.*;

public class GwriteProc implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 뷰
		String view = "/gboard/gboard.bond";
		// 응답 방식
		req.setAttribute("isRedirect", true);
		// 데이터베이스 작업
		String id = req.getParameter("id");
		String body = req.getParameter("body");
		GboardDao gDao = new GboardDao();
		int cnt = gDao.addGboard(id, body);
		String msg = "?msg=OK";
		if(cnt == 1) {
			// 글 등록 성공
			msg = "?msg=OK";
		}else {
			// 글 등록 실패
			msg = "?msg=NO";
		}
		return view + msg;
	}

}
