package com.staticfinal.module.user;

public class UserDto {
	private String seq;
	private String name;
	private int gender ;
	private String dob;
	private String nickName;
	private String id;
	private String password;
	private String email;
	private int urDelNy;
	private String cdName;
	private String lastSeq;
	private String urReg;
	private String urMof;
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrReg() {
		return urReg;
	}
	public void setUrReg(String urReg) {
		this.urReg = urReg;
	}
	public String getUrMof() {
		return urMof;
	}
	public void setUrMof(String urMof) {
		this.urMof = urMof;
	}
	public String getLastSeq() {
		return lastSeq;
	}
	public void setLastSeq(String lastSeq) {
		this.lastSeq = lastSeq;
	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public int getUrDelNy() {
		return urDelNy;
	}
	public void setUrDelNy(int urDelNy) {
		this.urDelNy = urDelNy;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getBetterAddress() {
		return betterAddress;
	}
	public void setBetterAddress(String betterAddress) {
		this.betterAddress = betterAddress;
	}
	private String postalCode;
	private String betterAddress;

}
