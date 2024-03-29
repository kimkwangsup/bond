package bond.vo;

import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * 
 * @author	김광섭
 * @since	2024.03.29
 * @version	V.1.0
 * 			2024.03.29 - bond MemberVO 제작 
 */
public class MemberVO {
	private int mno, ano, cnt;
	private String name, id, pw, mail, tel, gen, avtname, sdate;
	private Date jdate;
	private Time jtime;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getAvtname() {
		return avtname;
	}
	public void setAvtname(String avtname) {
		this.avtname = avtname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat();
		SimpleDateFormat form2 = new SimpleDateFormat();
		
		sdate = form1.format(jdate) + form2.format(jtime);
	}
	public Date getJdate() {
		return jdate;
	}
	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}
	public Time getJtime() {
		return jtime;
	}
	public void setJtime(Time jtime) {
		this.jtime = jtime;
		setSdate();
	}
	
	
}
