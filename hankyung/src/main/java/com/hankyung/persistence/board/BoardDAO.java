package com.hankyung.persistence.board;

import java.util.List;

import com.hankyung.domain.board.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> list(int btype);
}
