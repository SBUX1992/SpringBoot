package kr.co.sboard1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard1.dao.UserDAO;
import kr.co.sboard1.vo.TermsVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	
	public void insertUser() {}
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	public void selectUser() {}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}

}
