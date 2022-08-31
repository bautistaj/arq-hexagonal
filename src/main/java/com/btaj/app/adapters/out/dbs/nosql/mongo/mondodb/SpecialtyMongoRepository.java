package com.btaj.app.adapters.out.dbs.nosql.mongo.mondodb;

import com.btaj.app.adapters.out.dbs.nosql.mongo.documents.SpecialtyDocument;

import java.util.List;

public interface SpecialtyMongoRepository extends GenericMongoRepository<SpecialtyDocument, String>{
    List<SpecialtyDocument> findByShortNameLike(String shortName);
}
