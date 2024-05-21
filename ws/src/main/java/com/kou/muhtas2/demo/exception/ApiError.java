package com.kou.muhtas2.demo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@JsonInclude(value = Include.NON_NULL)
public class ApiError {
    private final long timestamp = new Date().getTime();
    private Map<String, String> validationErrors = null;
    private int status;
    private String message;
    private String path;


}
