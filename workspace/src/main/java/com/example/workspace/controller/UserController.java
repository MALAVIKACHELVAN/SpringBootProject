package com.example.workspace.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.workspace.model.UserDetails;
import com.example.workspace.service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class  UserController {
     private UserService userService;
     public UserController(UserService u)
     {
        userService=u;
     }
     @PostMapping("/userdetails")
     public ResponseEntity<UserDetails> userController(@RequestBody UserDetails u)
     {
        UserDetails u1= userService.saveUserDetails(u);
        if(u1==null)
        {
         return new ResponseEntity<>(u1,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(u1,HttpStatus.CREATED);
     }

     @GetMapping("/Alluserdetails")
     public ResponseEntity<List<UserDetails>> getMethodName() {
         List<UserDetails>list= userService.getDetails();
         if(list.isEmpty())
         {
            return new ResponseEntity<>(list,HttpStatus.INTERNAL_SERVER_ERROR);
         }
         else{
            return new ResponseEntity<>(list,HttpStatus.OK);
         }
     }
     
     @DeleteMapping("/delete/{id}")
     public void deleted(@PathVariable int id)
     {
       userService.delete(id);
     }

     @PutMapping("update/{id}")
     public UserDetails putMethodName(@PathVariable int id, @RequestBody UserDetails userDetails ) {
       
        return userService.updateDetails(id,userDetails);
     }

     @GetMapping("/FindByAge")
     public List<UserDetails> getMethodName(@RequestParam int age) {
         return userService.getUserDetailsByAge(age);
     }
     
     

}
