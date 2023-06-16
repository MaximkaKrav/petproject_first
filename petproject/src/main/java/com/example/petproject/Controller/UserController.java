package com.example.petproject.Controller;

import com.example.petproject.Entity.UserEntity;
import com.example.petproject.Exeption.UserAlreadyExist;
import com.example.petproject.Exeption.UserNotFind;
import com.example.petproject.Service.UserService;
import com.example.petproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registratoin(user);
            return ResponseEntity.ok("Пользователь зарегистирован");
        } catch (UserAlreadyExist e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Такой уже есть");
        }
    }




    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok().body(userService.getOne(id));
        }catch (UserNotFind e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(userService.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }


}
