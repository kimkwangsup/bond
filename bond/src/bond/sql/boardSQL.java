package bond.sql;

public class boardSQL {
	public final int SEL_ALL_LIST = 1001;
	public final int SEL_ID_CNT = 1002;
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	mno, gno, id, filename sname, wdate, body ");
			buff.append("FROM ");
			buff.append("	member, avatar, gboard ");
			buff.append("WHERE ");
			buff.append("	mno = writer ");
			buff.append("	AND avatar = ano ");
			buff.append("ORDER BY ");
			buff.append("	wdate DESC ");
			break;
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member m, gboard g ");
			buff.append("WHERE ");
			buff.append("    m.mno = g.writer ");
			buff.append("    AND id = ?  ");
			break;
		}
		
		
		return buff.toString();
	}
}
