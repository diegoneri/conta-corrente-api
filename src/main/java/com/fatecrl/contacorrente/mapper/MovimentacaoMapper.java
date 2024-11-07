package com.fatecrl.contacorrente.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.fatecrl.contacorrente.dto.MovimentacaoDTO;
import com.fatecrl.contacorrente.model.Movimentacao;

import lombok.NoArgsConstructor;
import lombok.NonNull;
@Component
@NoArgsConstructor
public class MovimentacaoMapper {

    public MovimentacaoDTO toDTO(Movimentacao model){
        return new MovimentacaoDTO(model.getValor()
                                  , model.getTipo()
                                  , model.getDescricao()
                                  , model.getData());
    }

    public List<MovimentacaoDTO> toDTO(List<Movimentacao> modelList){
        return modelList.stream().map(this::toDTO).toList();
    }


    public Page<MovimentacaoDTO> toDTO(Page<Movimentacao> modelPage){
        return modelPage.map(this::toDTO);
    }   

    public Movimentacao toModel(@NonNull MovimentacaoDTO dto){
        return new Movimentacao(dto.getValor()
                              , dto.getTipo()
                              , dto.getDescricao()
                              , dto.getData());  
    }

    public List<Movimentacao> toModel(List<MovimentacaoDTO> dtoList){
        return dtoList.stream().map(this::toModel).toList();
    }    
}
