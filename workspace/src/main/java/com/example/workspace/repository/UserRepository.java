package com.example.workspace.repository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workspace.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Integer>
{
    // @Query(value="select * from UserDetails where age<20")
     List<UserDetails> findByAge(int age);
}
