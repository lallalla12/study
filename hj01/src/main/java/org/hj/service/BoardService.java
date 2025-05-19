package org.hj.service;

import java.util.List;
import org.hj.domain.BoardVO;
import org.hj.domain.Criteria;

public interface BoardService {
	
	// 게시판 리스트 목록 전체 조회 (페이징 없는)
	public List<BoardVO> list();
	
	// 페이징 처리된 게시판 목록 조회
	public List<BoardVO> getlistWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	// 상세 조회 (bno로 게시글 조회)
	public BoardVO get(int bno);

	// 수정
	public void modify(BoardVO board);
	
	// 삭제
	public void remove(int bno);

	// 글 등록
	public void register(BoardVO board);
}
