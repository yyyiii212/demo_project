package com.example.demo_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()//�w�q����url���Q�O�@
		.antMatchers("/resources/**").permitAll()//resource��Ƨ��R�A��ƥi�ΦW�s��
//		.antMatchers("/hello").hasRole("user")//�w�q�ǰt��"/hello"���U���ݭn��user�o�Ө���~��i�h
		.anyRequest().authenticated()//��L�|���ǰt�쪺url���ݭn��������
		.and().formLogin()//�ۭq�ϥΪ�login����
		.and().httpBasic();//�t�m��http�򥻻{��
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// �U���o���t�m��ܦb�O���餤�t�m�F��Ӥ��P���⪺�ϥΪ�(����1:admin, ����2:user)
//	@Override
//	im memory
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("java1").roles("admin").password(passwordEncoder().encode("123")).and()
//				.withUser("java2").roles("user").password(passwordEncoder().encode("123"));
//	}

//	@Bean
//	public  PasswordEncoder passwordEncoder() {// �t�m�K�X�[�K����
//		return new BCryptPasswordEncoder();
//	}

    //======================
	// �����S�w���}�A���i��b�K�����n�J
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/hello.html").permitAll();
//	}
//
//	// ����k�P�W��2�h1
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/hello.html");
//	}
}
