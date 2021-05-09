package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Material extends Domain implements Serializable {
	private String language;

	@ManyToOne
	@JoinColumn(name="director_id", nullable = false)
	private Director director;

	@ManyToOne
	@JoinColumn(name = "series_id")
	private Series series;

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
}
