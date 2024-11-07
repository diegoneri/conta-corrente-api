package com.fatecrl.contacorrente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_conta")
@AllArgsConstructor
@NamedQueries({ 
    @NamedQuery(name = "Conta.listarPorAgencia", 
       query = "select c from Conta c where c.agencia=?1"),
 
 
    @NamedQuery(name = "Conta.listarPorAgenciaESaldo", 
       query = "select c from Conta c where c.agencia=?1 and" 
               + " c.saldo between ?2 and ?3"),
 
 
    @NamedQuery(name = "Conta.listarPorNomeCliente", 
       query = "select c from Conta c join Cliente cc on" 
               + " cc.conta = c where cc.nome like ?1")
 })  
public class Conta extends AbstractEntity  {
	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;
	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;
	@Column(name = "nm_titular", nullable = false, length = 100)
	private String titular;
	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;
    
    public Conta() {
    }

    public Conta(Long id) {
        super(id);
    }    
    
    public Integer getAgencia() {
        return agencia;
    }
    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
