package com.fatecrl.contacorrente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatecrl.contacorrente.model.Movimentacao;
import jakarta.transaction.Transactional;

public interface MovimentacaoRepository extends
		JpaRepository<Movimentacao, Long> {
	@Query(value = "SELECT * FROM tb_movimentacao m WHERE conta_id = :pConta", nativeQuery = true)
	Page<Movimentacao> findByConta(@Param("pConta")Integer conta, Pageable pageable);
	
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tb_movimentacao (vl_valor,conta_id,dt_data,ds_descricao,nm_tipo_movimentacao) VALUES " +
            "( " +
                ":#{#m.valor}, " +
                ":#{#pConta}, " +
                ":#{#m.data}, " +
                ":#{#m.descricao}, " +
                ":#{#m.tipo.name} " +
            ")", nativeQuery = true)
    Movimentacao saveWithConta(@Param("m") Movimentacao movimentacao, @Param("pConta")Integer conta);

}