package com.xicojunior.eleicao;

import java.io.InputStream;
import java.util.List;

import org.springframework.core.serializer.DefaultDeserializer;
import org.springframework.core.serializer.Deserializer;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CandidatoController {

	private final PainelControle painelControle;
	private final Result result;
	public CandidatoController(PainelControle painelControle, Result result){
		this.painelControle = painelControle;
		this.result = result;
		
	}
	
	public void lista(){
		List<String> jsonCandidatos = painelControle.listCandidatos();
		this.result.include("jsonList", jsonCandidatos);
	}
	
	public void form(){
		
	}
	@Post
	public void adiciona(Candidato candidato){
		System.out.println(candidato.toJson());
		this.painelControle.adicionarCandidato(candidato);
		this.result.include("message", "Candidato Incluido Com Sucesso!");
		this.result.forwardTo(this.getClass()).form();
	}
}
