package com.fatecrl.contacorrente.mapper;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.fatecrl.contacorrente.dto.ContaCorrenteDTO;
import com.fatecrl.contacorrente.model.ContaCorrente;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ContaCorrenteMapper {
    public ContaCorrente toEntity(ContaCorrenteDTO dto){
        return new ContaCorrente(dto.getAgencia(), dto.getNumero(), dto.getTitular(), dto.getSaldo());
    }

    public ContaCorrenteDTO toDTO(ContaCorrente entity){
        return new ContaCorrenteDTO(entity.getAgencia(), entity.getNumero(), entity.getTitular(), entity.getSaldo());
    }

	public Page<ContaCorrenteDTO> toDTO(Page<ContaCorrente> pageable) {
		return pageable.map(this::toDTO);
	}

	public Page<ContaCorrente> toEntity(Page<ContaCorrenteDTO> pageable) {
		return pageable.map(this::toEntity);
	}
}
