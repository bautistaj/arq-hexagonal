package com.btaj.app.adapters.in.rest.api;

import com.btaj.app.adapters.in.rest.commons.ApiConst;
import com.btaj.app.application.ports.in.ListHeadquarterUseCase;
import com.btaj.app.domain.classes.HeadquarterDomain;
import com.btaj.app.adapters.in.rest.exception.HeadquarterNotFoundException;
import com.btaj.app.application.services.HeadquarterServiceImpl;
import com.btaj.app.application.services.exeption.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiConst.API_HEADQUARTER)
public class HeadquarterRest extends GenericRest{
    private final ListHeadquarterUseCase listHeadquarterUseCase;

    @GetMapping()
    public ResponseEntity<?> findLike(@RequestParam(name = "name", defaultValue = "") String name){
        try {
            log.info(":::: HeadquarterRest", listHeadquarterUseCase);
            List<HeadquarterDomain> lstHeadquarter =
                    this.listHeadquarterUseCase.listAll(name);

            if(Objects.isNull(lstHeadquarter) || lstHeadquarter.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(lstHeadquarter);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return super.getInternalServerError();
        }
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id", required = true) Long id)
            throws HeadquarterNotFoundException{
        try {

            Optional<HeadquarterDomain> optHeadquarterDTO = this.headquarterServiceImpl
                    .findById(HeadquarterDomain.builder().id(id).build());

            return optHeadquarterDTO.map(headquarterDTO -> new ResponseEntity<>(headquarterDTO, HttpStatus.OK))
                    .orElseThrow(() -> new HeadquarterNotFoundException(String.valueOf(id)));

        } catch (ServiceException e) {
            log.error(e.getMessage(), e);
            return super.getInternalServerError();
        }
    }
    */
}
