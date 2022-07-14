package br.com.wbtech.Pix.Controller.Validation;

import br.com.wbtech.Pix.Repository.CorrentistaRepository;

public class Validations {

	public boolean ValidaCorrentista(long numAgencia, long numConta, String tipo_correntista,
			CorrentistaRepository correntistaRepository) {

		// Valida quantidade de cadastros
		if ((tipo_correntista.equals("PF") && correntistaRepository.validaCorrentista(Long.valueOf(numAgencia),
				Long.valueOf(numConta), null, null) > 4)
				|| (tipo_correntista.equals("PJ") && correntistaRepository.validaCorrentista(Long.valueOf(numAgencia),
						Long.valueOf(numConta), null, null) > 19)) {
			return false;
		}
		return true;
	}

	// valida os tipos de chaves
	/*
	 * public boolean ValidaTipoChave(long numAgencia,long numConta, String
	 * tipo_correntista, CorrentistaRepository correntistaRepository, String
	 * tipo_chave) { boolean retorno = true;
	 * if(correntistaRepository.validaCorrentista(Long.valueOf(numAgencia),
	 * Long.valueOf(numConta), tipo_chave, null)>=1 ) { retorno = false; } return
	 * retorno; }
	 */

	public boolean ConsultaChave(String valor_chave, CorrentistaRepository correntistaRepository) {

		if (correntistaRepository.validaCorrentista(0, 0, null, valor_chave) > 0) {
			return false;
		}

		return true;
	}

	public boolean ValidaChave(String tipo_chave, String chave) {

		// Regex validação celular
		if (tipo_chave.equals("celular")
				&& !chave.matches("^\\+[1-9]{1}[1-9]{0,1}[0]{0,1}[1-9]{2}[9]{1}[6-9]{1}[0-9]{3}[0-9]{4}$")) {
			return false;
		} else if (tipo_chave.equals("cpf") && !chave.matches(
				"([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")) {
			return false;
			// Regex validação email
		} else if (tipo_chave.equals("email")
				&& !chave.matches("[A-Za-z]{1}[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")) {
			return false;
		}
		return true;
	}

}
