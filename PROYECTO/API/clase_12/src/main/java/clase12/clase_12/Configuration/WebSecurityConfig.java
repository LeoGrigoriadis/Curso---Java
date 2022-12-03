package clase12.clase_12.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration{
    
    @Autowired
    private UserDetailsService userDetails;

    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Autowired
    private DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetails);
        authProvider.setPasswordEncoder(encoder);

        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception {
        
        http.csrf().disable().authenticationProvider(authProvider());

        http.authorizeRequests().antMatchers("/login").permitAll()
        .antMatchers("/users/**").hasAnyAuthority("USER_COMMON", "USER_PREMIUM", "USER_ARTIST")
        .anyRequest().authenticated().and().logout().permitAll();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer customizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**");
    }
    

}
