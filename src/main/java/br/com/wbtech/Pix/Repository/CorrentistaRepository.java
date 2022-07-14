package br.com.wbtech.Pix.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.wbtech.Pix.Entity.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Long>{

	@Query(value ="SELECT count(a.id) from correntista a WHERE (a.num_agencia = :num_agencia or :num_agencia=0) "
				 + "and (a.num_conta = :num_conta or :num_conta =0) "
				 + "and (tipo_chave = :tipo_chave or :tipo_chave is null) "
				 + "and (valor_chave = :valor_chave or :valor_chave is null)", nativeQuery = true)
	int validaCorrentista(@Param(value =  "num_agencia") long numAgencia,@Param(value =  "num_conta") long numConta, 
			@Param(value = "tipo_chave") String tipo_chave, @Param(value="valor_chave") String valor_chave);
}
