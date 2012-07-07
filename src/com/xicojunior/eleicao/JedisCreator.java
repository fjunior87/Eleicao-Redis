package com.xicojunior.eleicao;

import redis.clients.jedis.Jedis;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class JedisCreator implements ComponentFactory<Jedis> {
	
	public Jedis getInstance() {
		return new Jedis("localhost");
	}

}
