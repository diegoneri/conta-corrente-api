package com.fatecrl.contacorrente.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecrl.contacorrente.dto.ContaCorrenteDTO;
import com.fatecrl.contacorrente.mapper.ContaCorrenteMapper;
import com.fatecrl.contacorrente.model.ContaCorrente;
import com.fatecrl.contacorrente.service.ContaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaCorrenteMapper mapper;

    //Para executar: http://localhost:8090/api/conta-corrente
    @GetMapping
    public ResponseEntity<Page<ContaCorrenteDTO>> getAll(@RequestParam(required = false) String titular, Pageable pageable){
        if (titular != null && !titular.isEmpty()){
            return ResponseEntity.ok(
                mapper.toDTO(
                    contaService.findByTitular(titular, pageable)
                )
             );
        }else{
            return ResponseEntity.ok(
                mapper.toDTO(
                    contaService.findAll(pageable)
                )
            );
        }
    }
    
    //Para executar: http://localhost:8090/api/conta-corrente/1 (ok)
    //Para executar: http://localhost:8090/api/conta-corrente/999 (not found)
    @GetMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> get(@PathVariable("id") Long id){
        ContaCorrente conta = contaService.find(id).orElse(null);
        if (conta != null){
            return ResponseEntity.ok(mapper.toDTO(conta));
        }
        return ResponseEntity.notFound().build();
    }    

    @PostMapping
    public ResponseEntity<ContaCorrenteDTO> create(@RequestBody @NonNull ContaCorrenteDTO conta){
        ContaCorrente entity = mapper.toEntity(conta);
        contaService.create(mapper.toEntity(conta));
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(entity.getId())
                            .toUri();
        return ResponseEntity.created(location).body(conta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> update(@PathVariable("id") Long id, @RequestBody @NonNull ContaCorrenteDTO conta){
        if (contaService.update(id, mapper.toEntity(conta))){
            return ResponseEntity.ok(conta);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> delete(@PathVariable("id") @NonNull Long id){
        if (contaService.delete(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
