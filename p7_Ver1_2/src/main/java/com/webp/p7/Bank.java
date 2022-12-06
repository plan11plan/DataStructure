package com.webp.p7;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;


/**
 * @Entity
 * 어노테이션은 JPA를 사용해 테이블과 매핑할 클래스에 붙여주는 어노테이션이다.
 * 이 어노테이션을 붙임으로써 JPA가 해당 클래스를 관리하게 된다.
 *
 * @Id는
 * 특정 속성을 기본키로 설정하는 어노테이션이다.
 *
 * @CreationTimestamp
 * Hibernate에서는 엔티티 객체에 대해 INSERT, UPDATE 등의 쿼리가 발생할 때,
 * 현재 시간을 자동으로 저장해주는 @CreationTimestamp(INSERT)와 @UpdateTimestamp(UPDATE) 어노테이션을 제공한다.
 *
 * @GeneratedValue(strategy = GenerationType.IDENTITY) - IDENTITY
 * 기본키 생성을 데이터베이스에게 위임하는 방식으로 id값을 따로 할당하지 않아도
 * 데이터베이스가 자동으로 AUTO_INCREMENT를 하여 기본키를 생성해준다.
 * (기본키를 자동으로 생성할 때에는 @Id와 @GenerratedValue 어노테이션이 함께 사용되어야 한다.)
 *
 */
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer no;
    public String id;
    @CreationTimestamp
    public LocalDateTime tdate;
    public Integer de;
    public Integer wi;
    public Byte tcode;
    public String tid;
}
