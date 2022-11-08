package com.murillo.lojagames;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
				"SELECT email AS username, senha AS password, 1 AS enable FROM tb_administradores WHERE email=?")
				.authoritiesByUsernameQuery(
						"SELECT tb_administradores.email AS username, tb_papeis.nome AS authority FROM administrador_papel INNER JOIN tb_administradores ON tb_administradores.id = administrador_papel.administrador_id INNER JOIN tb_papeis ON administrador_papel.papel_id = tb_papeis.id WHERE tb_administradores.email =?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.antMatchers("/home", "/cliente/**", "/produto/**").hasAnyAuthority("ADMIN", "USER")	
				.antMatchers("/administrador/**", "/papel/**").hasAuthority("ADMIN")
				.and().formLogin().loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").and()
				.exceptionHandling().accessDeniedPage("/negado").and().csrf().disable();
	}
}