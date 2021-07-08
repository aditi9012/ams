package audit.Authorization.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	public WebSecurityConfig() {
		logger.info("inside the const");
	}
	
	 @Autowired
	    UserDetailsService userDetailsService;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }

	    @Override
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {
		    return super.authenticationManagerBean();
		}
	    
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		logger.info("inside the configur2");

		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/authenticate").permitAll().
				
				
				anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
