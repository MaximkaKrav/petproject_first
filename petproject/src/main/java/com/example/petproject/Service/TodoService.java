package com.example.petproject.Service;

import com.example.petproject.Entity.TodoEntity;
import com.example.petproject.Entity.UserEntity;
import com.example.petproject.model.Todo;
import com.example.petproject.repository.TodoRepo;
import com.example.petproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));

    }

    public Todo completeTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setComplited(!todo.getComplited());
        return Todo.toModel(todoRepo.save(todo));


    }

}
