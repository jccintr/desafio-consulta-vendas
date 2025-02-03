package com.devsuperior.dsmeta.repositories;



import java.time.LocalDate;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	
	
	
	@Query("SELECT new com.devsuperior.dsmeta.dto.SalesReportDTO(s.id,s.date,s.amount,s.seller.name as sellerName) "
			+ "FROM Sale s "
			+ "WHERE s.date BETWEEN :minDate and :maxDate "
			+ "AND "
			+ "UPPER(s.seller.name) LIKE UPPER(CONCAT('%',:name,'%'))")
	Page<SalesReportDTO> report(LocalDate minDate,LocalDate maxDate,String name,Pageable pageable);
	/*
    @Query("SELECT new com.devsuperior.dsmeta.dto.SalesSummaryDTO(s.seller.name AS sellerName,sum(s.amount)) "
    		+ "FROM Sale s "
    		+ "GROUP BY s.seller.name")	
	List<SalesSummaryDTO> summary();
	*/
	
    @Query("SELECT new com.devsuperior.dsmeta.dto.SalesSummaryDTO(s.seller.name AS sellerName,sum(s.amount)) "
    		+ "FROM Sale s "
    		+ "WHERE s.date BETWEEN :minDate and :maxDate "
    		+ "GROUP BY s.seller.name")	
	Page<SalesSummaryDTO> summary(LocalDate minDate,LocalDate maxDate,Pageable pageable);
	
}



/*
 Sumário de vendas por vendedor 
 
 SELECT tb_seller.name, SUM(tb_sales.amount) from tb_seller
inner join tb_sales
on tb_seller.id = tb_sales.seller_id
where tb_sales.dt_sale between '2022-01-01' and '2022-06-30'
group by tb_seller.name
*/