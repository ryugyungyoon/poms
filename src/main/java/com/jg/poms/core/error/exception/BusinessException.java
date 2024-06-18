package com.jg.poms.core.error.exception;

import com.jg.poms.core.error.ErrorCode;

import java.io.Serial;

public class BusinessException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1614542236477807379L;
	private final ErrorCode errorCode;

	public BusinessException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}

	public BusinessException(ErrorCode errorCode){
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode(){
		return errorCode;
	}

}
