package com.example.petproject.Service;

import com.example.petproject.Entity.UserEntity;
import com.example.petproject.Exeption.UserAlreadyExist;
import com.example.petproject.Exeption.UserNotFind;
import com.example.petproject.model.User;
import com.example.petproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registratoin(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExist("Пользователь с таким именем существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFind {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new  UserNotFind("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
