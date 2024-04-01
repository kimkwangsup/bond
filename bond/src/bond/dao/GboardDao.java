package bond.dao;

import java.util.*;
import java.sql.*;
import bond.sql.*;
import bond.db.*;

public class GboardDao {
	private BondDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private GboardSQL gSql;
	private String sql;
	public GboardDao() {
		
	}
}
