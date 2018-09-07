package com.bufs.testboard.persistence;

import java.util.List;

import com.bufs.testboard.domain.Board;


/*
 * 유연하고 안정적인 관리를 위한 인터페이스 
*/

public interface BoardRepository {

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int num);

	// 게시글 수정
	public void updateBoard(Board board);

	// 게시글 전체 조회
	public List<Board> getBoards(int pageNum);

	// 게시글 상세보기
	public Board getBoardOne(int num);
	
	// 게시글 총 개수
	public int getBoardCount();


}
