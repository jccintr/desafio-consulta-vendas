package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SalesReportDTO>> getReport(@RequestParam(defaultValue = "") String minDate,
			@RequestParam(defaultValue = "") String maxDate, @RequestParam(defaultValue = "") String name,
			Pageable pageable) {

		Page<SalesReportDTO> sales = service.report(minDate, maxDate, name, pageable);

		return ResponseEntity.ok().body(sales);

	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SalesSummaryDTO>> getSummary(@RequestParam(defaultValue = "") String minDate,
			@RequestParam(defaultValue = "") String maxDate, Pageable pageable) {

		Page<SalesSummaryDTO> sales = service.summary(minDate, maxDate, pageable);

		return ResponseEntity.ok().body(sales);
	}
}
