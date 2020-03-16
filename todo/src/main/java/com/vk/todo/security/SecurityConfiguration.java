package com.vk.todo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	  private UserDetailsService userDetailsService;
	
	@Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  };
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());	
	  }
	
	  /*
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("test").password("test").roles("USER", "ADMIN");
		auth.inMemoryAuthentication().withUser("test2").password("test2").roles("USER", "ADMIN");
	}*/
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/favicon.ico", "/static/**", "/webjars/**","/todo/**");
	}

	@Override
	   protected void configure(HttpSecurity http) throws Exception {
		  
	      http.authorizeRequests().anyRequest().hasAnyRole("USER","ADMIN")
	      .and()
	      .authorizeRequests().antMatchers("/","/webjars/**","/css/**", "/js/**","/images/**", "**/favicon.ico", "/index", "/login**").permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login") // Specifies the login page URL
	      .loginProcessingUrl("/signin") // Specifies the URL,which is used 
	                                     //in action attribute on the <from> tag
	      .usernameParameter("username")  // Username parameter, used in name attribute
	                                    // of the <input> tag. Default is 'username'.
	      .passwordParameter("password")  // Password parameter, used in name attribute
	                                    // of the <input> tag. Default is 'password'.
	      .successHandler((req,res,auth)->{    //Success handler invoked after successful authentication
	         for (GrantedAuthority authority : auth.getAuthorities()) {
	            System.out.println(authority.getAuthority());
	         }
	         System.out.println(auth.getName());
	         res.sendRedirect("/"); // Redirect user to index/home page
	      })
	      .permitAll() // Allow access to any URL associate to formLogin()	      
	      .and()
	      .csrf().disable(); // Disable CSRF support
	     
	   }
	
	
	
}