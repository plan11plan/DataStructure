package com.webp.p5.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {
} // interface