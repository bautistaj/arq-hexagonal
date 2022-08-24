package com.btaj.app.application.ports.out;

import com.btaj.app.domain.classes.HeadquarterDomain;

import java.util.List;

@FunctionalInterface
public interface ListHeadquarterPort {
    public List<HeadquarterDomain> listAll(String name);
}
