package org.hj.controller;

import javax.servlet.http.HttpSession;

import org.hj.domain.BoardVO;
import org.hj.domain.Criteria;
import org.hj.domain.PageDTO;
import org.hj.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public void boardlist(Criteria cri, Model model) {
		// 콘솔에 남기기
		log.info("게시판 리스트 목록 보기 화면으로 이동");
		
		model.addAttribute("list",service.getlistWithPaging(cri));
		int total = service.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri,total));

	}
	// 목록 리스트에서 제목을 클릭하여 상세내용 화면으로 이동
	@GetMapping("/get")
	public void get(@RequestParam("bno") int bno, Model model) {
		
		log.info(bno);
		model.addAttribute("board", service.get(bno));
	}
	// 수정 버튼을 클릭하면 수정할 수 있는 화면으로 이동
	@GetMapping("/modify")
	public void modify(@RequestParam("bno") int bno, Model model) {
		
		model.addAttribute("board", service.get(bno));
	}
	
	// 게시판번호, 수정된 제목, 수정된 내용으로 update하기 위한 controller
	@PostMapping("/modify")
	public String modifypost(BoardVO board, RedirectAttributes rttr) {
		service.modify(board);
		// update한 뒤, 상세페이지(get.jsp)로 화면 이동
		
		// Flash를 사용하게되면 url에 bno를 숨겨서 넘김
		//rttr.addFlashAttribute("bno", board.getBno());
		
		// bno값을 받아야하기 때문
		rttr.addAttribute("bno", board.getBno());
		// 바로 get으로 리턴하게되면 db를 거치지않기 때문에 redirect를 사용해야함.
		return "redirect:/board/get";
		
	}
	
	// 삭제 버튼을 클릭
	@GetMapping("/remove")
	public String remove (@RequestParam("bno") int bno) {
		
		// delete
		service.remove(bno);
		
		// list.jsp로 화면 이동
		return "redirect:/board/list";
	}
	
	// 글쓰기 화면으로 이동
	@GetMapping("/write")
	public void write(HttpSession session) {
		session.setAttribute("writer", "현정정");
	}
	
	@PostMapping("/write")
	public String writepost(BoardVO board, HttpSession session) {
		String writer = (String)session.getAttribute("writer");
		board.setWriter(writer);
		log.info("board : " + board);
		service.register(board);
		return "redirect:/board/list";
	}
}
