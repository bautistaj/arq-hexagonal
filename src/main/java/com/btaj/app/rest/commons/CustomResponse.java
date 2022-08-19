package com.btaj.app.rest.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponse {
    private Integer code;
    private Object message;
}
