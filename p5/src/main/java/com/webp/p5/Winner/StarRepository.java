package com.webp.p5.Winner;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



public interface StarRepository extends JpaRepository<Star, Integer>{
   @Transactional
   @Modifying
   @Query("update Star s set s.COUNT_SEMI=s.COUNT_SEMI+1 where name=?1")
   int updateCount_SEMI(String name);
   
   @Transactional
   @Modifying
   @Query("update Star s set s.COUNT_FINAL=s.COUNT_FINAL+1 where name=?1")
   int updateCount_FINAL(String name);
   
   @Transactional
   @Modifying
   @Query("update Star s set s.COUNT_SEMI=0, s.COUNT_FINAL=0")
   int resetCount();
}