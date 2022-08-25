package com.btaj.app.adapters.out.dbs.psql.mapper;

import java.util.List;

public interface GenericMapper<E,D> {
    D toDTO(E e);
    E toEntity(D D);
    List<D> toDTOs(List<E> e);
    List<E> toEntities(List<D> d);
}
