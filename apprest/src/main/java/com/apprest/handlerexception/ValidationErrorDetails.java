package com.apprest.handlerexception;

import lombok.Data;

@Data
public class ValidationErrorDetails extends ErrorMessage {

    private String field;
    private String fieldMessage;
}
