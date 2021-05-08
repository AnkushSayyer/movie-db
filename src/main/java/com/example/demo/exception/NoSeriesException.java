package com.example.demo.exception;

public class NoSeriesException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoSeriesException(String msg) {
		super(msg);
	}
}
