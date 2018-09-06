package com.bufs.testboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bufs.testboard.domain.Board;
import com.bufs.testboard.persistence.BoardRepositoryImpl;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepositoryImpl repository;
	
			@Override
			public void insertBoard(Board board) {
			repository.insertBoard(board);
			}

			//게시글 삭제
			@Override
			public void deleteBoard(int num) {
				
				repository.deleteBoard(num);
				
			}
			
			//게시글 수정
			@Override
			public void updateBoard(Board board) {
				
				repository.updateBoard(board);
				
			}
			
			//게시글 전체 조회
			@Override
			public List<Board> getBoards(){
				
				return repository.getBoards();
			}
			@Override
			public Board getBoardOne(int num) {
				
				return repository.getBoardOne(num);
				
			}

			@Override
			public int getBoardCount() {
			
				return repository.getBoardCount();
			}
			
			
		
	

	
}
