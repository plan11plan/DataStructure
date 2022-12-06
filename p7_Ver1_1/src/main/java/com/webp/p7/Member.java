package com.webp.p7;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
