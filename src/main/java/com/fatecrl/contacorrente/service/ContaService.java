package com.fatecrl.contacorrente.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatecrl.contacorrente.model.Conta;
import com.fatecrl.contacorrente.repository.ContaRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository repository;
	public ContaService() {
	}


    public List<Conta> findAll(){
        return repository.findAll();
    }

    public Conta find(Conta conta){
        return this.find(conta.getId());                           
    }

    public Conta find(Long id){
        return repository.findById(id).orElse(null);    
    }

    public List<Conta> findByTitular(String titular){
        return repository.findByTitular(titular);
    }

    public Conta create(Conta conta){
		repository.save(conta);
		return conta;
    }

    public Boolean delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);            
            return true;
        }
        return false;
    }

    public Boolean update(Conta conta){
        if (repository.existsById(conta.getId())){
            repository.save(conta);            
            return true;
        }
        return false;
    }
}
