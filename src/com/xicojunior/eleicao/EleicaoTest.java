package com.xicojunior.eleicao;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class EleicaoTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		PainelControle painel = new PainelControle(jedis);
		painel.setarCandidatos("13","42","23");
		
		Urna urna = new Urna(jedis);
		Set<String> candidatos = urna.obterCandidatos();
		
		System.out.println(candidatos);
		
		System.out.println("Votando candidato 13");
		urna.votar(13);
		
		System.out.println("Votando candidato 13");
		urna.votar(13);
		
		System.out.println("Votando candidato 42");
		urna.votar(42);
		
		painel.printResultados();
	}
}
