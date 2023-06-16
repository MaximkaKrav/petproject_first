package com.example.petproject.repository;


import com.example.petproject.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
    
}
