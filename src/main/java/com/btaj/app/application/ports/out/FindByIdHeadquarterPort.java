package com.btaj.app.application.ports.out;

import com.btaj.app.domain.HeadquarterDomain;

import java.util.Optional;

@FunctionalInterface
public interface FindByIdHeadquarterPort {
    public Optional<HeadquarterDomain> findById(Long id);
}
