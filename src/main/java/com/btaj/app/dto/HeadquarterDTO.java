package com.btaj.app.dto;

import com.btaj.app.entity.GenericEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"id","shortName","largeName"})
public class HeadquarterDTO extends GenericDTO {
    private String shortName;
    private String largeName;
}
