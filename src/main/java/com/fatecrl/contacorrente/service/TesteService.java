package com.fatecrl.contacorrente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TesteService {

    @Autowired
    private TesteRepository testeRepository;

    public List<Teste> findAll() {
        return testeRepository.findAll();
    }

    public Optional<Teste> findById(Integer id) {
        return testeRepository.findById(id);
    }

    public Teste save(Teste teste) {
        return testeRepository.save(teste);
    }

    public void deleteById(Integer id) {
        testeRepository.deleteById(id);
    }
}