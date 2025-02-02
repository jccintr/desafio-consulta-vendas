package com.devsuperior.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

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