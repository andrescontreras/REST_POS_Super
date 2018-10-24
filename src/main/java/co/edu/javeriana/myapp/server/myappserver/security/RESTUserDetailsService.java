package co.edu.javeriana.myapp.server.myappserver.security;

import co.edu.javeriana.myapp.server.myappserver.model.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class RESTUserDetailsService implements UserDetailsService {
	Map<String, User> users = new HashMap<>();

	public RESTUserDetailsService() {
		super();
		users.put("user", new User("user", "password", "USER","ROLE_USER"));
		users.put("admin", new User("admin", "password","ADMIN" ,"ROLE_ADMIN"));
		users.put("cajero", new User("cajero", "password", "CAJERO","ROLE_CAJERO"));
	}
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO En este método debería recuperarlse la info del usuario desde la base de datos
		
		System.out.println("*** Retrieving user");
		return users.get(username);
	}	

}
