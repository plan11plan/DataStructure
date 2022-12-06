package com.webp.p7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repositroy
 *  * @Repositroy 어노테이션은 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다.
 *  * (@Repositroy, @Service 모두 Bean 객체를 생성해주고 딱히 다른 기능을 넣어주는게
 *  *  아니라서 뭘 써도 상관 없긴한데 명시적으로 구분해주기 위해 각자 분리해서 사용합니다.)
 *  *
 * @Query
 *  SQL과 유사한 JPQL (Java Persistence Query Language) 라는 객체지향 쿼리 언어를 통해 복잡한 쿼리 처리를 지원
 *  (JPQL - 테이블이 아닌 엔티티 객체를 대상으로 검색하는 객체지향 쿼리, SQL 추상화로 인해 특정 db sql 에 의존하지 않음)
 *
 *  @Query는 JpaRepository 를 상속하는 인터페이스에서 사용한다.
 *만약 age가 20살 이상인 사람을 조회한다고 해보면 JPQL은 다음과 같이 사용될 것이다.
 * ("select u from User u where u.age >20"; )
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    /* 이 부분에 리파지토리 추상메소드가 추가됩니다 */


    //나의 거래 내역 BankRepository 추상메소드
    @Query("select b from Bank b where id=?1 order by tdate desc")
    List<Bank> findByIdOrderByTdateDesc(String id); /* 최근일순 조회 */

    // 나의 잔액 조회 MemberRepository 추상메소드
    @Query("select balance from Member where id=?1")
    int findBalance(String id); /* 잔액 조회 */
    @Query("select b from Bank b order by id asc, tdate desc")
    List<Bank> findAllOrderByIdTdateDesc();


} // interface
