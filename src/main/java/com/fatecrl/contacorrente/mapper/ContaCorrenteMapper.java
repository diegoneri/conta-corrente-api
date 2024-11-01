package com.fatecrl.contacorrente.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.fatecrl.contacorrente.dto.ContaCorrenteDTO;
import com.fatecrl.contacorrente.model.Conta;

import lombok.NonNull;

@Component
public class ContaCorrenteMapper {

    public ContaCorrenteDTO toDTO(Conta model){
        return new ContaCorrenteDTO(model.getAgencia()
                                  , model.getNumero()
                                  , model.getTitular()
                                  , model.getSaldo());
    }

    public List<ContaCorrenteDTO> toDTO(List<Conta> modelList){
        return modelList.stream().map(this::toDTO).toList();
    }


    public Page<ContaCorrenteDTO> toDTO(Page<Conta> modelPage){
        return modelPage.map(this::toDTO);
    }   

    public Conta toModel(@NonNull ContaCorrenteDTO dto){
        return new Conta(dto.getAgencia()
                       , dto.getNumero()
                       , dto.getTitular()
                       , dto.getSaldo());  
    }

    public List<Conta> toModel(List<ContaCorrenteDTO> dtoList){
        return dtoList.stream().map(this::toModel).toList();
    }

    
}
