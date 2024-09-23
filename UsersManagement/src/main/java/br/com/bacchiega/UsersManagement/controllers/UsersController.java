package br.com.bacchiega.UsersManagement.controllers;

import br.com.bacchiega.UsersManagement.model.entities.Users;
import br.com.bacchiega.UsersManagement.model.repositories.UsersRepository;
import br.com.bacchiega.UsersManagement.model.repositories.UsersRespositoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/users")
public class UsersController {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
   private UsersRespositoryPage usersRespositoryPage;

    @GetMapping(path = "/{numPages}")
    public Iterable<Users> getUsersPage(@PathVariable int numPages){
        Pageable page = PageRequest.of(numPages, 5);
        return usersRespositoryPage.findAll(page);
    }

    @GetMapping(path = "/user/id/{id}")
    public Optional<Users> getById(@PathVariable int id){
        return usersRepository.findById(id);
    }

    @GetMapping(path = "/user/name/{name}")
    public List<Users> getByName(@PathVariable String name){
        return usersRepository.findByName(name);
    }

    @PostMapping
    public Users newUser(Users user){
        usersRepository.save(user);
        return user;
    }

    @PutMapping
    public Users userUpdate(Users user){
        usersRepository.save(user);
        return user;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUsers(@PathVariable int id){
        usersRepository.deleteById(id);
    }
}
