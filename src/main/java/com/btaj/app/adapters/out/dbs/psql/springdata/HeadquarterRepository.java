package com.btaj.app.adapters.out.dbs.psql.springdata;

import com.btaj.app.adapters.out.dbs.psql.entity.HeadquarterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HeadquarterRepository extends GenericRepository<HeadquarterEntity, Long> {

    @Query("select h from " +
            "HeadquarterEntity h " +
            "where upper(h.shortName) like upper(:name) and h.state = '1' ")
    List<HeadquarterEntity> findLike(@Param("name") String name);
}
