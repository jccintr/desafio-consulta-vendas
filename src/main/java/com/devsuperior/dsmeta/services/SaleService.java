package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	
	public Page<SalesReportDTO> report(String minDate,String maxDate,String name,Pageable pageable) {
		
		LocalDate maxDt = maxDate.length()==0 ? LocalDate.ofInstant(Instant.now(),ZoneId.systemDefault() ) : LocalDate.parse(maxDate);
		LocalDate minDt = minDate.length()==0 ? maxDt.minusYears(1L) : LocalDate.parse(minDate);
		Page<SalesReportDTO> sales = repository.report(minDt,maxDt,name,pageable);
		return sales;
		
	}
	
	
	
	public Page<SalesSummaryDTO> summary(String minDate,String maxDate,Pageable pageable){
		
		LocalDate maxDt = maxDate.length()==0 ? LocalDate.ofInstant(Instant.now(),ZoneId.systemDefault() ) : LocalDate.parse(maxDate);
		LocalDate minDt = minDate.length()==0 ? maxDt.minusYears(1L) : LocalDate.parse(minDate);
		Page<SalesSummaryDTO> sales = repository.summary(minDt,maxDt,pageable);
		return sales;
	}
	
}
