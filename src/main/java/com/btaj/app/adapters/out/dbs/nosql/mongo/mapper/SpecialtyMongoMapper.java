package com.btaj.app.adapters.out.dbs.nosql.mongo.mapper;

import com.btaj.app.adapters.out.dbs.nosql.mongo.documents.SpecialtyDocument;
import com.btaj.app.domain.HeadquarterDomain;
import com.btaj.app.domain.SpecialtyDomain;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SpecialtyMongoMapper implements GenericMapper<SpecialtyDocument, SpecialtyDomain> {
    private final JsonMapper jsonMapper;

    public SpecialtyDomain toDTO (SpecialtyDocument specialtyDocument){
        return jsonMapper.convertValue(specialtyDocument, SpecialtyDomain.class);
    }

    public SpecialtyDocument toEntity (SpecialtyDomain SpecialtyDomain){
        return jsonMapper.convertValue(SpecialtyDomain , SpecialtyDocument.class);
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
