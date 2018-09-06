package com.bufs.testboard.persistence;

import java.util.List;

import com.bufs.testboard.domain.Board;

public interface BoardRepository {

	// 게시글 등록

	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int num);

	// 게시글 수정
	public void updateBoard(Board board);

	// 게시글 전체 조회

	public List<Board> getBoards();

	// 게시글 상세보기
	public Board getBoardOne(int num);
	
	public int getBoardCount();


}
