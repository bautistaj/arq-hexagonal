package com.btaj.app.adapters.in.api.rest;

import com.btaj.app.adapters.in.api.rest.commons.ApiEndpointConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericRest {

    public GenericRest(){

    }

    protected ResponseEntity<?> getInternalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiEndpointConst.MSG_INTERNAL_SERVER_ERROR);
    }
}
