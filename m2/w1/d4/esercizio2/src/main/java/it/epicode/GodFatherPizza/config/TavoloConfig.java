package it.epicode.GodFatherPizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.GodFatherPizza.beans.Tavolo;
import it.epicode.GodFatherPizza.beans.enums.StatoTavolo;

@Configuration
public class TavoloConfig {

	@Bean
	public Tavolo t1() {
		Tavolo t = new Tavolo( 1, StatoTavolo.LIBERO);
		return t;
	}
	@Bean
	public Tavolo t2() {
		Tavolo t = new Tavolo( 1, StatoTavolo.OCCUPATO);
		return t;
	}
	@Bean
	public Tavolo t3() {
		Tavolo t = new Tavolo( 1, StatoTavolo.LIBERO);
		return t;
	}
	@Bean
	public Tavolo t4() {
		Tavolo t = new Tavolo( 1, StatoTavolo.LIBERO);
		return t;
	}
	@Bean
	public Tavolo t5() {
		Tavolo t = new Tavolo( 1, StatoTavolo.OCCUPATO);
		return t;
	}
	@Bean
	public Tavolo t6() {
		Tavolo t = new Tavolo( 1, StatoTavolo.LIBERO);
		return t;
	}
	@Bean
	public Tavolo t7() {
		Tavolo t = new Tavolo( 1, StatoTavolo.OCCUPATO);
		return t;
	}
	@Bean
	public Tavolo t8() {
		Tavolo t = new Tavolo( 1, StatoTavolo.LIBERO);
		return t;
	}
}
