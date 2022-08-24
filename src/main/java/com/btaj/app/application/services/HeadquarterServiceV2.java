package com.btaj.app.application.services;

import com.btaj.app.adapters.out.dbs.psql.adapter.HeadquarterAdapter;
import com.btaj.app.application.ports.in.ListHeadquarterUseCase;
import com.btaj.app.application.ports.out.ListHeadquarterPort;
import com.btaj.app.domain.classes.HeadquarterDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class HeadquarterServiceV2 implements ListHeadquarterUseCase {
    private final HeadquarterAdapter listHeadquarterPort;

    @Override
    public List<HeadquarterDomain> listAll(String name) {
        log.info(":::: HeadquarterServiceV2 {}", listHeadquarterPort);
        return this.listHeadquarterPort.listAll(name);
    }
}
