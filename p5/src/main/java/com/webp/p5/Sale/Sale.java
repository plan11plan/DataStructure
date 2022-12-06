package com.webp.p5.Sale;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
@Entity
public class Sale {
@Id public Integer buyid;
public String userid;
public String name;
public Integer count; 
public Integer price; 
@CreationTimestamp public LocalDateTime rdate;
} 
