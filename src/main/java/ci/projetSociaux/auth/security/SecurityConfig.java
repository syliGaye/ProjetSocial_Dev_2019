package ci.projetSociaux.auth.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;
	
	@Override
    public void configure(WebSecurity web) throws Exception {
            web.ignoring()
            	.antMatchers("/resources/**")
            	.antMatchers("/rest/**");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/home").hasAnyRole("ADMIN","RESPONSABLE_TM","COORDINATEUR_REGIONAL","COORDINATEUR_LOCAL","COLLECTEUR","COORDINATEUR_UGP","RESPONSABLE_RSU")
		.antMatchers("/user/**").hasAnyRole("ADMIN")
		.antMatchers("/user").hasAnyRole("ADMIN")
	
        .antMatchers("/admin/**").hasAnyRole("ADMIN","RESPONSABLE_TM","COORDINATEUR_REGIONAL","COORDINATEUR_LOCAL","COLLECTEUR","COORDINATEUR_UGP","RESPONSABLE_RSU")
		.antMatchers("/admin").hasAnyRole("ADMIN","RESPONSABLE_TM","COORDINATEUR_REGIONAL","COORDINATEUR_LOCAL","COLLECTEUR","COORDINATEUR_UGP","RESPONSABLE_RSU")
                        
		.and().formLogin().permitAll()  //login configuration
        .loginPage("/")
        .loginProcessingUrl("/app-login")
        .usernameParameter("app_username")
        .passwordParameter("app_password")
        .defaultSuccessUrl("/home")	
		.and().logout()    //logout configuration
		.logoutUrl("/logout") 
		.logoutSuccessUrl("/")
		.and().exceptionHandling() //exception handling configuration
		.accessDeniedPage("/denied");

		http.sessionManagement().maximumSessions(1).expiredUrl("/");
		
	} 
	
    @Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
}