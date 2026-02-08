package com.jwt.example.demo.Services;

import com.jwt.example.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(), "ayush singh" , "ayush.singh@gmail.com" ));
        store.add(new User(UUID.randomUUID().toString(), "piyush singh" , "piyush.singh@gmail.com" ));
        store.add(new User(UUID.randomUUID().toString(), "ujjwal singh" , "ujjwal.singh@gmail.com" ));
        store.add(new User(UUID.randomUUID().toString(), "prince pal" , "prince.pal@gmail.com" ));
    }

    public List<User> getUsers(){
        return store;
    }
}
