package com.hankyung.controller.lecture;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hankyung.domain.lecture.LectureDTO;
import com.hankyung.service.lecture.LectureService;
import com.hankyung.service.lecture.Pager;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("lecture/*")
public class LectureController {
	
	private static final Logger logger = LoggerFactory.getLogger(LectureController.class);
	
	@Inject
	private LectureService service;
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(HttpSession session, Model model) {
		logger.info("강좌바구니 출력");
		
		List<LectureDTO> list = service.cartlist(session);
		
		model.addAttribute("cartList", list);
		return "lecture/cart";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(Model model,
			@RequestParam(defaultValue="new") String sort_option,
			@RequestParam(defaultValue="all") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage
			) {
		log.info(">>>>> 과정 및 강좌 목록 페이지 출력");
		
		// 레코드 갯수 계산
		int count = service.countArticle(search_option,keyword);
		
		//페이지 관련 설정
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
				
		List<LectureDTO> list = service.lectureList(sort_option, search_option, keyword, start, end);
		
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		map.put("sort_option", sort_option);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		mav.setViewName("lecture/lecture_list");
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping(value="view", method = RequestMethod.GET)
	public String lectureView(int lno, Model model) {
		log.info(">>>>> 과정 상세정보 페이지 출력");
		LectureDTO lDto = service.lectureView(lno);
		model.addAttribute("lDto", lDto);
		return "lecture/lecture_view";
	}
	
	
}
