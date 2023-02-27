package jp.co.axa.apidemo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@ExceptionHandler(Exception.class)
	public void handleException(Exception e) {
		logger.error(e.getMessage());
	}
}
