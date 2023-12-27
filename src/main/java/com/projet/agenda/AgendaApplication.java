package com.projet.agenda;

import com.projet.agenda.dao.RoleDAO;
import com.projet.agenda.dao.UserDAO;
import com.projet.agenda.model.Role;
import com.projet.agenda.model.User;
import com.projet.agenda.repos.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendaApplication {


	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}


}
