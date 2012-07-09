package com.xicojunior.eleicao;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class UrnaController {

	private Result result;
	private Urna urna;
	
	public UrnaController(Result result, Urna urna){
		this.result = result;
		this.urna = urna;
	}
	
	public void index(){
		this.result.include("numbers", urna.obterCandidatos());
	}
	
	@Post
	public void votar(String numero){
		Integer numeroCandidato = Integer.valueOf(numero);
		urna.votar(numeroCandidato);
	}
}
