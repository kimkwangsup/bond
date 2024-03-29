package bond.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;
import bond.dao.*;
import bond.vo.*;

public class JoinProc implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/main.bond";
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String mail = req.getParameter("mail");
		String tel = req.getParameter("tel");
		String gen = req.getParameter("gen");
		String avt = req.getParameter("avt");
		int avatar = Integer.parseInt(avt);
		
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setId(id);
		vo.setPw(pw);
		vo.setMail(mail);
		vo.setTel(tel);
		vo.setGen(gen);
		vo.setAno(avatar);
		
		MemberDao mDao = new MemberDao();
		int cnt = mDao.addMember(vo);
		if(cnt != 1) {
			view = "/member/join.bond";
		}else {
			req.getSession().setAttribute("SID", id);
		}
		return view;
	}

}
