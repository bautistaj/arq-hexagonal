package com.btaj.app.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"id","shortName","largeName"})
public class HeadquarterDomain extends GenericDomain {
    private String shortName;
    private String largeName;
}
