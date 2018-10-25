package co.edu.javeriana.myapp.server.myappserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

import co.edu.javeriana.myapp.server.myappserver.model.ClienteRepository;
import co.edu.javeriana.myapp.server.myappserver.model.CompraRepository;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoComRepository;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoInv;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoInvRepository;
import co.edu.javeriana.myapp.server.myappserver.model.UsuarioRepository;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class MyappServerApplication implements CommandLineRunner {

	@Autowired
	private ProductoInvRepository productoInvRepository;

	/*@Autowired
	private ProductoComRepository productoComRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	*/
	public static void main(String[] args) {
		SpringApplication.run(MyappServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productoInvRepository.deleteAll();
		ProductoInv productoI = new ProductoInv(30,"fd33","Pera", 1500, 4);
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(30,"fd34","Manzana", 1600, 4);
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(25,"fd35","Uvas", 3200, 4);
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(30,"fd36","Granadilla", 1900, 4);
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(28,"fd37","Pitalla", 2500, 4);
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(30,"fd38","Naranja", 1200, 4);
		productoInvRepository.save(productoI);
	}
}
