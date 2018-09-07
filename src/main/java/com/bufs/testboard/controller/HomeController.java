package com.bufs.testboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Home Controller는 메인화면을 지정하는 front controller이다.
 * 현재 메인은 게시판 리스트이므로, 해당 뷰를 제공하는 board controller로 리 다이렉트 한다. 
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(RedirectAttributes redirect) {
		
		//RedirectAttribute를 사용하면 리다이렉트시에 인자값을 전달할 수 있다.
		
		redirect.addAttribute("pageNum", "1");		

		return "redirect:/board/getBoardMain";
	}
	
}
