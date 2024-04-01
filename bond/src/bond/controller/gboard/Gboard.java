package bond.controller.gboard;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;
import bond.dao.*;
import bond.vo.*;

public class Gboard implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 뷰
		String view = "gboard/gboard";
		// 응답방식
		req.setAttribute("isRedirect", false);
		// 할일
		// 세션검사
		String sid = (String) req.getSession().getAttribute("SID");
		// 파라미터 꺼내고
		String msg = req.getParameter("msg");
		if(msg != null) {
			req.setAttribute("MSG", msg);
		}
		// 데이터베이스 사용 준비
		GboardDao gDao = new GboardDao();
		if(sid != null) {
			// 로그인 한 사람의 경우 작성한 글 카운트 조회
			int cnt = gDao.getCnt(sid);
			// 데이터 세팅
			req.setAttribute("CNT", cnt);
		} 
		// 게시글 리스트 꺼내오기
		ArrayList<BoardVO> list = gDao.getList();
		req.setAttribute("LIST", list);
		return view;
	}

}
