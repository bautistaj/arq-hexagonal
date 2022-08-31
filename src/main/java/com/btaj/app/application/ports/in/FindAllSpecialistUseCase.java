package com.btaj.app.application.ports.in;

import com.btaj.app.domain.SpecialtyDomain;

import java.util.List;

@FunctionalInterface
public interface FindAllSpecialistUseCase {
    public List<SpecialtyDomain> findAll();
}
