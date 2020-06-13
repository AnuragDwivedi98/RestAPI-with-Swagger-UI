package com.example.Java.App6;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    DB db = new DB();
    @GetMapping("/hi")
    public String sayHello()
    {
        return "Hello Geeks";

    }

    // http://localhost:8080/search?q=msd
    // http://localhost:8080/search?q=Sachin
    @GetMapping("/search")
    public String search(@RequestParam String q){
        return db.searchAWord(q);
    }

    //http://localhost:8080/users?name=Dhoni
    @GetMapping("/users")
    public List<User> findAllUsers(@RequestParam String name){
        return db.searchUsersByUserName(name);
    }

    // http://localhost:8080/users/3
    @GetMapping("/users/{id}")
    public User findAUser(@PathVariable int id){
        return db.searchAUserByUserId(id);
    }
    // http://localhost:8080/users/all
    @GetMapping("/users/all")
    public List<User> findAllUsers(){
        return db.getAllUsers();
    }

    @PostMapping("/users")
    public boolean createAUser(@RequestBody User user){
        return db.addAUser(user);

    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){
        return db.deleteAUser(id);
    }

    @PutMapping("/users")
    public boolean updateAUser(@RequestBody User user){
        return db.updateAUser(user);
    }


}
