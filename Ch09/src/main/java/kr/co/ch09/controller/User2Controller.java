package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ch09.service.User2Service;
import kr.co.ch09.vo.User2VO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class User2Controller {
	
	@Autowired
	private User2Service service;

	@GetMapping("/user2/list")
	public List<User2VO> list() {		
		return service.selectUser2s();
	}
	
	@PostMapping("/user2/register")
	public List<User2VO> register(@RequestBody User2VO vo) {
		log.info("vo : " + vo);		
		service.insertUser2(vo);
		return service.selectUser2s();
	}
	
	@GetMapping("/user2/modify")
	public User2VO modify(String uid) {
		return service.selectUser2(uid);
	}
	
	@PostMapping("/user2/modify")
	public List<User2VO> modify(@RequestBody User2VO vo) {		
		service.updateUser2(vo);
		return service.selectUser2s();
	}
	
	@GetMapping("/user2/delete")
	public List<User2VO> delete(String uid) {
		service.deleteUser2(uid);
		return service.selectUser2s();
	}
	
	
}