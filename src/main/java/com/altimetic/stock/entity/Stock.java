package com.altimetic.stock.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Stock {

	@javax.persistence.Id
	@GeneratedValue
	private Long Id;

	@NotEmpty(message = "Please provide stock name")
	@Column(unique = true)
	private String stock;

	@NotEmpty(message = "Please provide company name")
	private String companyName;
	
	@NotNull(message = "Please provide date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
	private Date date;
	
	@NotNull(message = "Please provide price")
	private BigDecimal price;
	
	@NotEmpty(message = "Please provide currency")
	private String currency;

	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	public Stock(@NotEmpty(message = "Please provide stock name") String stock,
			@NotEmpty(message = "Please provide company name") String companyName,
			@NotNull(message = "Please provide date") Date date,
			@NotNull(message = "Please provide price") BigDecimal price,
			@NotEmpty(message = "Please provide currency") String currency) {
		super();
		this.stock = stock;
		this.companyName = companyName;
		this.date = date;
		this.price = price;
		this.currency = currency;
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Stock [Id=" + Id + ", stock=" + stock + ", companyName=" + companyName + ", date=" + date + ", price="
				+ price + ", currency=" + currency + "]";
	}
	
	
}
