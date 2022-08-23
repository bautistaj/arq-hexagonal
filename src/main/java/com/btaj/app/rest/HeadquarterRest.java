package com.btaj.app.rest;

import com.btaj.app.dto.HeadquarterDTO;
import com.btaj.app.rest.commons.ApiConst;
import com.btaj.app.rest.exception.HeadquarterNotFoundException;
import com.btaj.app.service.HeadquarterServiceImpl;
import com.btaj.app.service.exeption.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
            return super.getInternalServerError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id", required = true) Long id)
            throws HeadquarterNotFoundException{
        try {

            Optional<HeadquarterDTO> optHeadquarterDTO = this.headquarterServiceImpl
                    .findById(HeadquarterDTO.builder().id(id).build());

            return optHeadquarterDTO.map(headquarterDTO -> new ResponseEntity<>(headquarterDTO, HttpStatus.OK))
                    .orElseThrow(() -> new HeadquarterNotFoundException(String.valueOf(id)));

        } catch (ServiceException e) {
            log.error(e.getMessage(), e);
            return super.getInternalServerError();
        }
    }
}
