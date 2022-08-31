package com.btaj.app.application.service;

import com.btaj.app.application.ports.in.FindAllSpecialistUseCase;
import com.btaj.app.application.ports.out.FindAllSpecialistPort;
import com.btaj.app.domain.SpecialtyDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindAllSpecialistService implements FindAllSpecialistUseCase {
    public final FindAllSpecialistPort findAllSpecialistPort;

    @Override
    public List<SpecialtyDomain> findAll() {
        return this.findAllSpecialistPort.findAll();
    }
}
