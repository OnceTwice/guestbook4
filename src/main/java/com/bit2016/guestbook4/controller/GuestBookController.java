package com.bit2016.guestbook4.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bit2016.guestbook4.dao.*;
import com.bit2016.guestbook4.vo.*;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookDao guestBookDao;
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String add(@ModelAttribute GuestBookVo vo) {
		guestBookDao.insert(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") int no, Model model) {
		model.addAttribute("no", no);
		
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestBookVo vo) {
		guestBookDao.delete(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("")
	public String list(Model model) {
		List<GuestBookVo> list = guestBookDao.getList();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
}
