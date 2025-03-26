package com.staticfinal.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	
	private String seq;
	private String cgName;
	private String codeGroup_seq;
	private String cdName;
	private int cdDelNy;
	private int cgDelNy;
	private String bseq;
	private String b_seq;
	private String b_cgName;
	private String b_cgDelNy;
	
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	
	
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	public int getCgDelNy() {
		return cgDelNy;
	}
	public void setCgDelNy(int cgDelNy) {
		this.cgDelNy = cgDelNy;
	}
	public String getB_seq() {
		return b_seq;
	}
	public void setB_seq(String b_seq) {
		this.b_seq = b_seq;
	}
	public String getB_cgName() {
		return b_cgName;
	}
	public void setB_cgName(String b_cgName) {
		this.b_cgName = b_cgName;
	}
	public String getB_cgDelNy() {
		return b_cgDelNy;
	}
	public void setB_cgDelNy(String b_cgDelNy) {
		this.b_cgDelNy = b_cgDelNy;
	}
	public String getBseq() {
		return bseq;
	}
	public void setBseq(String bseq) {
		this.bseq = bseq;
	}
	public String getCgName() {
		return cgName;
	}
	public void setCgName(String cgName) {
		this.cgName = cgName;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCodeGroup_seq() {
		return codeGroup_seq;
	}
	public void setCodeGroup_seq(String codeGroup_seq) {
		this.codeGroup_seq = codeGroup_seq;
	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public int getCdDelNy() {
		return cdDelNy;
	}
	public void setCdDelNy(int cdDelNy) {
		this.cdDelNy = cdDelNy;
	}
	
	
	

}
