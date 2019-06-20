package com.hankyung.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.hankyung.domain.board.BoardDTO;
import com.hankyung.persistence.board.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO bDao;
	
	@Override
	public List<BoardDTO> list(int btype) {
		return bDao.list(btype);	
	}

	@Override
	public int create(BoardDTO bDto) {
		return bDao.create(bDto);
	}

	@Override
	public BoardDTO read(BoardDTO bDto) {
		return bDao.read(bDto);
	}

	@Override
	public void increaseViewCnt(BoardDTO bDto, HttpSession session) {
		long update_time=0;
		int bno = bDto.getBno();
		if(session.getAttribute("update_time_"+bno)!=null) {
			// 최근에 조회수를 올린 시간
			update_time = (long)session.getAttribute("update_time_"+bno);
		}
		long current_time = System.currentTimeMillis();
		
		// 일정 시간이 경과한 후 조회수 증가 처리
		if(current_time - update_time > 24*60*60*1000) {
			// 조회수 증가 처리
			bDao.increaseViewCnt(bDto);
			
			// 조회수를 올린 시간 저장
			session.setAttribute("update_time_"+bno, current_time);
		    log.info("update_time_"+update_time+"current_time_"+current_time);
		}
		
	}

	@Override
	public int delete(BoardDTO bDto) {
		return bDao.delete(bDto);
	}
	
}
