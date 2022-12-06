package com.webp.p5.memo;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
@Entity
public class memo {
@Id public String title;
public String memo;
@CreationTimestamp public LocalDateTime wdate;
} // class
