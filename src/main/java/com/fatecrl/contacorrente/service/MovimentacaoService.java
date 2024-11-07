package com.fatecrl.contacorrente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatecrl.contacorrente.model.Movimentacao;
import com.fatecrl.contacorrente.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService extends AbstractService<Movimentacao>{
	private MovimentacaoRepository repository;

	public MovimentacaoService(MovimentacaoRepository repository) {
		super(repository);
	}
	
	@Autowired
	public void setRepository(MovimentacaoRepository repository) {
		this.repository = repository;
	}
	
	public MovimentacaoRepository getRepository() {
		return repository;
	}
	
	public Page<Movimentacao> findByConta(Integer idConta, Pageable pageable){
		return repository.findByConta(idConta, pageable);
	}
	
	public Movimentacao saveWithConta(Movimentacao movimentacao, Integer idConta) {
		return repository.saveWithConta(movimentacao, idConta);
	}
    
}
