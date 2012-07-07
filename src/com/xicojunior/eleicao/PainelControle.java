package com.xicojunior.eleicao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.caelum.vraptor.ioc.Component;

import redis.clients.jedis.BinaryTransaction;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

@Component
public class PainelControle {
	
	Jedis jedis;
	public PainelControle(Jedis jedis){
		this.jedis = jedis;
	}
	
	public void adicionarCandidato(Candidato candidato){
		System.out.println(jedis);
		System.out.println(candidato.getNumero().toString());
		jedis.hset(ChavesGerais.CANDIDATO.toString(), candidato.getNumero().toString(), candidato.toJson());
	}
	
	public void setarCandidatos(String... candidatos){
		Map<Double, String> candidatosMap = new HashMap<Double, String>();
		for(String candidato : candidatos){
			candidatosMap.put(0d,candidato);
		}
		
		jedis.zadd(ChavesGerais.CANDIDATOS.name(), candidatosMap);
	}
	
	public List<String> listCandidatos(){
		return jedis.hvals(ChavesGerais.CANDIDATO.name());
	}
	
	public Set<Tuple> getCandidatos(){
		return jedis.zrevrangeWithScores(ChavesGerais.CANDIDATOS.toString(), 0, -1);
	}
	
	public void printResultados(){
		int totalVotos = 0;
		
		Set<Tuple> candidatos = getCandidatos();		
		for(Tuple candidato : candidatos){
			totalVotos += candidato.getScore();
		}
		System.out.println("Total Votos:" + totalVotos);
		for(Tuple candidato : candidatos){
			System.out.println(candidato.getElement() + " - " + ((candidato.getScore()/Double.valueOf(totalVotos)) * 100)  + "%");
		}
	}
}
