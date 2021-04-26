package com.team10.banchan.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team10.banchan.dto.OutOfOrderInfo;
import com.team10.banchan.exception.NotFoundException;

public class ResponseBody<T> {

    private final Integer statusCode;
    private final T body;

    private ResponseBody(Integer statusCode, T body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public static <T> ResponseBody<T> ok(T body) {
        return new ResponseBody<>(200, body);
    }

    public static ResponseBody<String> notFound(String message) {
        return new ResponseBody<>(404, message);
    }

    public static <T> ResponseBody<T> badRequest(T body) {
        return new ResponseBody<>(400, body);
    }

    @JsonProperty("statusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    @JsonProperty("body")
    public T getBody() {
        return body;
    }
}
