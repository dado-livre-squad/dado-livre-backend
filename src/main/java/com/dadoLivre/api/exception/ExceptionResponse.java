package com.dadoLivre.api.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String msg, String details) { }