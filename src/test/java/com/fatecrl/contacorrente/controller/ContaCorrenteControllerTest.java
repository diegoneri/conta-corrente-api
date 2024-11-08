package com.fatecrl.contacorrente.controller;
import com.fatecrl.contacorrente.controller.ContaCorrenteController;
import com.fatecrl.contacorrente.dto.ContaCorrenteDTO;
import com.fatecrl.contacorrente.mapper.ContaCorrenteMapper;
import com.fatecrl.contacorrente.model.Conta;
import com.fatecrl.contacorrente.repository.ContaRepository;
import com.fatecrl.contacorrente.service.ContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ContaCorrenteControllerTest {
    @Mock
    private ContaRepository contaRepository;

    @Mock
    private ContaService contaService;

    @Mock
    private ContaCorrenteMapper mapper;

    @InjectMocks
    private ContaCorrenteController contaCorrenteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllWithTitular() {
        // Arrange
        String titular = "John Doe";
        Pageable pageable = Pageable.ofSize(10).withPage(0);
        List<Conta> contas = new ArrayList<>();
        Conta c = new Conta();
        c.setTitular(titular);
        contas.add(c);
        Page<Conta> contaPage = new PageImpl<>(contas);

        when(contaService.findByTitular(titular, pageable)).thenReturn(contaPage);

        // Act
        ResponseEntity<Page<ContaCorrenteDTO>> response = contaCorrenteController.getAll(titular, pageable);

        // Assert
        assertEquals(ResponseEntity.ok(contaPage.map(mapper::toDTO)), response);
    }

    @Test
    void testGetAllWithoutTitular() {
        // Arrange
        Pageable pageable = Pageable.ofSize(10).withPage(0);
        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta());
        Page<Conta> contaPage = new PageImpl<>(contas);

        when(contaService.findAll(pageable)).thenReturn(contaPage);

        // Act
        ResponseEntity<Page<ContaCorrenteDTO>> response = contaCorrenteController.getAll(null, pageable);

        // Assert
        assertEquals(ResponseEntity.ok(contaPage.map(mapper::toDTO)), response);
    }
}