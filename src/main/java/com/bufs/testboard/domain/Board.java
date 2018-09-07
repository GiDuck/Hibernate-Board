package com.bufs.testboard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

//엔터티 객체, @Entity 어노테이션으로 지정 해 주어야 한다.
@Entity
@Table(name="blogBoard") //DB 테이블과 매핑될 이름 지정
public class Board {
	
	//식별값을 지정한다. 여기서는 시퀀스로 지정함.
	//SequenceGenerator로 시퀀스에 대한 상세 명세를 할 수 있다.
	//sequenceName에는 DB에 매핑될 시퀀스 이름, name에는 SequenceGenerator의 고유 이름을 지정한다.
	
	@Id
	@SequenceGenerator(name="BOARD_SEQ_GEN", sequenceName="BOARD_SEQ", allocationSize=1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOARD_SEQ_GEN")
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

	
	//엔터티 도메인 객체의 필드값을 지정한다. name은 DB에 매핑될 이름을 설정한다. length는 길이를 뜻하고, 제약조건등을 지정할 수 있다. 
	//이하 setter, getter
	
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
