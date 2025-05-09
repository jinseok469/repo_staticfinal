package com.staticfinal.module.upload;

import org.springframework.web.multipart.MultipartFile;

public class UploadDto {
	private String tableName;
	private String iSeq;
	private int defaultNy;
	private int sort;
	private String path;
	private String originalName;
	private String uuidName;
	private String ext;
	private long size;
	private String pSeq;
	private String uploadedDate;
	private MultipartFile uploadImg;
	private MultipartFile[] uploadImg1;
	
	
	
	
	public MultipartFile getUploadImg() {
		return uploadImg;
	}
	public void setUploadImg(MultipartFile uploadImg) {
		this.uploadImg = uploadImg;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getiSeq() {
		return iSeq;
	}
	public void setiSeq(String iSeq) {
		this.iSeq = iSeq;
	}
	public int getDefaultNy() {
		return defaultNy;
	}
	public void setDefaultNy(int defaultNy) {
		this.defaultNy = defaultNy;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getUuidName() {
		return uuidName;
	}
	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getpSeq() {
		return pSeq;
	}
	public void setpSeq(String pSeq) {
		this.pSeq = pSeq;
	}
	public String getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public MultipartFile[] getUploadImg1() {
		return uploadImg1;
	}
	public void setUploadImg1(MultipartFile[] uploadImg1) {
		this.uploadImg1 = uploadImg1;
	}
	
	
}
