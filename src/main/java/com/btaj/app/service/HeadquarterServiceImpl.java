package com.btaj.app.service;

import com.btaj.app.dto.HeadquarterDTO;
import com.btaj.app.mapper.HeadquarterMapper;
import com.btaj.app.persistence.QueryUtil;
import com.btaj.app.entity.HeadquarterEntity;
import com.btaj.app.repository.HeadquarterRepository;
import com.btaj.app.service.exeption.ServiceException;
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
    public List<HeadquarterDTO> findLike(HeadquarterDTO headquarterDTO) throws ServiceException {
        List<HeadquarterEntity> lstHeadquarterEntity =
                this.headquarterRepository.findLike(QueryUtil.getLike(headquarterDTO.getShortName()));
        return lstHeadquarterEntity.stream().map(headquarterEntity
                -> headquarterMapper.toDto(headquarterEntity)).collect(Collectors.toList());
    }

    @Override
    public Optional<HeadquarterDTO> findById(HeadquarterDTO headquarterDTO) throws ServiceException {
        try {

            Optional<HeadquarterEntity> optHeadquarterEntity = headquarterRepository.findById(headquarterDTO.getId());
            return optHeadquarterEntity.map(headquarterEntity -> headquarterMapper.toDto(headquarterEntity));

        } catch (Exception exception) {
            throw new ServiceException();
        }
    }

    @Override
    public HeadquarterDTO save(HeadquarterDTO headquarterDTO) throws ServiceException {
        return null;
    }
}
