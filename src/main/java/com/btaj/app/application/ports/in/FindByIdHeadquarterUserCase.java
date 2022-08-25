package com.btaj.app.application.ports.in;

import com.btaj.app.domain.HeadquarterDomain;

import java.util.Optional;

@FunctionalInterface
public interface FindByIdHeadquarterUserCase {
    public Optional<HeadquarterDomain> findById(Long id);
}
