package com.btaj.app.adapters.out.dbs.psql.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "headquarters")
@EqualsAndHashCode(callSuper = false)
public class HeadquarterEntity extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqHeadquarter")
    @SequenceGenerator(name = "seqHeadquarter", allocationSize = 1, sequenceName = "SEQ_HEADQUARTER")
    @Builder.Default
    private Long id = 0L;

    @Size(min = 8, max = 120, message = "The min value is {min} and max {max}")
    private String shortName;

    @Size(min = 8, max = 120, message = "The min value is {min} and max {max}")
    private String largeName;
}
