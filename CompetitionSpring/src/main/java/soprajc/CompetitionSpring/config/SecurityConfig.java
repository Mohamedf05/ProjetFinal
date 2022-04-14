package soprajc.CompetitionSpring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/api/**")
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().ignoringAntMatchers("/api/**")
			.and()
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers("/api/**").permitAll()				
				.antMatchers(HttpMethod.POST).permitAll()
				.antMatchers(HttpMethod.GET,"/api/auth/obj").authenticated()
				.antMatchers("/api/athlete/**").hasRole("ATHLETE")
				.antMatchers("/api/epreuve/**").hasAnyRole("ATHLETE","ORGANISATEUR")
				.antMatchers("/api/journaliste/**").hasRole("JOURNALISTE")
				.antMatchers("/api/logement/**").hasRole("ORGANISATEUR")
				.antMatchers("/api/organisateur/**").hasRole("ORGANISATEUR")
				.antMatchers("/api/reservation/**").authenticated()
				.antMatchers("/api/spectateur/**").hasRole("SPECTATEUR")
				.antMatchers("/api/terrain/**").hasRole("ORGANISATEUR")
			.and()
			.httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
