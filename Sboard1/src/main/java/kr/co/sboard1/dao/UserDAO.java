package kr.co.sboard1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.TermsVO;

@Mapper
@Repository
public interface UserDAO {
	
	public void insertUser();
	public TermsVO selectTerms();
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();
	

}
