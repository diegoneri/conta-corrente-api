package com.fatecrl.contacorrente.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContaCorrenteDTO {
	@NotNull
    private Integer agencia;
    @NotNull
    @Size(min = 5, max = 5)
	private String numero;
    @NotNull
    @Size(min = 4, max = 60)
	private String titular;
    @NotNull
    @Min(1) 
	private Double saldo;
}
