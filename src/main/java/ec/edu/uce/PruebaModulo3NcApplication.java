package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaModulo3NcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(PruebaModulo3NcApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaModulo3NcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
