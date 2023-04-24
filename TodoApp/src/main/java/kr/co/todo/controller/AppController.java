package kr.co.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.todo.service.AppService;
import kr.co.todo.vo.TodoVO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AppController {

	@Autowired
	private AppService service;
	
	// SQL 데이터 불러올때
	@GetMapping("todos")
	@CrossOrigin(origins = "*")
	public List<TodoVO> todos() {
		return service.selectTodos();
	}
	
	// SQL 데이터 등록
	@PostMapping("todo")
	@CrossOrigin(origins = "*")
	public TodoVO todo(@RequestBody TodoVO vo) {
		
		log.info("content : " + vo.getContent());		
		service.insertTodo(vo);
		
		// Todo 등록시 key 바로 부여하기 위해 return
		return vo;
	}
	
	// 개별삭제
	@DeleteMapping("remove")
	@CrossOrigin(origins = "*")
	public void remove(int no) {
		
		log.info("글번호 : " + no);
		
		service.deleteTodo(no);
	}
	
	// 전체 삭제
	@DeleteMapping("clear")
	@CrossOrigin(origins = "*")
	public void clear() {
		service.deleteTodoAll();
	}
	
}
