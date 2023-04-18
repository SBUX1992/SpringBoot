package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ch09.service.User2Service;
import kr.co.ch09.vo.User2VO;

@Controller
public class User2Controller {
	
	@Autowired
	private User2Service service;

	// vue user project user2list 불러옴
	@ResponseBody
	@CrossOrigin(origins = "*")
	@GetMapping("/user2s")
	public List<User2VO> list() {		
		List<User2VO> users = service.selectUser2s();
		
		/*
		//builder 패턴 초기화
		User2VO user2 = User2VO.builder()
						.uid("a101")
						.name("홍길동")
						.hp("010-1234-1001")
						.age(17)
						.build();
		*/		
		return users;
	}
	
	@ResponseBody
	@GetMapping("/user2")
	public User2VO user2(String uid) {
		return service.selectUser2(uid);
	}
	
	@ResponseBody
	@GetMapping("/user2/{uid}")
	public User2VO list(@PathVariable("uid") String uid) {
		return service.selectUser2(uid);
	}
	
	// vue user project user2register 등록
	@ResponseBody
	@CrossOrigin(origins = "*")
	@PostMapping("/user2")
	public List<User2VO> register(@RequestBody User2VO vo) {
		service.insertUser2(vo);
		return service.selectUser2s();
	}
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@PutMapping("/user2")
	public List<User2VO> modify(@RequestBody User2VO vo) {		
		service.updateUser2(vo);
		return service.selectUser2s();
	}
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@DeleteMapping("/user2/{uid}")
	public List<User2VO> delete(@PathVariable("uid") String uid) {
		service.deleteUser2(uid);
		return service.selectUser2s();
	}
	
	
}