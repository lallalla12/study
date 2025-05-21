package org.hj.service;

import java.util.List;

import org.hj.domain.BoardVO;
import org.hj.domain.Criteria;
import org.hj.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public BoardVO get(int bno) {
		// 조회수를 1씩 증가하기 위한 DataBase작업
		mapper.CountUpdate(bno);
		// 제목을 클릭하면 상세내용을 select하기 위한 DataBase 작업
		return mapper.read(bno);
	}
	public void modify(BoardVO board) {
		mapper.update(board);
	}
	public void remove(int bno) {
		mapper.delete(bno);
	}
	public void register(BoardVO board) {
		mapper.insert(board);
	}
	@Override
	public List<BoardVO> getlistWithPaging(Criteria cri) {
		return mapper.getlistWithPaging(cri);
	}
	
	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}
	
	
	
}
