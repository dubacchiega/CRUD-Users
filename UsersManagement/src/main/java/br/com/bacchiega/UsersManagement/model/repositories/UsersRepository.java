package br.com.bacchiega.UsersManagement.model.repositories;

import br.com.bacchiega.UsersManagement.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsersRepository extends JpaRepository<Users, Integer> {

    public List<Users> findByName(String name);
}
