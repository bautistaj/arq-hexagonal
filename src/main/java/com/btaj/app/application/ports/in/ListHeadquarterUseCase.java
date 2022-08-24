package com.btaj.app.application.ports.in;

import com.btaj.app.domain.classes.HeadquarterDomain;

import java.util.List;

@FunctionalInterface
public interface ListHeadquarterUseCase {
    public List<HeadquarterDomain> listAll(String name);
}
