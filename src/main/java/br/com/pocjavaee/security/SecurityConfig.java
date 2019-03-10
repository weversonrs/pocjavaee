package br.com.pocjavaee.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler = new CustomizeAuthenticationSuccessHandler();
		
		http.csrf().disable()
	    .authorizeRequests()
	    	//Define as regras de restrições de acordo com os papéis
	    	.antMatchers("/pages/protected/home.xhtml").access("hasRole('ROLE_USER') or hasRole('ROLE_GESTOR') or hasRole('ROLE_UNIDADE')")
	    	.antMatchers("/pages/protected/doador/**").access("hasRole('ROLE_USER')")
	    	.antMatchers("/pages/protected/gestorDoacao/**").access("hasRole('ROLE_GESTOR')")
	    	.antMatchers("/pages/protected/unidadeHospitalar/**").access("hasRole('ROLE_UNIDADE')")
	    	//Define as regras de exceção para acesso a recursos e páginas
	    	.antMatchers("/resources/**", "/javax.faces.resource/**", "/index.xhtml").permitAll()
	        .anyRequest().authenticated()
	    .and()
	    	.logout()
	    	.logoutSuccessUrl("/")
	    	.permitAll()
	    .and()
	    .formLogin()
	        // Aqui dizemos que temos uma página customizada para login
	        .loginPage("/login.xhtml").successHandler(customizeAuthenticationSuccessHandler)
	        .failureUrl("/login.xhtml?erro")
	        // Mesmo sendo a página de login, precisamos avisar ao Spring Security para liberar o acesso a ela.
	        .permitAll()
	     .and()
	        .exceptionHandling().accessDeniedPage("/acessoNegado.xhtml");;

	} 
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("doador").password("doador")
				.roles("USER")
			.and()
			.withUser("unidade").password("unidade")
	            .roles("UNIDADE")
	        .and()
	        .withUser("gestor").password("gestor")
	            .roles("GESTOR");
		
	}	
} 