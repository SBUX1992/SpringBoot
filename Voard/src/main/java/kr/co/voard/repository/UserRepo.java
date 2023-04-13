package kr.co.voard.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<UserEntity, String> {

	// 아이디 중복체크
	public int countByUid(String uid);
	
}