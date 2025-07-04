package com.example.customermanagement.service;

import java.util.Optional;

public interface IGenerateService<E> {
    Iterable<E> findAll();

    Optional<E> findById(Long id);

    E save(E e);

    void remove(Long id);
}
