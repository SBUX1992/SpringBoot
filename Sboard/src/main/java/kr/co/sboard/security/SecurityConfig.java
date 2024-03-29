package kr.co.sboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 접근권한
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/board/list").hasAnyRole("2", "3", "4", "5") ;
		http.authorizeRequests().antMatchers("/board/write").hasAnyRole("2", "3", "4", "5") ;
		http.authorizeRequests().antMatchers("/board/view").hasAnyRole("2", "3", "4", "5") ;
		http.authorizeRequests().antMatchers("/board/modify").hasAnyRole("2","3", "4", "5") ;

		// 사이트위조 방지설정
		http.csrf().disable();

		//로그인 
		http.formLogin()
		.loginPage("/user/login")
		.defaultSuccessUrl("/list?pg=1")
		.failureUrl("/user/login?success=102")
		.usernameParameter("uid")
		.passwordParameter("pass");

		//로그아웃 설정 
		http.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/user/login?success=103");

		// 자동로그인
		// http.rememberMe().key("remember_me").rememberMeParameter("remember_me").
		// tokenValiditySeconds(3600);

	}
	
	@Autowired
	private SecurityUserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//로그인 암호화 서비스 방식 설정
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}