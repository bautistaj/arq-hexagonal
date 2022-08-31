package com.btaj.app.adapters.out.dbs.nosql.mongo.adapter;

import com.btaj.app.adapters.out.dbs.nosql.mongo.documents.SpecialtyDocument;
import com.btaj.app.adapters.out.dbs.nosql.mongo.mapper.SpecialtyMongoMapper;
import com.btaj.app.adapters.out.dbs.nosql.mongo.mondodb.SpecialtyMongoRepository;
import com.btaj.app.application.ports.out.FindAllSpecialistPort;
import com.btaj.app.domain.SpecialtyDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindAllSpecialtyAdapter implements FindAllSpecialistPort {
    public final SpecialtyMongoRepository specialtyMongoRepository;
    public final SpecialtyMongoMapper specialtyMongoMapper;

    @Override
    public List<SpecialtyDomain> findAll() {
        List<SpecialtyDocument> lstSpecialtyDocument =
                this.specialtyMongoRepository.findAll();

        return lstSpecialtyDocument.stream().map(headquarterDocument
                -> specialtyMongoMapper.toDTO(headquarterDocument)).collect(Collectors.toList());
    }
}
