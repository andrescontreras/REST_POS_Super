package co.edu.javeriana.myapp.server.myappserver.service;
import co.edu.javeriana.myapp.server.myappserver.model.User;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api")
public class TestService {
	@RequestMapping(value = "/test", produces = "application/json")
	public String test() {
		return "{\"value\": \"ok\"}";
	}
    
    @PreAuthorize("hasRole('ROLE_ADMIN')") // TODO ver http://www.baeldung.com/spring-security-expressions-basic
	@RequestMapping(value = "/restricted-method", produces = "application/json")
    public String restrictedMethod() {
        return "{\"value\": \"ok admin\"}";
    }

    @RequestMapping(value = "/current-user", produces="application/json")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
		System.out.println("Metodo en TestService, metodo currentUserName");
        User user = (User) authentication.getPrincipal();
        System.out.println("En TestService "+user.toString());
        System.out.println("Rol "+ user.getTipo());
        //return user.getTipo();
        //return user.getAuthorities();
        String xd = "{\"rol\": \""+user.getTipo()+"\"}";
        System.out.println(xd);
        System.out.println("{\"value\": \"ok admin\"}");
        return "{\"rol\": \""+user.getTipo()+"\"}";
    }
    /*
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    */
	
}
