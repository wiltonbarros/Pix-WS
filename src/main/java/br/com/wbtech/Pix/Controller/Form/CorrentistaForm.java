package br.com.wbtech.Pix.Controller.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CorrentistaForm {
	
	@NotNull @NotEmpty @Length(min = 3, max = 9)
	private String tipo_chave;
	@NotNull @NotEmpty @Length(max = 77)
	private String valor_chave;
	@NotNull @NotEmpty @Length(min = 8, max = 10)
	private String tipo_conta;
	@NotNull 
	private long num_agencia;
	@NotNull 
	private long num_conta;
	@NotNull @NotEmpty @Length(max = 30)
	private String nome_correntista;
	private String sobrenome_correntista;
	@NotNull @NotEmpty @Length(min = 2, max = 2)
	private String tipo_correntista;
	
	public String getTipo_correntista() {
		return tipo_correntista;
	}
	public void setTipo_correntista(String tipo_correntista) {
		this.tipo_correntista = tipo_correntista;
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
	public void setNum_agencia(long numero_agencia) {
		this.num_agencia = numero_agencia;
	}
	public long getNum_conta() {
		return num_conta;
	}
	public void setNum_conta(long numero_conta) {
		this.num_conta = numero_conta;
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
	
	

}
