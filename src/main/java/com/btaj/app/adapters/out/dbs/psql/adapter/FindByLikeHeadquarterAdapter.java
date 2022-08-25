package com.btaj.app.adapters.out.dbs.psql.adapter;

import com.btaj.app.adapters.out.dbs.psql.entity.HeadquarterEntity;
import com.btaj.app.adapters.out.dbs.psql.mapper.HeadquarterMapper;
import com.btaj.app.adapters.out.dbs.psql.springdata.HeadquarterRepository;
import com.btaj.app.application.ports.out.FindLikeHeadquarterPort;
import com.btaj.app.domain.HeadquarterDomain;
import com.btaj.app.adapters.out.dbs.psql.util.QueryUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByLikeHeadquarterAdapter implements FindLikeHeadquarterPort {
    private final HeadquarterRepository headquarterRepository;
    private final HeadquarterMapper headquarterMapper;

    @Override
    public List<HeadquarterDomain> findLike(String name) {
        log.info("Init HeadquarterAdapter::findLike");

        List<HeadquarterEntity> lstHeadquarterEntity =
                this.headquarterRepository.findLike(QueryUtil.getLike(QueryUtil.getLike(name)));

        return lstHeadquarterEntity.stream().map(headquarterEntity
                -> headquarterMapper.toDTO(headquarterEntity)).collect(Collectors.toList());
    }
}
