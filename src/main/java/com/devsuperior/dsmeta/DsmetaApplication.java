package com.devsuperior.dsmeta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner {

	@Autowired
	SaleRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		List<SaleMinDTO> sales = repository.report();
		for(SaleMinDTO s: sales) {
			System.out.println(s);
		}*/
		
		/*
		List<SalesReportDTO> sales = repository.report2();
		
		for(SalesReportDTO s: sales) {
			System.out.println(s);
		}
		*/
	}
}
