package kr.co.farmstory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;


@Mapper
@Repository
public interface ArticleDAO {

	public int insertArticle(ArticleVO vo);
	public int insertFile(FileVO vo);
	public int selectCountTotal();		// 전체개시물 갯수 구하기
	public ArticleVO selectArticle(int no);
	public List<ArticleVO> selectArticles(int start);
	public FileVO selectFile(int fno); // 
	public int updateFileDownload(int fno); // 다운로드 횟수
	public int updateArticle(ArticleVO vo);
	public int deleteArticle(int no);
}
