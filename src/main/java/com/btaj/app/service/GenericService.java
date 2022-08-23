package com.btaj.app.service;

import com.btaj.app.service.exeption.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    List<T> findLike(T t) throws ServiceException;
    Optional<T> findById(T t) throws ServiceException;
    T save(T t) throws ServiceException;
}
