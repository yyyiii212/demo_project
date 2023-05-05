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
		http.authorizeRequests()//定義哪些url須被保護
		.antMatchers("/resources/**").permitAll()//resource資料夾靜態資料可匿名存取
//		.antMatchers("/hello").hasRole("user")//定義匹配到"/hello"底下的需要有user這個角色才能進去
		.anyRequest().authenticated()//其他尚未匹配到的url都需要身分驗證
		.and().formLogin()//自訂使用者login介面
		.and().httpBasic();//配置為http基本認證
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// 下面這兩行配置表示在記憶體中配置了兩個不同角色的使用者(角色1:admin, 角色2:user)
//	@Override
//	im memory
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("java1").roles("admin").password(passwordEncoder().encode("123")).and()
//				.withUser("java2").roles("user").password(passwordEncoder().encode("123"));
//	}

//	@Bean
//	public  PasswordEncoder passwordEncoder() {// 配置密碼加密元件
//		return new BCryptPasswordEncoder();
//	}

    //======================
	// 忽略特定網址，不進行帳密直接登入
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/hello.html").permitAll();
//	}
//
//	// 此方法與上面2則1
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/hello.html");
//	}
}
