package org.hj.service;

import java.util.List;

import org.hj.domain.BoardVO;

public interface BoardService {
	
	// 게시판 리스트 목록을 보기위한 메소드
	public List<BoardVO> list();
	// 목록 리스트에서 제목을 클릭하여 상세내용 화면으로 이동
	public BoardVO get(int bno);
}
