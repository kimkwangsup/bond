package bond.dao;

import java.util.*;
import java.sql.*;
import bond.sql.*;
import bond.vo.*;
import bond.db.*;
/**
 * 이 클래스는 방명록 관련 데이터베이스 작업 전담 처리 클래스
 * @author  김광섭
 * @since	2024.04.01
 * @version V.1.0
 * 			2024.04.01 -	클래스 제작
 * 							방명록 리스트 조회 추가 [ 담당자 : 김광섭 ] 
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
		
		return list;
	}
}
