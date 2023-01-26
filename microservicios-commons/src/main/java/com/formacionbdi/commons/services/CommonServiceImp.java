package com.formacionbdi.commons.services;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public class CommonServiceImp<E,R extends CrudRepository<E,Long>> implements CommonService<E> {

    @Autowired
    protected R repository;

    @Override
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
