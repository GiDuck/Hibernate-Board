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

	@Autowired
	private BoardServiceImpl service;

	@RequestMapping("/getBoardWritingView")
	public String getBoardWritingView(Model model) {

		return "writing";
	}

	@RequestMapping(value = "/actionBoardWriting", method = RequestMethod.POST)
	public String actionBoardWriting(@ModelAttribute Board board) {

		System.out.println(board.toString());
		board.setBoardDate(new Date());
		service.insertBoard(board);

		return "redirect:/";
	}

	@RequestMapping("/getBoardDetailView")
	public String getBoardDetailView(@RequestParam("num") int num, Model model) {

		model.addAttribute("board", service.getBoardOne(num));

		return "detail";
	}
	
	@RequestMapping("/getBoardModifyView")
	public String getBoardModifyView(@RequestParam("num") int num, Model model) {

		model.addAttribute("board", service.getBoardOne(num));

		return "modify";
	}
	
	
	@RequestMapping(value="/actionBoardModify", method=RequestMethod.POST)
	public String actionBoardModify(@ModelAttribute Board board, Model model) {

		logger.info("action modfiy... param : " + board.toString());
		
		service.updateBoard(board);

		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/actionBoardDelete", method = RequestMethod.GET)
	public String actionBoardDelete(@RequestParam int num) {

		
		System.out.println("들어온 num : " + num);
		try {
			service.deleteBoard(num);

			return "success";
			
		} catch (Exception e) {

			return "fail";

		}

	}

}
