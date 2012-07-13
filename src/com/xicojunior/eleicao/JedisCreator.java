package com.xicojunior.eleicao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class JedisCreator implements ComponentFactory<Jedis> {
	
	JedisPool pool;
	Jedis jedis;
	
	public JedisCreator(JedisPool pool) {
		this.pool = pool;
	}
	
	public Jedis getInstance() {
		return jedis;
	}
	
	@PostConstruct
	public void create(){
		jedis = pool.getResource();
	}
	
	@PreDestroy
	public void destroy(){
		pool.returnResource(jedis);
	}
}
