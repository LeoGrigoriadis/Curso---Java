package clase12.clase_12.Configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import clase12.clase_12.Models.User;
import clase12.clase_12.Repositories.UserRepository;

@Configuration
public class JwtUserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario = usuarioRepo.getByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("El usuario no exite");
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER_BASIC"));
            return new JwtUser(usuario.getUsername(), usuario.getPassword(), authorities);
        }
    }
    
}
