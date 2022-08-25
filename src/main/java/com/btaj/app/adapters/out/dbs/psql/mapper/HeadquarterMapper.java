package com.btaj.app.adapters.out.dbs.psql.mapper;

import com.btaj.app.domain.HeadquarterDomain;
import com.btaj.app.adapters.out.dbs.psql.entity.HeadquarterEntity;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class HeadquarterMapper implements GenericMapper<HeadquarterEntity, HeadquarterDomain>{
    private final JsonMapper jsonMapper;

    public HeadquarterDomain toDTO (HeadquarterEntity headquarterEntity){
        return jsonMapper.convertValue(headquarterEntity, HeadquarterDomain.class);
    }

    public HeadquarterEntity toEntity (HeadquarterDomain headquarterDTO){
        return jsonMapper.convertValue(headquarterDTO , HeadquarterEntity.class);
    }

    @Override
    public List toDTOs(List e) {
        return null;
    }

    @Override
    public List toEntities(List d) {
        return null;
    }
}
