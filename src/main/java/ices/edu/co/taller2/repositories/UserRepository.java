package ices.edu.co.taller2.repositories;

import ices.edu.co.taller2.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();

    //CRUD
    public void createUser(User user) throws Exception{
        //UUID
        user.setId(UUID.randomUUID().toString());
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

    public User getUserByEmailAndPassword(String email, String pass) throws Exception{
        for(int i=0 ; i< users.size() ; i++){
            if(users.get(i).getEmail().equals(email) && users.get(i).getPass().equals(pass)){
                return users.get(i);
            }
        }
        throw new Exception("Email o contraseña no coinciden");
    }

    public void isUserInDb(String id) throws Exception{
        for(int i=0 ; i<users.size() ; i++){
            if(users.get(i).getId().equals(id)){
                return;
            }
        }
        throw new Exception("No está autorizado");
    }

    public void deleteUserById(String id) {
        for(int i=0 ; i<users.size() ; i++){
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return;
            }
        }
    }
}
