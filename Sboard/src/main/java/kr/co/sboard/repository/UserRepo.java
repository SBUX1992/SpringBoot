package kr.co.sboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.sboard.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String> {

	// 아이디 중복체크
	public int countByUid(String uid);
	
}