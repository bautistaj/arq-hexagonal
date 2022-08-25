package com.btaj.app.adapters.out.dbs.psql.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class GenericEntity implements Serializable {
    private String state = "1";
}
