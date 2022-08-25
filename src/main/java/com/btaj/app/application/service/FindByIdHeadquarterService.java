package com.btaj.app.application.service;

import com.btaj.app.application.ports.in.FindByIdHeadquarterUserCase;
import com.btaj.app.application.ports.out.FindByIdHeadquarterPort;
import com.btaj.app.domain.HeadquarterDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByIdHeadquarterService implements FindByIdHeadquarterUserCase {
    private final FindByIdHeadquarterPort findByIdHeadquarterPort;

    @Override
    public Optional<HeadquarterDomain> findById(Long id) {
        return this.findByIdHeadquarterPort.findById(id);
    }
}
