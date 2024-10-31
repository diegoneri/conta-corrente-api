package com.fatecrl.contacorrente.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContaCorrenteDTO {
	@Min(1)
	@Max(100000)
    @NotNull(message = "Agência requerida")
	private Integer agencia;

    @NotBlank(message = "Número requerido")
	private String numero;

    @NotBlank(message = "Titular requerido")
	private String titular;

	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;
}
