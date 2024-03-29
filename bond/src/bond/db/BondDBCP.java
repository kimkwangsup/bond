package bond.db;

import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;

public class BondDBCP {
	public DataSource ds;
	
	public BondDBCP() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/TestDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getCon() {
		Connection con = null;
		try {
			con = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Statement getStmt(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	public PreparedStatement getPstmt(String sql, Connection con) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	public void close(Object o) {
		try {
			if(o instanceof Connection) {
				((Connection) o).close();
			}else if(o instanceof Statement) {
				((Statement) o).close();
			}else if(o instanceof PreparedStatement) {
				((PreparedStatement)o).close();
			}else if(o instanceof ResultSet) {
				((ResultSet)o).close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
