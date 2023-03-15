package ices.edu.co.taller2.controllers;

import ices.edu.co.taller2.model.StatusInfo;
import ices.edu.co.taller2.model.User;
import ices.edu.co.taller2.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//REST API
@RestController
public class UserController {

    private UserRepository repository = new UserRepository();

    @PostMapping(value = "users/create",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Object> create(@RequestBody User user) {
        try {
            repository.createUser(user);
            return ResponseEntity.status(200)
                    .body(new StatusInfo(200, "Usuario creado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(409)
                    .body(new StatusInfo(409, "Usuario repetido en la base de datos"));
        }
    }

    @PostMapping(value = "login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> login(@RequestBody User user){
        try{
            User dbuser = repository.getUserByEmailAndPassword(user.getEmail(), user.getPass());
            return ResponseEntity.status(200).body(dbuser);
        }catch (Exception ex){
            return ResponseEntity.status(401)
                    .body(new StatusInfo(401, ex.getMessage()));
        }
    }


    @GetMapping(value = "users/all", produces = "application/json")
    public ResponseEntity<Object> getAll(@RequestHeader("Authorization") String auth) {
        try {
            repository.isUserInDb(auth);
            return ResponseEntity
                    .status(200)
                    .body(repository.getAll());
        }catch (Exception ex){
            return ResponseEntity
                    .status(401)
                    .body(new StatusInfo(401, ex.getMessage()));
        }
    }

    @DeleteMapping(value = "users/delete", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> deleteUser(@RequestHeader("Authorization") String auth, @RequestBody User user){
        try {
            repository.isUserInDb(auth);
            repository.deleteUserById(user.getId());
            return ResponseEntity
                    .status(200)
                    .body(new StatusInfo(200, "El usuario fue eliminado"));
        }catch (Exception ex){
            return ResponseEntity
                    .status(401)
                    .body(new StatusInfo(401, "No esta autorizado para eliminar"));
        }
    }



}
