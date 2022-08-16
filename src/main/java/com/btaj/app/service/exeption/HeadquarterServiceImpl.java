package com.btaj.app.service.exeption;

import com.btaj.app.persistence.QueryUtil;
import com.btaj.app.entity.HeadquarterEntity;
import com.btaj.app.repository.HeadquarterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HeadquarterServiceImpl implements HeadquarterService {
    private final HeadquarterRepository headquarterRepository;

    @Override
    public List<HeadquarterEntity> findLike(HeadquarterEntity headquarterEntity) throws ServiceException {
        return this.headquarterRepository.findLike(QueryUtil.getLike(headquarterEntity.getName()));
    }

    @Override
    public Optional<HeadquarterEntity> findById(HeadquarterEntity headquarterEntity) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public HeadquarterEntity save(HeadquarterEntity headquarterEntity) throws ServiceException {
        return null;
    }
}
