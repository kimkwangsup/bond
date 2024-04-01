package bond.dao;

import java.util.*;
import java.util.Date;
import java.sql.*;
import bond.sql.*;
import bond.vo.*;
import sun.nio.cs.ext.DoubleByte.Decoder_DBCSONLY;
import bond.db.*;
/**
 * 이 클래스는 방명록 관련 데이터베이스 작업 전담 처리 클래스
 * @author  김광섭
 * @since	2024.04.01
 * @version V.1.0
 * 			2024.04.01 -	클래스 제작
 * 							방명록 리스트 조회, 글 등록 추가 [ 담당자 : 김광섭 ] 
 */
public class GboardDao {
	private BondDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private boardSQL gSQL;
	private String sql;
	public GboardDao() {
		db = new BondDBCP();
		gSQL = new boardSQL();
	}
	// 방명록 리스트 조회 전담 처리함수
	public ArrayList<BoardVO> getList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// 할일
		// 데이터베이스 조회
		// 커넥션
		con = db.getCon();
		// 질의명령
		sql = gSQL.getSQL(gSQL.SEL_ALL_LIST);
		// 명령전달도구
		stmt = db.getStmt(con);
		try {
			// 질의명령 보내고 결과받고
			rs = stmt.executeQuery(sql);
			// 데이터 꺼내고
			while(rs.next()) {
				int mno = rs.getInt("mno");
				int gno = rs.getInt("gno");
				String id = rs.getString("id");
				String body = rs.getString("body");
				String sname = rs.getString("sname");
				Date wdate = rs.getDate("wdate");
				Time wtime = rs.getTime("wdate");
				// VO 만들어서 채우고
				BoardVO vo = new BoardVO();
				vo.setGno(gno);
				vo.setMno(mno);
				vo.setId(id);
				vo.setBody(body);
				vo.setSname(sname);
				vo.setWdate(wdate);
				vo.setWtime(wtime);
				// 리스트에 채우고
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		// 리스트 반환
		return list;
	}
	/**
	 * 로그인한 사람이 작성한 글카운트 조회 전담 처리함수
	 */
	public int getCnt(String id) {
		// 할일
		// 반환값 변수
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		sql = gSQL.getSQL(gSQL.SEL_ID_CNT);
		// 명령전달도구
		pstmt = db.getPstmt(sql, con);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			// 질의명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 데이터 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 데이터 반환
		return cnt;
	}
	/**
	 * 방명록 글 등록 데이터베이스 작업 전담 처리함수
	 */
	public int addGboard(String id, String body) {
		// 반환값 변수
		int cnt = 0;
		// 할일
		// 커넥션
		con = db.getCon();
		// 질의명령
		sql = gSQL.getSQL(gSQL.ADD_GBOARD);
		// 명령전달도구
		pstmt = db.getPstmt(sql, con);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			pstmt.setString(2, body);
			// 보내고 결과받고
			cnt = pstmt.executeUpdate(); // 추가된 행 수 반환
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		// 결과 반환하고
		return cnt;
	}
}
