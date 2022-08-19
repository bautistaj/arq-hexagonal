package com.btaj.app.mapper;

import com.btaj.app.dto.HeadquarterDTO;
import com.btaj.app.entity.HeadquarterEntity;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HeadquarterMapper {
    private final JsonMapper jsonMapper;

    public HeadquarterDTO toDto (HeadquarterEntity headquarterEntity){
        return jsonMapper.convertValue(headquarterEntity, HeadquarterDTO.class);
    }

    HeadquarterEntity toEntity (HeadquarterDTO headquarterDTO){
        return jsonMapper.convertValue(headquarterDTO , HeadquarterEntity.class);
    }
}
