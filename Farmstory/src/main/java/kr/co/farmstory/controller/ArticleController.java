package kr.co.farmstory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService service;
	
	@GetMapping("board/list")
	public String list(Model model, String pg) {
		
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		
		int total = service.selectCountTotal();
		int lastPageNum = service.getLastPageNum(total);
		int pageStartNum = service.getPageStartNum(total, start);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ArticleVO> articles = service.selectArticles(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("groups", groups);
		
		return "board/list";
	}
	
	@GetMapping("board/modify")
	public String modify() {
		return "board/modify";
	}
	
	@GetMapping("board/view")
	public String view(int no, Model model) {
		ArticleVO article = service.selectArticle(no);
		model.addAttribute("article", article);
		return "board/view";
	}
	
	// 파일 다운로드
	@GetMapping("download")
	public ResponseEntity<Resource> download(int fno) throws IOException {
		// 파일 조회
		FileVO vo = service.selectFile(fno);
		
		// 파일 다운로드 카운터 증가
		service.updateFileDownload(fno);
		
		// 파일 다운로드
		ResponseEntity<Resource> respEntity = service.fileDownload(vo);
		
		return respEntity;
	}
	
	@GetMapping("board/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("board/write")
	public String write(ArticleVO vo, HttpServletRequest req) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		service.insertArticle(vo);
		return "redirect:/board/list";
	}
	
}
