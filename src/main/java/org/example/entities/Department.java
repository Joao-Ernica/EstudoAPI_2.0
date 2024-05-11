package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "tb_Department")
public class Department implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String name;

	@OneToMany(mappedBy = "department") // garante que todos os usuários associados sejam incluidos na requisição web
	@JsonIgnore // Evita o loop
	private Set<User> user = new HashSet<>();

	public Department(String name, Long id) {
		this.name = name;
		this.id = id;
	}
}
