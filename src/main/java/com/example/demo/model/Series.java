package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
public class Series extends Domain implements Serializable {
	@ManyToOne
	@JoinColumn(name = "brand_id", unique = true)
	@NotNull
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
