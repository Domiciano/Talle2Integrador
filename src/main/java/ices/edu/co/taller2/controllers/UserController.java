package ices.edu.co.taller2.controllers;

import ices.edu.co.taller2.model.User;
import ices.edu.co.taller2.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//REST API
@RestController
public class UserController {

    private UserRepository repository = new UserRepository();

    @PostMapping(value = "users/create",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Object> create(@RequestBody User user){
        try {
            repository.createUser(user);
            return ResponseEntity.status(200).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }

    }

    @GetMapping(value = "users/all", produces = "application/json")
    public ArrayList<User> getAll(){
        return repository.getAll();
    }


}
