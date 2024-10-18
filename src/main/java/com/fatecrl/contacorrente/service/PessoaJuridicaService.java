package com.fatecrl.contacorrente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.fatecrl.contacorrente.model.PessoaJuridica;
import com.fatecrl.contacorrente.repository.PessoaJuridicaRepository;

public class PessoaJuridicaService implements IService<PessoaJuridica> {

    @Autowired
    private PessoaJuridicaRepository repository;

    @Override
    public PessoaJuridica create(PessoaJuridica obj) {
        return repository.save(obj);
    }

    @Override
    public PessoaJuridica findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<PessoaJuridica> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(PessoaJuridica obj) {
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
