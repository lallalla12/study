package org.hj.service;

import java.util.List;

import org.hj.domain.BoardVO;
import org.hj.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	//@AllArgsConstructor을 쓰지않으면 @Autowired를 쓰면됨
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> list() {
		return mapper.list();
	}
	public BoardVO get(int bno) {
		return mapper.read(bno);
	}
	
}
