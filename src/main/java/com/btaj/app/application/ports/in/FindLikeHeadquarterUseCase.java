package com.btaj.app.application.ports.in;

import com.btaj.app.domain.HeadquarterDomain;

import java.util.List;

@FunctionalInterface
public interface FindLikeHeadquarterUseCase {
    public List<HeadquarterDomain> findLike(String name);
}
