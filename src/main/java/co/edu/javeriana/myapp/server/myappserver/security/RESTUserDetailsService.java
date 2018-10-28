package co.edu.javeriana.myapp.server.myappserver.security;

import co.edu.javeriana.myapp.server.myappserver.model.User;
import co.edu.javeriana.myapp.server.myappserver.model.Usuario;
import co.edu.javeriana.myapp.server.myappserver.model.UsuarioRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class RESTUserDetailsService implements UserDetailsService {
	Map<String, User> users = new HashMap<>();
	private UsuarioRepository usuarioRepository;
	public RESTUserDetailsService() {
		super();
		
		users.put("user", new User("user", "password", "USER","ROLE_BODEGUERO"));
		users.put("admin", new User("admin", "password","ADMIN" ,"ROLE_BODEGUERO"));
		users.put("cajero", new User("cajero", "password", "CAJERO","ROLE_CAJERO"));
		users.put("bodeguero", new User("bodeguero", "password", "CAJERO","ROLE_BODEGUERO"));
	}
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO En este método debería recuperarlse la info del usuario desde la base de datos
		System.out.println("*** Retrieving user");
		System.out.println("El usuario que va a logearse es "+username);
		String rol="";
		if(users.get(username)==null) {
			Usuario usu = usuarioRepository.findByUsuario(username);
			if(usu!=null) {
				if(usu.getTipo().equals("CAJERO"))
					rol="ROLE_CAJERO";
				else
					rol="ROLE_BODEGUERO";
				users.put(username, new User(username,usu.getPassword(),usu.getTipo(),rol));
			}
		}
		return users.get(username);
	}	

}
