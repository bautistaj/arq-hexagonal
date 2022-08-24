package com.btaj.app.adapters.out.dbs.psql.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, ID>  extends JpaRepository<T, ID> {
}
