package com.bufs.testboard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="blogBoard")
public class Board {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer boardNum;
	
	@Column(name="boardTitle", nullable=false, length=300)
	private String boardTitle;
	
	@Column(name="boardWriter", nullable=false, length=100)
	private String boardWriter;
	
	@Column(name="boardEmail", length=300)
	private String boardEmail;
	
	@Column(name="boardContent", nullable=false, length=4000)
	private String boardContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="boardDate", nullable=false)
	@DateTimeFormat
	private Date boardDate;

	
	
	public Integer getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardEmail() {
		return boardEmail;
	}

	public void setBoardEmail(String boardEmail) {
		this.boardEmail = boardEmail;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardEmail=" + boardEmail + ", boardContent=" + boardContent + ", boardDate=" + boardDate + "]";
	}
	
	
	
	
	

}
