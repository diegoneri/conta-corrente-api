package com.fatecrl.contacorrente.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IService<T> {
	T create(T obj);
	T findById(Long id);
	Page<T> findAll(Pageable pageable);
	boolean update(T obj);
	boolean delete(Long id);
}
