package com.team10.banchan.exceptionhandler;

import com.team10.banchan.dto.OutOfOrderInfo;
import com.team10.banchan.exception.NotFoundException;
import com.team10.banchan.exception.OutOfStockException;
import com.team10.banchan.response.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseBody<String> notFound(NotFoundException notFoundException) {
        return ResponseBody.notFound(notFoundException.getMessage());
    }

    @ExceptionHandler(OutOfStockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBody<OutOfOrderInfo> outOfStock(OutOfStockException outOfStockException) {
        return ResponseBody.badRequest(OutOfOrderInfo.of(outOfStockException.getCurrentStock()));
    }
}
