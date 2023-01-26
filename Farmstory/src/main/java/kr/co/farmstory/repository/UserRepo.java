package kr.co.farmstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.farmstory.entity.UserEntity;


public interface UserRepo extends JpaRepository<UserEntity, String> {

	// 아이디 중복체크
	public int countByUid(String uid);
	
}