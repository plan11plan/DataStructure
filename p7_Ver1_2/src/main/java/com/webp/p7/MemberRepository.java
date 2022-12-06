package com.webp.p7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Repositroy
 *  * @Repositroy 어노테이션은 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다.
 *  * (@Repositroy, @Service 모두 Bean 객체를 생성해주고 딱히 다른 기능을 넣어주는게
 *  *  아니라서 뭘 써도 상관 없긴한데 명시적으로 구분해주기 위해 각자 분리해서 사용합니다.)
 *  *
 * @Query
 *  SQL과 유사한 JPQL (Java Persistence Query Language) 라는 객체지향 쿼리 언어를 통해 복잡한 쿼리 처리를 지원
 *  (JPQL - 테이블이 아닌 엔티티 객체를 대상으로 검색하는 객체지향 쿼리, SQL 추상화로 인해 특정 db sql 에 의존하지 않음)
 *  @Query는 JpaRepository 를 상속하는 인터페이스에서 사용한다.
 *만약 age가 20살 이상인 사람을 조회한다고 해보면 JPQL은 다음과 같이 사용될 것이다.
 * ("select u from User u where u.age >20"; )
 * 한편
 * Spring Data JPA에서는 기본적으로 JpaRepository를 통해서 제공되는 findById와 같은 메서드도 있고,
 * 메서드 네이밍만을 통해서 쿼리를 실행할 수 있도록 기능을 제공해주고 있습니다.
 * 하지만, 이 두가지 방법으로도 만들 수 없는 쿼리가 필요하다면, 쿼리를 직접 작성해야 합니다.
 * 그때 커스텀 Reopository의 메서드에 붙이는 annotation이 @Query입니다.
 *
 *
 * @Transactional
 *  * 어떤 연산에 트랜잭션이 보장된다면, DB에서 의도치 않은 값이 저장되거나 조회되는 것을 막을 수 있다.
 *  * @Transactional은 클래스나 메서드에 붙여줄 경우, 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
 *  * 선언적 트랜잭션이라고도 하는데, 직접 객체를 만들 필요 없이 선언만으로도 관리를 용이하게 해주기 때문.
 *  * 특히나 SpringBoot에서는 선언적 트랜잭션에 필요한 여러 설정이 이미 되어있는 탓에, 더 쉽게 사용할 수 있다.
 *  *
 *  * 클래스,메서드에 해당 어노테이션을 선언시, 해당 클래스는 트랜잭션 기능이 추가된 프록시 객체가 생성된다.
 *  * PlatformTransactionManager를 사용하여 트랜잭션을 시작하고 정상 여부에 따라 commit 혹은 rollback한다.
 *
 * @Modifying
 * 이 Annotation은 @Query Annotation으로 작성 된 변경, 삭제 쿼리 메서드를 사용할 때 필요합니다.
 * (즉, 데이터에 변경이 일어나는 INSERT, UPDATE, DELETE, DDL 에서 사용합니다)
 * 주로 벌크 연산 시에 사용됩니다.
 * 벌크 연산이란?
 * 벌크 연산이란 단건 UPDATE, DELETE를 제외한 다건의 UPDATE, DELETE 연산을 하나의 쿼리로 하는 것을 의미합니다.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {


	/* 이 부분에 리파지토리 추상메소드가 추가됩니다 */
	@Transactional 
	@Modifying 
	@Query("update Member set pw=?2, name=?3, phone=?4 where id=?1") 
	int updateMyinfo(String id, String pw, String name, String phone);

	@Modifying
	@Query("update Member set balance=balance+?2 where id=?1")
	int updateBalance(String id, int money);

	@Query("select count(id) from Member")
	int findCount(); /* 로그인화면에서 사용했던 총회원수 메소드 */
	@Query("select sum(balance) from Member")
	int findSum(); /* 총잔액 */
	@Query("select balance from Member where id=?1")
	int findBalance(String id);
} // interface
