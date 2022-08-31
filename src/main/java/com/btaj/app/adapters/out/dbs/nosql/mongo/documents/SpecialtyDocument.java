package com.btaj.app.adapters.out.dbs.nosql.mongo.documents;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("specialties")
@EqualsAndHashCode(callSuper = false)
public class SpecialtyDocument {
    @Id
    private String id;
    private String shortName;
    private String largeName;
}
