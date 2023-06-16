package com.example.petproject.Controller;

import com.example.petproject.Entity.TodoEntity;
import com.example.petproject.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId){

        try {
            return ResponseEntity.ok(todoService.createTodo(todo,userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(todoService.completeTodo(id));

        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");

        }
    }
}
