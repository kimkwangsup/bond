package bond.dao;

import java.sql.*;

import bond.sql.*;
import bond.vo.*;
import bond.db.*;
import bond.sql.*;


public class MemberDao {
	private BondDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSQL mSql;
	private String sql;
	
	public MemberDao() {
		db = new BondDBCP();
		mSql = new MemberSQL();
	}
	public int getLogin(String id, String pw) {
		int cnt = 0;
		con = db.getCon();
		sql = mSql.getSQL(mSql.SEL_LOGIN);
		pstmt = db.getPstmt(sql, con);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int getIdCnt(String id) {
		int cnt = 0;
		con = db.getCon();
		sql = mSql.getSQL(mSql.SEL_ID_CNT);
		pstmt = db.getPstmt(sql, con);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int addMember(MemberVO vo) {
		int cnt = 0;
		con = db.getCon();
		sql = mSql.getSQL(mSql.ADD_MEMB);
		pstmt = db.getPstmt(sql, con);
		try {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getMail());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getGen());
			pstmt.setInt(7, vo.getAno());;
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
