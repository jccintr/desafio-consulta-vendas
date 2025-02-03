package com.devsuperior.dsmeta.repositories;



import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	/*
	@Query(value = "SELECT obj FROM Employee obj JOIN FETCH obj.department",
			countQuery = "SELECT COUNT(obj) FROM Employee obj JOIN obj.department")
	Page<SaleMinDTO> report2(Pageable pageable);
	*/
	
	@Query("SELECT new com.devsuperior.dsmeta.dto.SalesReportDTO(s.id,s.date,s.amount,s.seller.name as sellerName) "
			+ "FROM Sale s "
			+ "WHERE s.date BETWEEN :minDate and :maxDate "
			+ "AND "
			+ "UPPER(s.seller.name) LIKE UPPER(CONCAT('%',:name,'%'))")
	Page<SalesReportDTO> report(LocalDate minDate,LocalDate maxDate,String name,Pageable pageable);
	
	/*
	@Query("SELECT new com.devsuperior.dsmeta.dto.SalesReportDTO(s.id,s.date,s.amount,s.seller.name as sellerName) "
			+ "FROM Sale s "
			+ "WHERE s.date BETWEEN :minDate and :maxDate")
	List<SalesReportDTO> report2(LocalDate minDate,LocalDate maxDate,String name);
	*/
}

/*
 
 RELATORIO DE VENDAS 
 
select tb_sales.id,tb_sales.dt_sale,tb_sales.amount,tb_seller.name from tb_sales
inner join tb_seller
on tb_seller.id = tb_sales.seller_id
where  UPPER(tb_seller.name) LIKE UPPER('%odinson%')
and
tb_sales.dt_sale between '2022-05-01' and '2022-05-31'

*/

/*
 Sumário de vendas por vendedor 
 
 SELECT tb_seller.name, SUM(tb_sales.amount) from tb_seller
inner join tb_sales
on tb_seller.id = tb_sales.seller_id
where tb_sales.dt_sale between '2022-01-01' and '2022-06-30'
group by tb_seller.name
*/