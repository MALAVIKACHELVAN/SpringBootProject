package com.example.workspace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.workspace.model.UserDetails;
import com.example.workspace.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository u)
    {
        userRepository =u;
    }
    public UserDetails saveUserDetails(UserDetails udetails)
    {
        if(udetails!=null)
        {
            return userRepository.save(udetails);
        }
        else{
               throw new IllegalArgumentException("UserDetails cannot be null");
        }
    }
    public List<UserDetails> getDetails(){
        return userRepository.findAll();
    }
    public void delete(int id)
    {
        userRepository.deleteById(id);
    }
    public UserDetails updateDetails(int id,UserDetails userDetails)
    {
        UserDetails existingUserDetails = userRepository.findById(id).orElse(null);
        if(existingUserDetails!=null)
        {
            existingUserDetails.setName(userDetails.getName());
            existingUserDetails.setAge(userDetails.getAge());
            existingUserDetails.setGender(userDetails.getGender());
            existingUserDetails.setPhone(userDetails.getPhone());
            return userRepository.save(existingUserDetails);
        }
        else{
            throw new IllegalArgumentException("UserDetails not found with the given id");
        }
    }
    public List<UserDetails> getUserDetailsByAge(int age) {
        return userRepository.findByAge(age);
    }
    
}
