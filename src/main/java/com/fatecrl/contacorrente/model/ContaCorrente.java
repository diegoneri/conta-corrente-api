package com.fatecrl.contacorrente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_conta")
public class ContaCorrente extends AbstractEntity  {
	
	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;
	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;
	@Column(name = "nm_titular", nullable = false, length = 100)
	private String titular;
	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;
    

    public ContaCorrente(Long id) {
        super(id);
    }    
}
