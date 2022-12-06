package com.webp.p7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
/* 이 부분에 리파지토리 추상메소드가 추가됩니다 */
	@Transactional 
	@Modifying 
	@Query("update Member set pw=?2, name=?3, phone=?4 where id=?1") 
	int updateMyinfo(String id, String pw, String name, String phone);
	
} // interface
