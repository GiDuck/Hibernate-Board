package com.bufs.testboard.service;

import java.util.List;

import com.bufs.testboard.domain.Board;

public interface BoardService {

	public void insertBoard(Board board);

	//게시글 삭제
	public void deleteBoard(int num);
	//게시글 수정
	public void updateBoard(Board board);
	
	//게시글 전체 조회
	public List<Board> getBoards();
	
	public Board getBoardOne(int num);
	
	public int getBoardCount();
	
	
	
}
