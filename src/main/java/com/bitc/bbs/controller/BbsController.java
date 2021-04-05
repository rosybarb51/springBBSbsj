package com.bitc.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.bbs.dto.BbsDto;
import com.bitc.bbs.service.BbsService;

@Controller
public class BbsController {
	@Autowired
	private BbsService bbsService;
	
	
	@RequestMapping("/bbs/openListBbs.do")
	public ModelAndView openListBbs() throws Exception {
		ModelAndView mv = new ModelAndView("/bbs/listBbs");
		
		List<BbsDto> bbsList = bbsService.selectListBbs();
		mv.addObject("bbsList", bbsList);
		return mv;
	}
		
	@RequestMapping("/bbs/openDetailBbs.do")
	public ModelAndView openDetailBbs(@RequestParam int num) throws Exception {
		ModelAndView mv = new ModelAndView("bbs/detailBbs");
		
		BbsDto bbs = bbsService.selectDetailBbs(num);
		mv.addObject("bbs", bbs);
		
		return mv;
	}
	
//	사용자 입력 양식 받는 부분
	@RequestMapping("/bbs/writeBbs.do")
	public String writeBbs() throws Exception {
		return "/bbs/writeBbs";
	}
	
	@RequestMapping("/bbs/insertBbs.do")
//	전체 다 가져와야함
	public String ginsertAddress(BbsDto bbs) throws Exception {
		bbsService.insertBbs(bbs);
		return "redirect:/bbs/openListBbs.do";
	}
	
	@RequestMapping("/bbs/editBbs.do")
	public ModelAndView edtiBbs(@RequestParam int num) throws Exception {
		ModelAndView mv = new ModelAndView("/bbs/editBbs");
		
		BbsDto bbs = bbsService.selectDetailBbs(num);
		mv.addObject("bbs", bbs);
		
		return mv;
	}
	
	@RequestMapping("/bbs/updateBbs.do")
	public String updateBbs(BbsDto bbs) throws Exception {
		bbsService.updateBbs(bbs);
		return "redirect:/bbs/openListBbs.do";
		
	}
	
	@RequestMapping("/bbs/removeBbs.do")
	public ModelAndView removeBbs(@RequestParam int num) throws Exception {
		ModelAndView mv = new ModelAndView("/bbs/removeBbs");
		
		BbsDto bbs = bbsService.selectDetailBbs(num);
		mv.addObject("bbs", bbs);
		
		return mv;
	}
	
	@RequestMapping("/bbs/deleteBbs.do")
	public String deleteBbs(@RequestParam int num) throws Exception {
		bbsService.deleteBbs(num);
		return "redirect:/bbs/openListBbs.do";
		
	}
	
	
}
