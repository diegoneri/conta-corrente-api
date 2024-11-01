package com.fatecrl.contacorrente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import com.fatecrl.contacorrente.model.Conta;
import com.fatecrl.contacorrente.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public ContaService(){

    }

    public Page<Conta> findAll(Pageable pageable){
        return contaRepository.findAll(pageable);
    }

    public Optional<Conta> find(Long id){
        return contaRepository.findById(id.longValue());
    }

    public Page<Conta> findByTitular(String titular, Pageable pageable){
        return contaRepository.findByTitular(titular, pageable);
    }

    public Conta create(@NonNull Conta conta){
        return contaRepository.save(conta);
    }

    public Boolean delete(@NonNull Long id){
        if (contaRepository.existsById(id)){
            contaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean update(@NonNull Conta conta){
        if (contaRepository.existsById(conta.getId().longValue())){
            contaRepository.save(conta);            
            return true;
        }
        return false;
    }
}
