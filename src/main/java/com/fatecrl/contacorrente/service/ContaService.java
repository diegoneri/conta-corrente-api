package com.fatecrl.contacorrente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import com.fatecrl.contacorrente.model.ContaCorrente;
import com.fatecrl.contacorrente.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public ContaService(){

    }

    public Optional<ContaCorrente> find(Long id){
        return repository.findById(id.longValue());
    }
    
    public Page<ContaCorrente> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<ContaCorrente> findByTitular(String titular, Pageable pageable){
        return repository.findByTitular(titular, pageable);
    }

    public void create(@NonNull ContaCorrente conta){
        repository.save(conta);
    }

    public Boolean delete(@NonNull Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean update(Long id, ContaCorrente conta){
        if (repository.existsById(id)){
            repository.save(conta);            
            return true;
        }
        return false;
    }
}
