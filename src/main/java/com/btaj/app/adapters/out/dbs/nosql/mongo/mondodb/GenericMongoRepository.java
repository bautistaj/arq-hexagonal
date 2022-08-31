package com.btaj.app.adapters.out.dbs.nosql.mongo.mondodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericMongoRepository<T, ID>  extends MongoRepository<T, ID> {
}
