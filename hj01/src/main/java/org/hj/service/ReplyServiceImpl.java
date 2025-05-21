package org.hj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.hj.domain.ReplyVO;
import java.util.List;
import org.hj.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	// 글쓰기를 위한 비즈니스 영역
	@Override
	public void register(ReplyVO vo) {
		mapper.insert(vo);
	}
	
	// 댓글 목록 리스트를 위한 비즈니스 영역
		public List<ReplyVO> list(long bno) {
			return mapper.list(bno);
		}
		// 댓글 수정을 위한 비즈니스 영역
		public void modify(ReplyVO vo) {
			mapper.update(vo);
		}
		// 댓글 삭제를 위한 비즈니스 영역
		public void delete(long rno) {
			mapper.delete(rno);
		};

		

	
}
