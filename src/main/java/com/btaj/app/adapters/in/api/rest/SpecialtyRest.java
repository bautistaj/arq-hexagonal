package com.btaj.app.adapters.in.api.rest;

import com.btaj.app.adapters.in.api.rest.commons.ApiConst;
import com.btaj.app.application.ports.in.FindAllSpecialistUseCase;
import com.btaj.app.domain.HeadquarterDomain;
import com.btaj.app.domain.SpecialtyDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.API_SPECIALITIES)
public class SpecialtyRest extends GenericRest{
    private final FindAllSpecialistUseCase findAllSpecialistUseCase;

    @GetMapping()
    public ResponseEntity<?> findAll(){
        log.info("Init SpecialtyRest::findAll");
        try {

            List<SpecialtyDomain> lstSpecialties =
                    this.findAllSpecialistUseCase.findAll();

            if(Objects.isNull(lstSpecialties) || lstSpecialties.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(lstSpecialties);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return super.getInternalServerError();
        }
    }
}
