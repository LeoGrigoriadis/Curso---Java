package clase12.clase_12.Controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import clase12.clase_12.Configuration.JwtTokenUtils;
import clase12.clase_12.Configuration.JwtUserDetailsServiceImpl;
import clase12.clase_12.Models.User;
import clase12.clase_12.Models.UserType;
import clase12.clase_12.Repositories.UserTypeRepository;

@RestController
@RequestMapping("/auth")
public class LoginController {
    
    @Autowired
    private JwtTokenUtils tokenUtils;
    @Autowired
    private JwtUserDetailsServiceImpl JwtUserService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired 
    private UserTypeRepository userTypeRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) throws UnsupportedEncodingException{
        HashMap<String, Object> responseMap = new HashMap<>();
        try{
            Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            if(auth.isAuthenticated()){
                UserDetails userDetails = JwtUserService.loadUserByUsername(username);
                String token = tokenUtils.generateToken(userDetails);
                responseMap.put("error", false);
                responseMap.put("mensaje", "logueado correctamente");
                responseMap.put("token", token);
                return ResponseEntity.status(HttpStatus.OK).body(responseMap);
            } else {
                responseMap.put("error", true);
                responseMap.put("mensaje", "credenciales invalidas");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
                
            }
        } catch(BadCredentialsException e){
            responseMap.put("error", true);
            responseMap.put("mensaje", "credenciales invalidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
        } catch(DisabledException e){
            responseMap.put("error", true);
            responseMap.put("mensaje", "usuario no habilitado");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        } catch(Exception e){
            responseMap.put("error", true);
            responseMap.put("mensaje", "Ha ocurrido un error inesperado en la transacción");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam("username") String username, @RequestParam("password") String password) throws UnsupportedEncodingException{
        HashMap<String, Object> responseMap = new HashMap<>();
        try{
            Optional<UserType> userType = userTypeRepo.findById(1L);
            String passEncripted = new BCryptPasswordEncoder().encode(password);
            User user = new User(username, passEncripted, userType.get());
            UserDetails userDetails = JwtUserService.loadUserByUsername(username);
            String token = tokenUtils.generateToken(userDetails);
            // TODO userService.register(user);
            responseMap.put("error", false);
            responseMap.put("mensaje", "logueado correctamente");
            responseMap.put("token", token);
            responseMap.put("user", user);
            return ResponseEntity.status(HttpStatus.OK).body(responseMap); 
        } catch(BadCredentialsException e){
            responseMap.put("error", true);
            responseMap.put("mensaje", "credenciales invalidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
        } catch(DisabledException e){
            responseMap.put("error", true);
            responseMap.put("mensaje", "usuario no habilitado");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        } catch(Exception e){
            responseMap.put("error", true);
            responseMap.put("mensaje", "Ha ocurrido un error inesperado en la transacción");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }
}
