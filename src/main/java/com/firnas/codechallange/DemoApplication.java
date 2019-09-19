package com.firnas.codechallange;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.firnas.codechallange.Service.OrgService;
import com.firnas.codechallange.Service.UserService;
import com.firnas.codechallange.Service.ticketService;
import com.firnas.codechallange.model.Organizations;
import com.firnas.codechallange.model.Tickets;
import com.firnas.codechallange.model.Users;


import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}





	@Bean
	CommandLineRunner runner(UserService userService, ticketService ticketService, OrgService orgService){


		return args -> {

			ObjectMapper objectMapper=new ObjectMapper();
			TypeReference<List<Users>>  typeReference=new TypeReference<List<Users>>(){};
			TypeReference<List<Tickets>>  typeReference1=new TypeReference<List<Tickets>>(){};
			TypeReference<List<Organizations>>  typeReference2=new TypeReference<List<Organizations>>(){};

			InputStream inputStream= TypeReference.class.getResourceAsStream("/json/users.json");
			InputStream inputStream1=TypeReference.class.getResourceAsStream("/json/tickets.json");
			InputStream inputStream2=TypeReference.class.getResourceAsStream("/json/organizations.json");

		try {
				List<Users>users=objectMapper.readValue(inputStream,typeReference);
			    userService.save(users);

				List<Tickets>tickets=objectMapper.readValue(inputStream1,typeReference1);


				ticketService.save(tickets);

			List<Organizations>organizations=objectMapper.readValue(inputStream2,typeReference2);
			orgService.save(organizations);


				System.out.println("data save");
			}catch (IOException e){

				System.out.println("not save" +e.getMessage());
		}



		};
	}
}
