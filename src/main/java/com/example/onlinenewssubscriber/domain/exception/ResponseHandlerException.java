package com.example.onlinenewssubscriber.domain.exception;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class ResponseHandlerException {

	@ExceptionHandler(Exception.class)
	public void handleException(Exception ex, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		httpServletResponse.setHeader("Client-Code", HttpStatus.INTERNAL_SERVER_ERROR.name());
		httpServletResponse.setHeader("Client-Message", ex.getMessage());
		httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

	}

	@ExceptionHandler(IllegalArgumentException.class)
	public void handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		httpServletResponse.setHeader("Client-Code", HttpStatus.BAD_REQUEST.name());
		httpServletResponse.setHeader("Client-Message", ex.getMessage());
		httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());

	}

	@ExceptionHandler(NoSuchElementException.class)
	public void handleNoSuchElementException(NoSuchElementException ex, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		httpServletResponse.setHeader("Client-Code", HttpStatus.NOT_FOUND.name());
		httpServletResponse.setHeader("Client-Message", ex.getMessage());
		httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());

	}

}
