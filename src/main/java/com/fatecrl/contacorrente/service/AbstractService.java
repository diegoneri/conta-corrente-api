package com.fatecrl.contacorrente.service;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fatecrl.contacorrente.model.AbstractEntity;

public class AbstractService<T> implements IService<T> {
	
	private JpaRepository<T, Long> repository;

	public AbstractService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}

	@Override
	public T findById(Long id) {
		Optional<T> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public T create(T entity) {
		repository.save(entity);
		return entity;
	}

	@Override
	public boolean update(T entity) {
		if (repository.existsById(((AbstractEntity) entity).getId())) {
			repository.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}