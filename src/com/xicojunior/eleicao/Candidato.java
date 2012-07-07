package com.xicojunior.eleicao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;



public class Candidato {

	private Integer numero;
	private String nome;
	private String resumo;
	public Candidato(){
		
	}
	public Candidato(Integer numero, String nome, String resumo){
		this.numero = numero;
		this.nome = nome;
		this.resumo = resumo;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getNumero() {
		return numero;
	}
	public String getNome() {
		return nome;
	}
	public String getResumo() {
		return resumo;
	}
	
	public String toJson(){
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("candidato", Candidato.class);
		return xstream.toXML(this);
		
	}
	
	public static Candidato fromJson(String json){
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("candidato", Candidato.class);
		return (Candidato)xstream.fromXML(json);
	}
	
	public static void main(String[] args) {
		String json = new Candidato(13,"j","w").toJson();
		System.out.println(json);
		Candidato c = fromJson(json);
		
	}
	
	
}
