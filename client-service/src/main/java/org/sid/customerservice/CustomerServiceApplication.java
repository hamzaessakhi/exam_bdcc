package org.sid.customerservice;

import org.sid.customerservice.entities.Client;
import org.sid.customerservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository, RepositoryRestConfiguration repositoryRestConfiguration){
		repositoryRestConfiguration.exposeIdsFor(Client.class);
		return args -> {
			clientRepository.save(new Client(null ,"1","Yassine", "yassinefaiq98@gmail.com"));
			clientRepository.save(new Client(null,"2","ali", "ali@gmail.com"));
			clientRepository.save(new Client(null,"3","othmane", "othmane@gmail.com"));
			clientRepository.findAll().forEach(client -> {
				System.out.println(client.toString());
			});
		};
	}

}
