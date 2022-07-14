package br.com.wbtech.Pix.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.wbtech.Pix.Controller.Form.CorrentistaForm;

@Entity
public class Correntista {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", updatable = false, unique = true, nullable = false)	
	private UUID id;
	
	@Column(nullable = false, length = 9)
	private String tipo_chave;
	
	@Column(nullable = false, length = 77)
	private String valor_chave;
	
	@Column(nullable = false, length = 10)
	private String tipo_conta;
	
	@Column(nullable = false, length = 4)
	private long num_agencia;
	
	@Column(nullable = false, length = 8)
	private long num_conta;
	
	@Column(nullable = false, length = 30)
	private String nome_correntista;
	
	@Column(nullable = true, length = 45)
	private String sobrenome_correntista;
	
	@Column(nullable = false, length = 2)
	private String tipo_correntista;
	
	private LocalDateTime data_Criacao = LocalDateTime.now();
	
	
	public LocalDateTime getData_Criacao() {
		return data_Criacao;
	}

	public void setData_Criacao(LocalDateTime data_Criacao) {
		this.data_Criacao = data_Criacao;
	}

	public String getTipo_correntista() {
		return tipo_correntista;
	}

	public void setTipo_correntista(String tipo_correntista) {
		this.tipo_correntista = tipo_correntista;
	}

	public void setNum_agencia(long num_agencia) {
		this.num_agencia = num_agencia;
	}

	public void setNum_conta(long num_conta) {
		this.num_conta = num_conta;
	}

	public Correntista() {}
	
	public Correntista(CorrentistaForm f) {
		this.tipo_chave = f.getTipo_chave();
		this.valor_chave = f.getValor_chave();
		this.tipo_conta = f.getTipo_conta();
		this.num_agencia = f.getNum_agencia();
		this.num_conta = f.getNum_conta();
		this.nome_correntista = f.getNome_correntista();
		this.sobrenome_correntista = f.getSobrenome_correntista();
		this.tipo_correntista = f.getTipo_correntista();
	}
	
	
	public String getTipo_chave() {
		return tipo_chave;
	}
	public void setTipo_chave(String tipo_chave) {
		this.tipo_chave = tipo_chave;
	}
	public String getValor_chave() {
		return valor_chave;
	}
	public void setValor_chave(String valor_chave) {
		this.valor_chave = valor_chave;
	}
	public String getTipo_conta() {
		return tipo_conta;
	}
	public void setTipo_conta(String tipo_conta) {
		this.tipo_conta = tipo_conta;
	}
	public long getNum_agencia() {
		return num_agencia;
	}
	public void setNum_agencia(int num_agencia) {
		this.num_agencia = num_agencia;
	}
	public long getNum_conta() {
		return num_conta;
	}
	public void setNum_conta(int num_conta) {
		this.num_conta = num_conta;
	}
	public String getNome_correntista() {
		return nome_correntista;
	}
	public void setNome_correntista(String nome_correntista) {
		this.nome_correntista = nome_correntista;
	}
	public String getSobrenome_correntista() {
		return sobrenome_correntista;
	}
	public void setSobrenome_correntista(String sobrenome_correntista) {
		this.sobrenome_correntista = sobrenome_correntista;
	}
	public UUID getId() {
		return id;
	}

	
	
}
