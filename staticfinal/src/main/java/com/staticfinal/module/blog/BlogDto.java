package com.staticfinal.module.blog;

import java.util.List;


import com.staticfinal.module.upload.UploadDto;

public class BlogDto extends UploadDto{
	
	private String seq;
	private String name;
	private String user_seq;
	private	String blogCategory_seq;
	private String categoryName;
	private int buied;
	private String title;
	private int bgDelNy;	
	private String blogIntroduction;
	private Integer modelHeight;
	private Integer modelWeight;
	private String modelSize;
	private Integer modelShoesSize;
	private String item;
	private String buyLink;
	private Integer infoPrice;
	private String itemBrand;
	private String infoseq;
	private String nickName;
	private String bcSeq;
	private String betterBlog_seq;
	private String bgReg;
	private String bgMof;
	private List<BlogDto> items;
	private String blogKey;
	private String url;
	
	
	
	
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBlogKey() {
		return blogKey;
	}
	public void setBlogKey(String blogKey) {
		this.blogKey = blogKey;
	}
	public List<BlogDto> getItems() {
		return items;
	}
	public void setItems(List<BlogDto> items) {
		this.items = items;
	}
	public String getBgReg() {
		return bgReg;
	}
	public void setBgReg(String bgReg) {
		this.bgReg = bgReg;
	}
	public String getBgMof() {
		return bgMof;
	}
	public void setBgMof(String bgMof) {
		this.bgMof = bgMof;
	}
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
	public String getBlogIntroduction() {
		return blogIntroduction;
	}
	public void setBlogIntroduction(String blogIntroduction) {
		this.blogIntroduction = blogIntroduction;
	}
	public Integer getModelHeight() {
		return modelHeight;
	}
	public void setModelHeight(Integer modelHeight) {
		this.modelHeight = modelHeight;
	}
	public Integer getModelWeight() {
		return modelWeight;
	}
	public void setModelWeight(Integer modelWeight) {
		this.modelWeight = modelWeight;
	}
	public String getModelSize() {
		return modelSize;
	}
	public void setModelSize(String modelSize) {
		this.modelSize = modelSize;
	}
	public Integer getModelShoesSize() {
		return modelShoesSize;
	}
	public void setModelShoesSize(Integer modelShoesSize) {
		this.modelShoesSize = modelShoesSize;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getBuyLink() {
		return buyLink;
	}
	public void setBuyLink(String buyLink) {
		this.buyLink = buyLink;
	}
	public Integer getInfoPrice() {
		return infoPrice;
	}
	public void setInfoPrice(Integer infoPrice) {
		this.infoPrice = infoPrice;
	}
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	public String getInfoseq() {
		return infoseq;
	}
	public void setInfoseq(String infoseq) {
		this.infoseq = infoseq;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBcSeq() {
		return bcSeq;
	}
	public void setBcSeq(String bcSeq) {
		this.bcSeq = bcSeq;
	}
	public String getBetterBlog_seq() {
		return betterBlog_seq;
	}
	public void setBetterBlog_seq(String betterBlog_seq) {
		this.betterBlog_seq = betterBlog_seq;
	}
	
	
}
