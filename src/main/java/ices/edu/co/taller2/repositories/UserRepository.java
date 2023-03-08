package ices.edu.co.taller2.repositories;

import ices.edu.co.taller2.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();

    //CRUD
    public void createUser(User user) throws Exception{
        //Tenemos que validar si el user ya existe
        if(users.contains(user)){
            throw new Exception("Usuario repetido");
        }else{
            users.add(user);
        }

    }

    public ArrayList<User> getAll(){
        return users;
    }

}
