package org.hj.controller;

import java.util.List;

import org.hj.domain.ReplyVO;
import org.hj.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;

	// 댓글쓰기 (inesrt)
	@PostMapping(value = "/new", 
			consumes = "application/json", 
			produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		
		log.info("vo = " + vo);
		service.register(vo);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	// 댓글 목록 리스트(select)
	@GetMapping(value="/pages/{bno}", produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") long bno){
		log.info("bno = " + bno);
		return new ResponseEntity<>(service.list(bno),HttpStatus.OK);
		
	}
	// 댓글수정(update)
	@PutMapping(value="/{rno}", consumes = "application/json")
	public ResponseEntity<String> update(@RequestBody ReplyVO vo) {
		
		log.info("vo = " + vo);
		service.modify(vo);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	// 댓글 삭제(remove)
	@DeleteMapping(value="/{rno}",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") long rno){
		
		log.info("rno=" + rno);
		service.delete(rno);
		
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
}
