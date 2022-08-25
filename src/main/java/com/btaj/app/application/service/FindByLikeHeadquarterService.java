package com.btaj.app.application.service;

import com.btaj.app.application.ports.in.FindLikeHeadquarterUseCase;
import com.btaj.app.application.ports.out.FindLikeHeadquarterPort;
import com.btaj.app.domain.HeadquarterDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByLikeHeadquarterService implements FindLikeHeadquarterUseCase {
    private final FindLikeHeadquarterPort findLikeHeadquarterPort;

    @Override
    public List<HeadquarterDomain> findLike(String name) {
        log.info("Init HeadquarterDomain::findLike ");

        return this.findLikeHeadquarterPort.findLike(name);
    }
}
