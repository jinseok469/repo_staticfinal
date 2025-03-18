package com.staticfinal.module.codegroup;

public class CodeGroupDto {
	private String seq;
	private String cgName;
	private int cgDelNy;
	private String seqCount;
	
	
	public String getSeqCount() {
		return seqCount;
	}
	public void setSeqCount(String seqCount) {
		this.seqCount = seqCount;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCgName() {
		return cgName;
	}
	public void setCgName(String cgName) {
		this.cgName = cgName;
	}
	public int getCgDelNy() {
		return cgDelNy;
	}
	public void setCgDelNy(int cgDelNy) {
		this.cgDelNy = cgDelNy;
	}
	
}
