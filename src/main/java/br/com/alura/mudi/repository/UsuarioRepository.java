package br.com.alura.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mudi.modelo.User;

@Repository
public interface UsuarioRepository extends JpaRepository<User, String>{
	User findByUsername(String username);

}
