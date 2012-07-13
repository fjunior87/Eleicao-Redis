package com.xicojunior.eleicao;

import java.util.Set;

import redis.clients.jedis.Tuple;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class UrnaController {

	private Result result;
	private Urna urna;
	private PainelControle painelControle;
	
	public UrnaController(Result result, Urna urna, PainelControle painelControle){
		this.result = result;
		this.urna = urna;
		this.painelControle = painelControle;
	}
	
	public void index(){
		this.result.include("numbers", urna.obterCandidatos());
	}
	
	@Post
	public void votar(String numero){
		Integer numeroCandidato = Integer.valueOf(numero);
		urna.votar(numeroCandidato);
	}
	
	public Set<Tuple> apuracao(){
		return painelControle.getCandidatos();
	}
}
