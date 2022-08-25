package com.btaj.app.adapters.out.dbs.psql.adapter;

import com.btaj.app.adapters.out.dbs.psql.entity.HeadquarterEntity;
import com.btaj.app.adapters.out.dbs.psql.mapper.HeadquarterMapper;
import com.btaj.app.adapters.out.dbs.psql.springdata.HeadquarterRepository;
import com.btaj.app.application.ports.out.FindByIdHeadquarterPort;
import com.btaj.app.domain.HeadquarterDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByIdHeadquarterAdapter implements FindByIdHeadquarterPort {
    private final HeadquarterRepository headquarterRepository;
    private final HeadquarterMapper headquarterMapper;

    @Override
    public Optional<HeadquarterDomain> findById(Long id) {
        log.info("Init FindByIdHeadquarterAdapter::findById");

        Optional<HeadquarterEntity> optHeadquarter = this.headquarterRepository.findById(id);

        if(optHeadquarter.isPresent()){
            return Optional.of(this.headquarterMapper.toDTO(optHeadquarter.get()));
        }

        return Optional.empty();
    }
}
