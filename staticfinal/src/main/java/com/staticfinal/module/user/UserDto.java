package com.staticfinal.module.user;

import com.staticfinal.module.upload.UploadDto;

public class UserDto extends UploadDto{
	private String seq;
	private String name;
	private int gender ;
	private String dob;
	private String nickName;
	private String id;
	private String password;
	private String email;
	private int urDelNy;
	private String urReg;
	private String urMof;
	private String urSeq;
	private String streetAddress;
	private String notes;
	private Double latitude;
	private Double longitude;
	private String mainImage;
	private String tpTitle = "회원가입을 진심으로 축하드립니다";
	
	
	
	
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public String getTpTitle() {
		return tpTitle;
	}
	public void setTpTitle(String tpTitle) {
		this.tpTitle = tpTitle;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	private String cdName;
	
	private String lastSeq;
	
	private String url;
	
	private String title;
	private String betterBlog_seq;
	private String blogCategory_seq;
	private String item;
	private String infoPrice;
	
	private String clotheInfo_seq;
	private String user_seq;
	private String infoseq;
	
	private String buyDate;
	
	
	
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getInfoseq() {
		return infoseq;
	}
	public void setInfoseq(String infoseq) {
		this.infoseq = infoseq;
	}
	public String getClotheInfo_seq() {
		return clotheInfo_seq;
	}
	public void setClotheInfo_seq(String clotheInfo_seq) {
		this.clotheInfo_seq = clotheInfo_seq;
	}
	public String getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getInfoPrice() {
		return infoPrice;
	}
	public void setInfoPrice(String infoPrice) {
		this.infoPrice = infoPrice;
	}
	public String getBlogCategory_seq() {
		return blogCategory_seq;
	}
	public void setBlogCategory_seq(String blogCategory_seq) {
		this.blogCategory_seq = blogCategory_seq;
	}
	public String getBetterBlog_seq() {
		return betterBlog_seq;
	}
	public void setBetterBlog_seq(String betterBlog_seq) {
		this.betterBlog_seq = betterBlog_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrSeq() {
		return urSeq;
	}
	public void setUrSeq(String urSeq) {
		this.urSeq = urSeq;
	}
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
