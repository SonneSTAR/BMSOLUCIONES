package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import com.sun.jdi.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/bmsoluciones")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        try{
            boolean email_validate = userService.validate(user.getEmail());
            if (email_validate) {
                userService.addNewUser(user);
                return new ResponseEntity<>(user, HttpStatus.OK);
            }else{
                user.setEmail("ERROR - El email no es válido");
                return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

    };

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User user){
        try{
            userService.updateUser(id,user);
            user.setId(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    };

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id, @RequestBody User user){
        try{
            userService.deleteUser(id,user);
            user.setId(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    };

    @PutMapping(value = "isActive/{id}")
    public ResponseEntity<User> changeIsActive(@PathVariable Integer id, @RequestBody User user){
        try{
            userService.changeIsActive(id,user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    };


}
