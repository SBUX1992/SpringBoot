package kr.co.farmstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;

@Controller
public class BoardController {

	@Autowired
	private ArticleService service;
	
	
	@GetMapping("board/list")
    public String list(Model model, String group, String cate,  String pg){

        int currentPage = service.getCurrnetPage(pg);
        int start = service.getLimitStart(currentPage);
        int total = service.selectCountTotal(cate);
        int pageStartNum = service.getPageStartNum(total, start);
        int lastPageNum = service.getLastPageNum(total);

        // 페이지 그룹 start, end 번호
        int pageGroupStart = service.getPageGroup(currentPage, lastPageNum)[0];
        int pageGroupEnd = service.getPageGroup(currentPage, lastPageNum)[1];

        List<ArticleVO> articles = service.selectArticles(start, cate);

        if(pg == null){
            pg = "1";
        }
        model.addAttribute("pg", pg);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageGroupStart", pageGroupStart);
        model.addAttribute("pageGroupEnd", pageGroupEnd);
        model.addAttribute("articles", articles);

        model.addAttribute("group",group);
        model.addAttribute("cate",cate);

        return "board/list";
    }

	@GetMapping("board/modify")
    public String modify(Model model, int no, String group, String cate) {
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("article",article);
        model.addAttribute("group",group);
        model.addAttribute("cate",cate);
        model.addAttribute("no",no);
        return "board/modify";
    }
    @PostMapping("board/modify")
    public String modify(ArticleVO vo, String group, String no) {
        vo.setNo(Integer.valueOf(no));
        service.updateArticle(vo);

        return "redirect:/board/view?no="+no+"&group="+group+"&cate="+vo.getCate();
    }

    @GetMapping("board/view")
    public String view(Model model, int no, String group, String cate, String pg) {
        // 게시물 들고오기
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("article",article);
        model.addAttribute("group",group);
        model.addAttribute("cate",cate);
        model.addAttribute("no",no);
        if(pg == null){
            pg = "1";
        }
        model.addAttribute("pg",pg);
        // 게시물 조회수 +1
        service.updateArticleHit(no);
        // 댓글 가져오기
        List<ArticleVO> comments = service.selectComments(no);
        model.addAttribute("comments",comments);
        return "board/view";
    }

    @GetMapping("board/write")
    public String write(Model model,String group, String cate){
        model.addAttribute("group",group);
        model.addAttribute("cate",cate);

        return "board/write";
    }

    @PostMapping("board/write")
    public String write(ArticleVO vo, HttpServletRequest req,String group) {
        String regip = req.getRemoteAddr();
        vo.setRegip(regip);

        service.insertArticle(vo);
        return "redirect:/board/list?group="+group+"&cate="+vo.getCate();
    }
    
    
}
