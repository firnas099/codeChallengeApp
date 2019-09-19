package com.firnas.codechallange.Service;

import com.firnas.codechallange.Userrepo;
import com.firnas.codechallange.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private Userrepo userrepo;

    public  UserService(Userrepo userrepo){

        this.userrepo=userrepo;
    }

    public  Iterable<Users> save(List<Users> users){
            return userrepo.saveAll(users);
    }

       public  Users save(Users users){

        return userrepo.save(users);
       }

}
