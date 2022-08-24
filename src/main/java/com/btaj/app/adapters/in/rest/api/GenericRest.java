package com.btaj.app.adapters.in.rest.api;

import com.btaj.app.adapters.in.rest.commons.ApiEndpointConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericRest {

    public GenericRest(){

    }

    protected ResponseEntity<?> getInternalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiEndpointConst.MSG_INTERNAL_SERVER_ERROR);
    }
}
