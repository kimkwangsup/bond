package bond.vo;

import java.util.Date;
import java.sql.*;
import java.text.*;

/**
 * 이 클래스는 게시판 한개의 데이터를 기억할 수 있는 클래스이다.
 * @author 	김광섭
 * @since 	2024.04.01
 * @version V.1.0
 * 			2024.04.01 - 클래스 제작 [ 담당자 : 김광섭 ]
 *
 */
public class BoardVO {
	private int gno, mno, ano, cnt;
	private String id, body, sname, sdate;
	private Date wdate;
	private Time wtime;
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
		sdate = form1.format(wdate) + form2.format(wtime);
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Time getWtime() {
		return wtime;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setSdate();
	}
	@Override
	public String toString() {
		return "BoardVO [gno=" + gno + ", mno=" + mno + ", ano=" + ano + ", cnt=" + cnt + ", id=" + id + ", body="
				+ body + ", sname=" + sname + ", sdate=" + sdate + ", wdate=" + wdate + ", wtime=" + wtime + "]";
	}
	
}
