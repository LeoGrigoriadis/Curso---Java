package mvc.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,
jsr250Enabled = true)
public class SecurityConfig {
    
    @Bean
    public UserDetailsService UserDetailService(BCryptPasswordEncoder bcrypt){

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        
        manager.createUser(User.withUsername("user").password(bcrypt.encode("password")
        ).roles("COMMON_USER").build());

        return manager;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bcrypt, UserDetailsService userDetails) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userDetails).passwordEncoder(bcrypt).and().build();
    }

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .formLogin().loginPage("/login.html")
        .and().logout().logoutSuccessUrl("/logout.html")
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .antMatchers("/login/**").anonymous()
        .anyRequest().authenticated().and().httpBasic().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/img/**",
        "/lib/**", "/favicon/**");
    }
}
