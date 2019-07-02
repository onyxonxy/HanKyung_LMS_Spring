package com.hankyung.controller.main;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hankyung.domain.member.MemberDTO;
import com.hankyung.service.board.BoardService;
import com.hankyung.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

// 한은체 
@Controller
@Slf4j
@RequestMapping("main/*")
public class MainController {
	
	@Inject
	private BoardService service;
	@Inject
	private MemberService mservice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		log.info(">>>test페이지");
		
		return "main/sample";
	}
	
	@RequestMapping(value = "/summernote", method = RequestMethod.GET)
	public String summernote(Model model) {
		log.info(">>> summernote 예제");

		return "main/summernote";
	}
	
	@RequestMapping(value = "/learning", method = RequestMethod.GET)
	public String learning() {
		log.info("학습방 페이지");

		return "main/learning";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert_teacher() {
		log.info("선생님 등록 페이지");

		return "main/insert_tch";
	}
	
	@RequestMapping(value = "/insert_lecture", method = RequestMethod.GET)
	public String insert_lecture() {
		log.info("강의 등록 페이지");

		return "main/insert_lecture";
	}
	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public String management(Model model) {
		log.info("학생관리시스템(학생관리)");

		return "main/management";
	}
	
	@RequestMapping(value = "/management_list", method = RequestMethod.GET)
	public String management_list(Model model) {
		log.info("학생관리시스템 리스트");
		String type = "2";
		List<MemberDTO> list = mservice.list(type);
		
		model.addAttribute("list", list);
		return "main/management_list";
	}
	
	
	
	
}
