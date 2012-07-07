package com.xicojunior.eleicao;

import javax.annotation.PostConstruct;

import com.google.common.annotations.Beta;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

public class JedisPollCreator implements ComponentFactory<Jedis>{

	 private JedisPool pool;
	 public Jedis getInstance() {
		return null;
	}
	 
	@PostConstruct
	public void create(){
		pool = new JedisPool(new JedisPoolConfig(),"localhost");
	}
}
