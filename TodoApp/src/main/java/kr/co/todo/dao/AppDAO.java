package kr.co.todo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.todo.vo.TodoVO;

@Mapper
@Repository
public interface AppDAO {

	// SQL 데이터 등록하기
	public void insertTodo(TodoVO vo);

	public TodoVO selectTodo(int no);
	
	// SQL 데이터 불러오기
	public List<TodoVO> selectTodos();

	public void updateTodo(TodoVO vo);
	
	// 개별삭제
	public void deleteTodo(int no);
	
	// 전체삭제
	public void deleteTodoAll();
}