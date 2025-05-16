package org.hj.mapper;

import java.util.List;

import org.hj.domain.BoardVO;

public interface BoardMapper {
	
	// 게시판 리스트 목록 메소드
	public List<BoardVO> list();
	// 목록 리스트에서 제목을 클릭하여 상세내용 화면으로 이동
	public BoardVO read(int bno);
	
}
