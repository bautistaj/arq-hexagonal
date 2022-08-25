package com.btaj.app.application.ports.out;

import com.btaj.app.domain.HeadquarterDomain;

import java.util.List;

@FunctionalInterface
public interface FindLikeHeadquarterPort {
    public List<HeadquarterDomain> findLike(String name);
}
