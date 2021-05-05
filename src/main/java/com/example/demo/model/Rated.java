package com.example.demo.model;

public class Rated {
	private Domain domain;
	private double rated;

	public Rated(Domain domain, double rated) {
		super();
		this.domain = domain;
		this.rated = rated;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public double getRated() {
		return rated;
	}
	public void setRated(double rated) {
		this.rated = rated;
	}
}
