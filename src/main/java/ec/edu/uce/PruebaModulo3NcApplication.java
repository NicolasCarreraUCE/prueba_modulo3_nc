package ec.edu.uce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Producto;
import ec.edu.uce.service.IGestorSupermercadoServi;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

@SpringBootApplication
public class PruebaModulo3NcApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(PruebaModulo3NcApplication.class);
	
	@Autowired
	private IGestorSupermercadoServi gestorSupermercadoServi;
	public static void main(String[] args) {
		SpringApplication.run(PruebaModulo3NcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Producto p1 = new Producto();
		p1.setCodigoDeBarras("12345");
		p1.setNombre("CocaCola");
		p1.setCategoria("Bevidas");
		p1.setPrecio(new BigDecimal("1.5"));
		
		this.gestorSupermercadoServi.ingresarProductos(p1, 100);
		this.gestorSupermercadoServi.ingresarProductos(p1, 50);
		
		Producto p2 = new Producto();
		p2.setCodigoDeBarras("54321");
		p2.setNombre("Pepsi");
		p2.setCategoria("Bevidas");
		p2.setPrecio(new BigDecimal("1.75"));
		
		this.gestorSupermercadoServi.ingresarProductos(p2, 80);
		this.gestorSupermercadoServi.ingresarProductos(p2, 90);
		
	}

}
