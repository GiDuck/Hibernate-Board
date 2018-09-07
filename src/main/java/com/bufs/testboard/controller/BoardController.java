package com.bufs.testboard.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bufs.testboard.domain.Board;
import com.bufs.testboard.service.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	//Autowired 어노테이션을 통해 자료형을 중심으로 서비스 객체를 주입받는다.
	@Autowired
	private BoardServiceImpl service;
	
	
	/*게시글 리스트 화면*/
	@RequestMapping(value="/getBoardMain", method=RequestMethod.GET)
	public String getBoardMain(@RequestParam("pageNum") int pageNum, Model model) {
		
		//int pageNum = Integer.valueOf(String.valueOf(Long.valueOf(pageNumStr)));

		//만약 들어온 페이지 번호가 0이하이면 1로 초기화 시켜준다. (예외처리)
		if(pageNum<1) {	
			pageNum = 1;
	}
		
		//Model 객체에 게시글 목록(1번부터 10개), 총 게시글 수(페이징 처리 위함), 현재 게시글 번호를 리턴한다.
		model.addAttribute("boards",service.getBoards(pageNum));
		model.addAttribute("boardCount", service.getBoardCount());
		model.addAttribute("pageNum",pageNum);
		
		
		return "home";
		
	}

	/*게시글 작성 화면*/
	@RequestMapping("/getBoardWritingView")
	public String getBoardWritingView(Model model) {

		return "writing";
	}

	/* 게시글 작성 Action */
	@RequestMapping(value = "/actionBoardWriting", method = RequestMethod.POST)
	public String actionBoardWriting(@ModelAttribute Board board) {

		System.out.println(board.toString());
		board.setBoardDate(new Date());
		service.insertBoard(board);

		return "redirect:/";
	}

	/* 게시글 상세 보기 화면 */
	@RequestMapping("/getBoardDetailView")
	public String getBoardDetailView(@RequestParam("num") int num, Model model) {
		
		model.addAttribute("board", service.getBoardOne(num));
		
		return "detail";
	}
	
	/* 게시글 수정 View */
	@RequestMapping("/getBoardModifyView")
	public String getBoardModifyView(@RequestParam("num") int num, Model model) {

		model.addAttribute("board", service.getBoardOne(num));

		return "modify";
	}
	
	/* 게시글 수정 Action */
	@RequestMapping(value="/actionBoardModify", method=RequestMethod.POST)
	public String actionBoardModify(@ModelAttribute Board board, Model model) {

		//ModelAttribute를 통해 커맨드 객체를 바인드 한다. 엔터티객체는 도메인 객체처럼 form으로 전송된 값을 바인드 할 수 있다.
		service.updateBoard(board);

		//완료 후 front controller로 리다이렉트
		return "redirect:/";
	}

	//Delete Action
	//Delete는 Ajax를 통해 요청한다. 그러므로 ResponseBody를 통해 성공/실패시 값을 각각 다르게 하여  리턴시켜준다.
	@ResponseBody
	@RequestMapping(value = "/actionBoardDelete", method = RequestMethod.GET)
	public String actionBoardDelete(@RequestParam int num) {

		try {
			service.deleteBoard(num);
			return "success";
			
		} catch (Exception e) {
			return "fail";
		}

	}

}
