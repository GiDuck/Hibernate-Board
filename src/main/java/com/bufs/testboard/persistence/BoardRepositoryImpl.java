package com.bufs.testboard.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bufs.testboard.domain.Board;

/**
 * persistence layer.
 * DB와 직접적으로 통신한다. 
 * 
 * */

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	@Autowired
	private SessionFactory factory;

	private Session session;
	private Transaction tx;

	
	/*	-------------------------------- 게시글 등록 --------------------------------*/
	
	@Override
	public void insertBoard(Board board) {

		//세션 팩토리에서 세션을 얻어온다 (Session Factory는 빈에서 주입받으며 Thread Safe함)
		session = factory.getCurrentSession();
		tx = session.getTransaction(); //트랜잭션 초기화
		try {

			//만약 현 세션의 트랜잭션이 진행중이지 않으면
			if (!tx.isActive())
				session.beginTransaction(); //트랜잭션을 시작한다.

			session.save(board); //save (저장, session에 1차 캐시됨)
			tx.commit(); //commit (커밋되면 DB에 반영됨)

		} catch (Exception e) { //Exception 발생 시 로그 기록 후에 롤백

			e.printStackTrace();
			tx.rollback();

		} finally {

			session.close(); //session close

		}

	}
	

	/*	-------------------------------- 게시글 삭제 --------------------------------*/
	
	@Override
	public void deleteBoard(int num) {

		session = factory.getCurrentSession();
		tx = session.getTransaction();
		try {

			if (!tx.isActive())
				session.beginTransaction();

			//HQL을 사용한 삭제 연산, :param 이런식으로 parameter값을 넣어줄 수 있음.
			int suToken = (int) session.createQuery("Delete From Board board where board.boardNum = :num")
					.setParameter("num", num).executeUpdate();

			//성공했으면 커밋 실패했으면 롤백
			if (suToken == 1)
				tx.commit();
			else
				tx.rollback();

		} catch (Exception e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			session.close();

		}
	}

	/*	-------------------------------- 게시글 수정 --------------------------------*/

	@Override
	public void updateBoard(Board board) {

		session = factory.getCurrentSession();
		tx = session.getTransaction();
		try {

			if (!tx.isActive())
				session.beginTransaction();

			session.update(board); //수정 연산, 우선 캐시된 session에 있는 엔터티와 비교해서 달라진 부분이 있으면 자동으로 DB에 반영된다.
			tx.commit(); //이후 커밋

		} catch (Exception e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			session.close();

		}

	}

	
	/*	-------------------------------- 게시글 전체 조회 --------------------------------*/
	
	
	@Override
	public List<Board> getBoards(int pageNum) {

		int prefix = (10 * (pageNum - 1)); //게시글 시작 번호

		session = factory.getCurrentSession();
		tx = session.getTransaction();
		try {

			if (!tx.isActive())
				session.beginTransaction();

			//HQL을 통한 select query.
			//페이징 처리는 setFirstResult에 시작 위치를 지정하고, setMaxResults에 출력할 게시글의 수를 지정한다.
			//만약 1부터 10까지 뽑으려면 setFirstResult(1), setMaxResults(10)으로 지정한다.
			//마지막에 list형태로 출력
			List<Board> boards = session.createQuery("Select b From Board b order by b.boardNum DESC")
					.setFirstResult(prefix).setMaxResults(10).list();
			tx.commit();
			return boards;
		} catch (Exception e) {

			//예외 발생시 롤백시키고 null값 리턴
			e.printStackTrace();
			tx.rollback();
			return null;
			
		} finally {
			session.close();
		}

	}

/*	-------------------------------- 게시글 상세보기 --------------------------------*/
	
	@Override
	public Board getBoardOne(int num) {

		session = factory.getCurrentSession();
		tx = session.getTransaction();

		try {

			if (!tx.isActive())
				session.beginTransaction();

			//HQL을 통한 select query. 넘어온 리스트중에 제일 첫번째 요소를 반환함.
			Board board = (Board) session.createQuery("Select board from Board board where board.boardNum = :num")
					.setParameter("num", num).list().get(0);
			
			tx.commit();
			return board;

		} catch (Exception e) {

			e.printStackTrace();
			tx.rollback();
			return null;

		} finally {

			session.close();

		}

	}

	
	/*	-------------------------------- 페이징 처리를 위한 게시글 총 개수 가져오기 --------------------------------*/
	
	@Override
	public int getBoardCount() {

		session = factory.getCurrentSession();
		tx = session.getTransaction();

		try {
			if (!tx.isActive())
				session.beginTransaction();

			//HQL을 통해 그룹함수를 사용할 수 있다. 단, 연산은 엔터티를 기준으로 실행해야 함.
			Long count = (Long) session.createQuery("Select count(board) From Board board").getSingleResult();
			tx.commit();

			//정수로 변환하여 반환한다.
			return Integer.valueOf(String.valueOf(count)); 

		} catch (Exception e) {

			e.printStackTrace();
			tx.rollback();
			return 0;

		} finally {

			session.close();

		}
	}

}
