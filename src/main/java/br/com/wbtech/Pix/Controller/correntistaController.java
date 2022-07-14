package br.com.wbtech.Pix.Controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wbtech.Pix.Controller.Form.CorrentistaForm;
import br.com.wbtech.Pix.Entity.Correntista;
import br.com.wbtech.Pix.Repository.CorrentistaRepository;
import br.com.wbtech.Pix.Controller.Validation.Validations;

@RestController
@RequestMapping(value = "/Correntista")
public class correntistaController {
	Validations v = new Validations();
	
	@Autowired
	CorrentistaRepository correntistaRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Correntista>> getCorrentistas(){
		return new ResponseEntity<>(correntistaRepository.findAll(),HttpStatus.OK);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Correntista> postCorrentista(@RequestBody @Valid CorrentistaForm c){
		boolean retorno = true;		
		
		retorno = v.ConsultaChave(c.getValor_chave(), correntistaRepository);
		if (retorno == false) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		//retorno = v.ValidaTipoChave(Long.valueOf(c.getNum_agencia()), Long.valueOf(c.getNum_conta()), c.getTipo_correntista(), correntistaRepository, c.getTipo_chave());
		//if (retorno == false) {
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	//	}
		
		retorno = v.ValidaCorrentista(Long.valueOf(c.getNum_agencia()), Long.valueOf(c.getNum_conta()), c.getTipo_correntista(), correntistaRepository);
		if (retorno == false) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		retorno = v.ValidaChave(c.getTipo_chave(), c.getValor_chave());
		if (retorno == false) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		
		
		try {					
			return new ResponseEntity<>(correntistaRepository.save(new Correntista(c)), HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		
	}

}
