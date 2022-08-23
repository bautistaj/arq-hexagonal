package com.btaj.app.mapper;

import com.btaj.app.dto.HeadquarterDTO;
import com.btaj.app.entity.HeadquarterEntity;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class HeadquarterMapper implements GenericMapper<HeadquarterEntity, HeadquarterDTO>{
    private final JsonMapper jsonMapper;

    public HeadquarterDTO toDTO (HeadquarterEntity headquarterEntity){
        return jsonMapper.convertValue(headquarterEntity, HeadquarterDTO.class);
    }

    public HeadquarterEntity toEntity (HeadquarterDTO headquarterDTO){
        return jsonMapper.convertValue(headquarterDTO , HeadquarterEntity.class);
    }

    @Override
    public List toDTOs(List e) {
        return null;
    }

    @Override
    public List toEntities(List d) {
        return null;
    }
}
