package com.hankyung.persistence.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.hankyung.domain.board.BoardDTO;
import com.hankyung.persistence.lecture.LectureDAOImpl;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardDAOImpl  implements BoardDAO{
	
	@Inject
	private SqlSession session;
	
	@Override
	public List<BoardDTO> list(int btype) {
		return session.selectList("board.list", btype);
	}

	@Override
	public int create(BoardDTO bDto) {
		return session.insert("board.create", bDto);
	}

	@Override
	public BoardDTO read(BoardDTO bDto) {
		return session.selectOne("board.read", bDto);
	}

	@Override
	public void increaseViewCnt(BoardDTO bDto) {
		session.update("board.increaseViewCnt", bDto);
	}

	@Override
	public int delete(BoardDTO bDto) {
		return session.delete("board.delete",bDto);
	}

	@Override
	public int update(BoardDTO bDto) {
		return session.update("board.update",bDto);
	}
	


}
