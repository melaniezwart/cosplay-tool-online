package nl.cto.hello;

import nl.cto.entities.CtoUser;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;


/**
 * Created by mzwart on 8-12-2016.
 */
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}
	/*@Bean
	public CommandLineRunner demo(CtoUserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new CtoUser("Jack", "Bauer"));
			repository.save(new CtoUser("Chloe", "O'Brian"));
			repository.save(new CtoUser("Kim", "Bauer"));
			repository.save(new CtoUser("David", "Palmer"));
			repository.save(new CtoUser("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (CtoUser customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			CtoUser customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (CtoUser bauer : repository.findByUsername("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}*/
}
