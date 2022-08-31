package com.btaj.app.application.ports.out;

import com.btaj.app.domain.SpecialtyDomain;

import java.util.List;

@FunctionalInterface
public interface FindAllSpecialistPort {
    public List<SpecialtyDomain> findAll();
}
