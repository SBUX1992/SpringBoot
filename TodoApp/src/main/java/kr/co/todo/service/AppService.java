package kr.co.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todo.dao.AppDAO;
import kr.co.todo.vo.TodoVO;


@Service
public class AppService {

	@Autowired
	private AppDAO dao;
	
	// SQL 데이터 등록하기
	public void insertTodo(TodoVO vo) {
		dao.insertTodo(vo);
	}
	
	public TodoVO selectTodo(int no) {
		return dao.selectTodo(no);
	}
	
	// SQL데이터 불러오기
	public List<TodoVO> selectTodos(){
		return dao.selectTodos();				
	}
	public void updateTodo(TodoVO vo) {
		dao.updateTodo(vo);
	}
	
	// 개별삭제
	public void deleteTodo(int no) {
		dao.deleteTodo(no);
	}
	
	// 전체삭제
	public void deleteTodoAll() {
		dao.deleteTodoAll();
	}

}
