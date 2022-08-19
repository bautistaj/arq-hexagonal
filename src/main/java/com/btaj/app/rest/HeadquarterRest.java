package com.btaj.app.rest;

import com.btaj.app.dto.HeadquarterDTO;
import com.btaj.app.entity.HeadquarterEntity;
import com.btaj.app.rest.commons.ApiConst;
import com.btaj.app.rest.commons.ApiEndpointConst;
import com.btaj.app.service.exeption.HeadquarterServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiConst.API_HEADQUARTER)
public class HeadquarterRest {
    private final HeadquarterServiceImpl headquarterServiceImpl;

    @GetMapping()
    public ResponseEntity<?> findLike(@RequestParam(name = "name", defaultValue = "") String name){
        try {

            List<HeadquarterDTO> lstHeadquarter =
                    this.headquarterServiceImpl.findLike(HeadquarterDTO.builder().shortName(name).build());

            if(Objects.isNull(lstHeadquarter) || lstHeadquarter.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(lstHeadquarter);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiEndpointConst.MSG_INTERNAL_SERVER_ERROR);
        }
    }
}
