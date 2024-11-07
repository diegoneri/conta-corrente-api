package com.fatecrl.contacorrente.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fatecrl.contacorrente.model.TipoMovimentacao;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovimentacaoDTO {
	@Min(1)
	@Max(100000)
	private Float valor;
	
	@NotNull(message = "Tipo requerido")
	private TipoMovimentacao tipo;
	
	@NotBlank(message = "Descrição requerida")
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@Past
	private Calendar data;	
}

