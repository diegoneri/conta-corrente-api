package com.fatecrl.contacorrente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatecrl.contacorrente.model.PessoaFisica;
import com.fatecrl.contacorrente.repository.PessoaFisicaRepository;

public class PessoaFisicaService implements IService<PessoaFisica> {

    @Autowired
    private PessoaFisicaRepository repository;

    @Override
    public PessoaFisica create(PessoaFisica obj) {
        return repository.save(obj);
    }

    @Override
    public PessoaFisica findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<PessoaFisica> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(PessoaFisica obj) {
        if (!repository.existsById(obj.getId().longValue())) {
            return false;
        }
        return repository.save(obj) != null;
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id.longValue())) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
