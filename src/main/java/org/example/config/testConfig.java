package org.example.config;

import lombok.SneakyThrows;
import org.example.entities.Department;
import org.example.entities.User;
import org.example.repositories.DepartmentRepository;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration // falar que é uma classe de configuração
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	@SneakyThrows // ocultar exceções verificadas
	public void run(String... args) /*throws Exception*/ { // sem a anotação SneakyThrows

		//Department

		var dep1 = Department.builder()
				.id(null)
				.name("Gestão")
				.build();

		var dep2 = Department.builder()
				.id(null)
				.name("Informatica")
				.build();

		//User

		var u1 = User.builder()
				.id(null)
				.name("Maria")
				.email("maria@gmail.com")
				.department(dep1)
				.build();

		var u2 = User.builder()
				.id(null)
				.name("Bob")
				.email("bob@gmail.com")
				.department(dep2)
				.build();

		var u3 = User.builder()
				.id(null)
				.name("Alex")
				.email("alex@gmail.com")
				.department(dep1)
				.build();

		var u4 = User.builder()
				.id(null)
				.name("Ana")
				.email("ana@gmail.com")
				.department(dep2)
				.build();

		departmentRepository.saveAll(Arrays.asList(dep1, dep2));
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
	}
}
