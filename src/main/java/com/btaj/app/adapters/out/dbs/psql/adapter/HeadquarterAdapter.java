package com.btaj.app.adapters.out.dbs.psql.adapter;

import com.btaj.app.adapters.out.dbs.psql.entity.HeadquarterEntity;
import com.btaj.app.adapters.out.dbs.psql.mapper.HeadquarterMapper;
import com.btaj.app.adapters.out.dbs.psql.springdata.HeadquarterRepository;
import com.btaj.app.adapters.out.dbs.psql.util.QueryUtil;
import com.btaj.app.application.ports.out.ListHeadquarterPort;
import com.btaj.app.domain.classes.HeadquarterDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class HeadquarterAdapter implements ListHeadquarterPort {
    private static HeadquarterRepository headquarterRepository;
    private static HeadquarterMapper headquarterMapper;

    @Override
    public List<HeadquarterDomain> listAll(String name) {
        log.info("::: HeadquarterRepository :::");
        List<HeadquarterEntity> lstHeadquarterEntity =
                this.headquarterRepository.findLike(QueryUtil.getLike(name));

        return lstHeadquarterEntity.stream().map(headquarterEntity
                -> headquarterMapper.toDTO(headquarterEntity)).collect(Collectors.toList());
    }
}
