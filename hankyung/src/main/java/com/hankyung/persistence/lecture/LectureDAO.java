package com.hankyung.persistence.lecture;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hankyung.domain.lecture.LectureDTO;

public interface LectureDAO {
	public List<LectureDTO> cartlist(String id);
	public List<LectureDTO> popularList();
	public List<LectureDTO> newList();
	public int countArticle(String search_option, String keyword);
	public List<LectureDTO> lectureList(String sort_option, String search_option, String keyword, int start, int end);
	public LectureDTO lectureView(int lno);
	public int price(String id);
	public int wishCheck(int lno, String id);
	public void wishDelete(int lno, String id);
	public void wishInsert(int lno, String id);
	public int wishTotal(int lno, String id);
}
