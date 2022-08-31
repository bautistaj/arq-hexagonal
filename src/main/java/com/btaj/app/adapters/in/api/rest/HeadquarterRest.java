package com.btaj.app.adapters.in.api.rest;

import com.btaj.app.application.ports.in.FindByIdHeadquarterUserCase;
import com.btaj.app.application.ports.in.FindLikeHeadquarterUseCase;
import com.btaj.app.domain.HeadquarterDomain;
import com.btaj.app.adapters.in.api.rest.commons.ApiConst;
import com.btaj.app.adapters.in.api.rest.exception.HeadquarterNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.API_HEADQUARTER)
public class HeadquarterRest extends GenericRest{
    private final FindLikeHeadquarterUseCase findLikeHeadquarterUseCase;
    private final FindByIdHeadquarterUserCase findByIdHeadquarterUserCase;

    @GetMapping()
    public ResponseEntity<?> findLike(@RequestParam(name = "name", defaultValue = "") String name){
        log.info("Init HeadquarterRest::findLike");
        try {

            List<HeadquarterDomain> lstHeadquarter =
                    this.findLikeHeadquarterUseCase.findLike(name);

            if(Objects.isNull(lstHeadquarter) || lstHeadquarter.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(lstHeadquarter);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return super.getInternalServerError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id", required = true) Long id)
            throws HeadquarterNotFoundException{
        log.info("Init HeadquarterRest::findById");
            Optional<HeadquarterDomain> optHeadquarterDTO = this.findByIdHeadquarterUserCase
                    .findById(id);

            return optHeadquarterDTO.map(headquarterDTO -> new ResponseEntity<>(headquarterDTO, HttpStatus.OK))
                    .orElseThrow(() -> new HeadquarterNotFoundException(String.valueOf(id)));
    }
}
