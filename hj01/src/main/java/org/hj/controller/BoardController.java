package org.hj.controller;

import org.hj.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	// 게시판 리스트 목록 보기 화면으로 이동
	
	@GetMapping("/list")
	public void boardlist(Model model) {
		// 콘솔에 남기기
		log.info("게시판 리스트 목록 보기 화면으로 이동");
		model.addAttribute("list",service.list());

	}
	// 목록 리스트에서 제목을 클릭하여 상세내용 화면으로 이동
	@GetMapping("/get")
	public void get(@RequestParam("bno") int bno, Model model) {
		
		log.info(bno);
		service.get(bno);
	}
}
