package com.btaj.app.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class GenericEntity implements Serializable {
    private String state = "1";
}
