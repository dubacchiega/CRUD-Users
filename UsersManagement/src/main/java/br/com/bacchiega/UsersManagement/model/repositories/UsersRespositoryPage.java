package br.com.bacchiega.UsersManagement.model.repositories;

import br.com.bacchiega.UsersManagement.model.entities.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRespositoryPage extends PagingAndSortingRepository<Users, Integer> {
}
