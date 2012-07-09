package com.xicojunior.eleicao;

import java.util.Set;

import br.com.caelum.vraptor.ioc.Component;

import redis.clients.jedis.Jedis;

@Component
public class Urna {

	
	Jedis jedis;
	public Urna(Jedis jedis){
		this.jedis = jedis;
	}
	
	public void submeterVoto(Voto voto){
		jedis.zincrby(ChavesGerais.CANDIDATOS.name(), 1, voto.getNumeroCandidato().toString());
	}
	
	public Set<String> obterCandidatos(){
		return jedis.zrange(ChavesGerais.CANDIDATOS.toString(),0, -1);
	}
	
	public void votar(Integer numeroCandidato){
		Voto voto = new Voto(numeroCandidato);
		submeterVoto(voto);
	}
	
}
