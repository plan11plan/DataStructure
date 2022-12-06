package com.webp.p7;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @Entity 어노테이션은 JPA를 사용해 테이블과 매핑할 클래스에 붙여주는 어노테이션이다.
 * 이 어노테이션을 붙임으로써 JPA가 해당 클래스를 관리하게 된다.
 *
 * @Id는 특정 속성을 기본키로 설정하는 어노테이션이다.
 *
 * @CreationTimestamp
 *  * Hibernate에서는 엔티티 객체에 대해 INSERT, UPDATE 등의 쿼리가 발생할 때,
 *  * 현재 시간을 자동으로 저장해주는 @CreationTimestamp(INSERT)와 @UpdateTimestamp(UPDATE) 어노테이션을 제공한다.
 *
 */
@Entity
public class Member {
	
@Id
public String id;

public String pw;
public String name;
public String phone;
public Integer balance; 
@CreationTimestamp
public LocalDateTime rdate;
} // class
