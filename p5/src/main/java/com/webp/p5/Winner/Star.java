package com.webp.p5.Winner;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Star {
   @Id public Integer no;
   public String name;
   public Integer COUNT_SEMI;
   public Integer COUNT_FINAL;
}