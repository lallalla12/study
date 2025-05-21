package org.hj.mapper;

import java.util.List;
import org.hj.domain.ReplyVO;

public interface ReplyMapper {

	public void insert(ReplyVO vo);

	// 댓글 목록 리스트를 위한 비즈니스 영역
	public List<ReplyVO> list(long bno);

	// 댓글 수정을 위한 비즈니스 영역
	public void update(ReplyVO vo);
	
	// 댓글 삭제를 위한 비즈니스 영역
	public void delete(long rno);
}
