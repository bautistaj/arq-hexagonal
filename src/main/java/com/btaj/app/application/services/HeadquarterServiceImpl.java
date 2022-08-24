package com.btaj.app.application.services;

import com.btaj.app.domain.classes.HeadquarterDomain;
import com.btaj.app.adapters.out.dbs.psql.mapper.HeadquarterMapper;
import com.btaj.app.adapters.out.dbs.psql.util.QueryUtil;
import com.btaj.app.adapters.out.dbs.psql.entity.HeadquarterEntity;
import com.btaj.app.adapters.out.dbs.psql.springdata.HeadquarterRepository;
import com.btaj.app.application.services.exeption.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HeadquarterServiceImpl implements HeadquarterService {
    private final HeadquarterRepository headquarterRepository;
    private final HeadquarterMapper headquarterMapper;

    @Override
    public List<HeadquarterDomain> findLike(HeadquarterDomain headquarterDTO) throws ServiceException {
        List<HeadquarterEntity> lstHeadquarterEntity =
                this.headquarterRepository.findLike(QueryUtil.getLike(headquarterDTO.getShortName()));
        return lstHeadquarterEntity.stream().map(headquarterEntity
                -> headquarterMapper.toDTO(headquarterEntity)).collect(Collectors.toList());
    }

    @Override
    public Optional<HeadquarterDomain> findById(HeadquarterDomain headquarterDTO) throws ServiceException {
        try {

            Optional<HeadquarterEntity> optHeadquarterEntity = headquarterRepository.findById(headquarterDTO.getId());
            return optHeadquarterEntity.map(headquarterEntity -> headquarterMapper.toDTO(headquarterEntity));

        } catch (Exception exception) {
            throw new ServiceException();
        }
    }

    @Override
    public HeadquarterDomain save(HeadquarterDomain headquarterDTO) throws ServiceException {
        return null;
    }
}
