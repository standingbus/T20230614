package com.yedam.board;

public class BoardVO {
	private String brdNo;
	private String brdTitle;
	private String brdWriter;
	private String brdContent;
	private String date;
	private int click_cnt;

	
	public BoardVO() {
		
	}

	public BoardVO(String brdNo, String brdTitle, String brdWriter, String brdContent, String date, int click_cnt) {
		super();
		this.brdNo = brdNo;
		this.brdTitle = brdTitle;
		this.brdWriter = brdWriter;
		this.brdContent = brdContent;
		this.date = date;
		this.click_cnt = click_cnt;
	}




	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}





	public int getClick_cnt() {
		return click_cnt;
	}





	public void setClick_cnt(int click_cnt) {
		this.click_cnt = click_cnt;
	}





	




	public String getBrdNo() {
		return brdNo;
	}


	public void setBrdNo(String brdNo) {
		this.brdNo = brdNo;
	}


	public String getBrdTitle() {
		return brdTitle;
	}


	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}


	public String getBrdWriter() {
		return brdWriter;
	}


	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}


	public String getBrdContent() {
		return brdContent;
	}


	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	@Override
	public String toString() {
		return "BoardVO [brdNo=" + brdNo + ", brdTitle=" + brdTitle + ", brdWriter=" + brdWriter + ", brdContent="
				+ brdContent + ", date=" + date + ", click_cnt=" + click_cnt + "]";
	}


	
	
	
	
	
}
