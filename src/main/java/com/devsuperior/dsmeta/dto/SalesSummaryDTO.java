package com.devsuperior.dsmeta.dto;

public class SalesSummaryDTO {
	
	private String sellerName;
	private Double total;
	
	public SalesSummaryDTO(String sellerName, Double total) {
		super();
		this.sellerName = sellerName;
		this.total = total;
	}

	public String getSellerName() {
		return sellerName;
	}

	public Double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "SalesSummaryDTO [sellerName=" + sellerName + ", total=" + total + "]";
	}
	
	
	
	
	

}
