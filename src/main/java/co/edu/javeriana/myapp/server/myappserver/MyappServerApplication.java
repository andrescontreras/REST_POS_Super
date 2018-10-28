package co.edu.javeriana.myapp.server.myappserver;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

import antlr.collections.List;
import co.edu.javeriana.myapp.server.myappserver.model.Cliente;
import co.edu.javeriana.myapp.server.myappserver.model.ClienteRepository;
import co.edu.javeriana.myapp.server.myappserver.model.Compra;
import co.edu.javeriana.myapp.server.myappserver.model.CompraRepository;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoCom;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoComRepository;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoInv;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoInvRepository;
import co.edu.javeriana.myapp.server.myappserver.model.Usuario;
import co.edu.javeriana.myapp.server.myappserver.model.UsuarioRepository;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class MyappServerApplication implements CommandLineRunner {

	@Autowired
	private ProductoInvRepository productoInvRepository;

	@Autowired
	private ProductoComRepository productoComRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyappServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productoInvRepository.deleteAll();
		productoComRepository.deleteAll();
		compraRepository.deleteAll();
		clienteRepository.deleteAll();
		usuarioRepository.deleteAll();

		Compra compra;
		ProductoInv productoI;
		ProductoCom productoC;
		Cliente cliente;
		Usuario usuario;
		
		ArrayList<ProductoCom> comprados = new ArrayList<ProductoCom>();

		productoI = new ProductoInv(30,"fd33","Pera", 1500, "4");
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(30,"fd34","Manzana", 1600, "4");
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(25,"fd35","Uvas", 3200, "4");
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(30,"fd36","Granadilla", 1900, "4");
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(28,"fd37","Pitalla", 2500, "4");
		productoInvRepository.save(productoI);
		productoI = new ProductoInv(30,"fd38","Naranja", 1200, "4");
		productoInvRepository.save(productoI);

		cliente = new Cliente(4361879, "Andres");
		clienteRepository.save(cliente);
		compra = new Compra("17-07-2018", 1200, cliente);
		compraRepository.save(compra);
		productoC = new ProductoCom(2,"fd35","Uva",6400,"4",compra);
		productoComRepository.save(productoC);
		productoC = new ProductoCom(3,"fd36","Granadilla",3800,"4",compra);
		productoComRepository.save(productoC);
		//---------------------------------------------------------------
		compra = new Compra("19-07-2018", 3200,cliente);
		compraRepository.save(compra);
		productoC = new ProductoCom(2,"fd34","Manzana",3200,"4",compra);
		productoComRepository.save(productoC);
		//---------------------------------------------------------------
		compra = new Compra("25-07-2018", 5300,cliente);
		compraRepository.save(compra);
		productoC = new ProductoCom(2,"fd37","Pitalla",5000,"4",compra);
		productoComRepository.save(productoC);
		

		cliente = new Cliente (46189,"Pablo");
		clienteRepository.save(cliente);

		cliente = new Cliente (2345678,"Pedro");
		clienteRepository.save(cliente);
		compra = new Compra("20-08-2018", 1500,cliente);
		compraRepository.save(compra);
		

		cliente = new Cliente (98765,"Lucas");
		clienteRepository.save(cliente);
		compra = new Compra("17-07-2018", 7200,cliente);
		compraRepository.save(compra);
		compra = new Compra("17-08-2018", 5200,cliente);
		compraRepository.save(compra);
		
	}
}
