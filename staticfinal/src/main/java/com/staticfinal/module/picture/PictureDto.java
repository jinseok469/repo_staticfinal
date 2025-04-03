package com.staticfinal.module.picture;

import java.util.List;

public class PictureDto {
	private String seq;
	private String title;
	private String useCamera;
	private String photoPlace;
	private String photoIntroduce;
	private String pictureCategory_seq;
	private String user_seq;
	private String categoryName;
	private String name;
	private String nickName;
	private int ptDelNy;
	private List<String> seqList;
	private String bpReg;
	private String bpMof;
	
	
	
	public String getBpReg() {
		return bpReg;
	}
	public void setBpReg(String bpReg) {
		this.bpReg = bpReg;
	}
	public String getBpMof() {
		return bpMof;
	}
	public void setBpMof(String bpMof) {
		this.bpMof = bpMof;
	}
	public List<String> getSeqList() {
		return seqList;
	}
	public void setSeqList(List<String> seqList) {
		this.seqList = seqList;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUseCamera() {
		return useCamera;
	}
	public void setUseCamera(String useCamera) {
		this.useCamera = useCamera;
	}
	public String getPhotoPlace() {
		return photoPlace;
	}
	public void setPhotoPlace(String photoPlace) {
		this.photoPlace = photoPlace;
	}
	public String getPhotoIntroduce() {
		return photoIntroduce;
	}
	public void setPhotoIntroduce(String photoIntroduce) {
		this.photoIntroduce = photoIntroduce;
	}
	public String getPictureCategory_seq() {
		return pictureCategory_seq;
	}
	public void setPictureCategory_seq(String pictureCategory_seq) {
		this.pictureCategory_seq = pictureCategory_seq;
	}
	public String getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getPtDelNy() {
		return ptDelNy;
	}
	public void setPtDelNy(int ptDelNy) {
		this.ptDelNy = ptDelNy;
	}
	
	
}
