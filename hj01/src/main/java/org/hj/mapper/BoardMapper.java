package org.hj.mapper;

import java.util.List;

import org.hj.domain.BoardVO;
import org.hj.domain.Criteria;

public interface BoardMapper {
	
	// 게시판 리스트 목록 메소드(페이징처리 안한거)
	public List<BoardVO> list();
	
	// 게시판 리스트 목록 메소드(페이징 한거)
	public List<BoardVO> getlistWithPaging(Criteria cri);
	
	// tbl_baord 테이블 전체 건수
	public int getTotalCount(Criteria cri);
	
	// 목록 리스트에서 제목을 클릭하여 상세내용 화면으로 이동
	public BoardVO read(int bno);
	// 게시판번호, 수정된 제목, 수정된 내용으로 update하기 위한 mapper
	public void update(BoardVO board);
	
	public void delete(int bno);
	
	public void insert(BoardVO board);
	
	// 목록 리스트에서 제목을 클릭하면 조회수를 1씩 증가
	public void CountUpdate(int bno);
}
