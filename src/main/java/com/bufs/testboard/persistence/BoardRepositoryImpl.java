package com.bufs.testboard.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bufs.testboard.domain.Board;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	@Autowired
	private SessionFactory factory;
	
	private Session session;
	
			

		//게시글 등록
		@Override
		public void insertBoard(Board board) {

			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(board);
			session.getTransaction().commit();
			session.close();
			
			
			
		}

		//게시글 삭제
		@Override
		public void deleteBoard(int num) {
		
			
			session = factory.getCurrentSession();
			session.getTransaction().begin();
			int suToken = (int)session.createQuery("Delete From Board board where board.boardNum = :num").setParameter("num", num).executeUpdate();
			
			if(suToken==1)
			session.getTransaction().commit();
			else
			session.getTransaction().rollback();
			
			session.close();
			
			
		}
		
		//게시글 수정
		@Override
		public void updateBoard(Board board) {
			
			session = factory.getCurrentSession();
			session.getTransaction().begin();
			session.update(board);
			session.getTransaction().commit();
			session.close();
			
			
		}
		
		//게시글 전체 조회
		@Override
		public List<Board> getBoards(){
	
			session = factory.openSession();
			session.beginTransaction();
			List<Board> boards = session.createQuery("Select b From Board b order by b.boardDate DESC").list();
			session.close();
			
			
			return boards;
		}
		
		
		//게시글 상세보기
		@Override
		public Board getBoardOne(int num) {
		session = factory.getCurrentSession();
			
			session.getTransaction().begin();	
			Board board = (Board)session.createQuery("Select board from Board board where board.boardNum = :num").setParameter("num", num).list().get(0);
			session.close();
			return board;
		
		}

		@Override
		public int getBoardCount() {
		
			session = factory.getCurrentSession();
			session.getTransaction().begin();
			Long count = (Long)session.createQuery("Select count(board) From Board board").getSingleResult(); 
			session.close();
			
			return Integer.valueOf(String.valueOf(count));
		}
		
		
		
		
	
	
}
