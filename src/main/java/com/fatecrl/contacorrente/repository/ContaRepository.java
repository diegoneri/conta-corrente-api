package com.fatecrl.contacorrente.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fatecrl.contacorrente.model.Conta;

@Repository
public interface ContaRepository 
         extends JpaRepository<Conta, Long>{

    public Page<Conta> findByTitular(String titular, Pageable pageable);

    Page<Conta> listarPorAgencia(Integer agencia, Pageable pageable);
   
    Page<Conta> listarPorAgenciaESaldo(Integer agencia, 
                                Float from, Float to, Pageable pageable);
 
   @Query("select c from Conta c join Cliente cc on " 
        + "cc.conta = c where cc.nome like ?1")
    Page<Conta> listarPorNomeCliente(String nome, Pageable pageable);    


            /*
             *    @Query("select c from Conta c where c.agencia=?1")
                  List<Conta> listarPorAgencia(Integer agencia);

                    @Query("select c from Conta c where c.agencia=?1 and " 
                                                + "c.saldo between ?2 and ?3")
                    List<Conta> listarPorAgenciaESaldo(Integer agencia, 
                                                    Float from, Float to);

                    @Query("select c from Conta c join Cliente cc on "
                                    + " cc.conta = c where cc.nome like %?1%")
                    List<Conta> listarPorNomeCliente(String nome);

             * 
             */

}
