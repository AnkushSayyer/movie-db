package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank(message = "Title is mandatory")
	@Column(unique = true)
	private String title;

	@OneToOne
	@JoinColumn(name="rating_id", unique = true)
	private Rating rating;

	@Enumerated(EnumType.STRING)
	private DomainType type;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public DomainType getType() {
		return type;
	}
	public void setType(DomainType type) {
		this.type = type;
	}
}
