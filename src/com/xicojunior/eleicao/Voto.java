package com.xicojunior.eleicao;

public class Voto {

	Integer numeroCandidato;
	
	public Voto(Integer numeroCandidato){
		if(numeroCandidato == null){
			throw new IllegalArgumentException("Necess�rio especificar o n�mero do candidato");
		}
		this.numeroCandidato = numeroCandidato;
	}
	
	public Integer getNumeroCandidato(){
		return this.numeroCandidato;
	}
}
