package com.fatecrl.contacorrente.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecrl.contacorrente.dto.MovimentacaoDTO;
import com.fatecrl.contacorrente.mapper.MovimentacaoMapper;
import com.fatecrl.contacorrente.model.Movimentacao;
import com.fatecrl.contacorrente.service.MovimentacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/conta-corrente/{idConta}/movimentacao")
@Tag(name = "Movimentações", description = "Movimentações de uma movimentacao corrente")
public class MovimentacaoController implements IController<MovimentacaoDTO> {
	@Autowired
	private MovimentacaoService service;

	@Autowired
	private MovimentacaoMapper mapper;

	@GetMapping(produces = "application/json")
	public ResponseEntity<Page<MovimentacaoDTO>> getAll(
			@PathVariable("idConta") Integer idConta, Pageable pageable) {
		return ResponseEntity.ok(mapper.toDTO(service.findByConta(idConta, pageable)));
	}

	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<MovimentacaoDTO> get(@PathVariable("id") Long id) {
		Movimentacao movimentacao = service.findById(id);
		if (movimentacao != null) {
			return ResponseEntity.ok(mapper.toDTO(movimentacao));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Operation(summary = "Cria uma movimentacao")
	public ResponseEntity<MovimentacaoDTO> post(@Valid @RequestBody MovimentacaoDTO movimentacaoDTO,
			@PathVariable("idConta") Integer idConta) {
		Movimentacao movimentacao = service.saveWithConta(mapper.toModel(movimentacaoDTO), idConta);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(movimentacao.getId())
				.toUri();
		return ResponseEntity.created(location).body(mapper.toDTO(movimentacao));
	}

	@Override
	public ResponseEntity<MovimentacaoDTO> post(MovimentacaoDTO obj) {
		throw new UnsupportedOperationException("Unimplemented method 'post'");
	}

	@Override
	public ResponseEntity<?> put(MovimentacaoDTO obj) {
		throw new UnsupportedOperationException("Movimentação is not upodatable");
	}

	@Override
	public ResponseEntity<?> patch(MovimentacaoDTO obj) {
		throw new UnsupportedOperationException("Movimentação is not upodatable");
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		throw new UnsupportedOperationException("Movimentação is no longer deletable");
	}

	@Override
	public ResponseEntity<Page<MovimentacaoDTO>> getAll(Pageable pageable) {
		throw new UnsupportedOperationException("Conta is required");
	}
}