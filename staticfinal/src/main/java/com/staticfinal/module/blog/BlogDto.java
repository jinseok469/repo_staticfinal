package com.staticfinal.module.blog;

public class BlogDto {
	
	private String seq;
	private String name;
	private String user_seq;
	private	String blogCategory_seq;
	private String categoryName;
	private int buied;
	private String title;
	private int bgDelNy;
	
	public int getBgDelNy() {
		return bgDelNy;
	}
	public void setBgDelNy(int bgDelNy) {
		this.bgDelNy = bgDelNy;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public String getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}
	public String getBlogCategory_seq() {
		return blogCategory_seq;
	}
	public void setBlogCategory_seq(String blogCategory_seq) {
		this.blogCategory_seq = blogCategory_seq;
	}
	public int getBuied() {
		return buied;
	}
	public void setBuied(int buied) {
		this.buied = buied;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
