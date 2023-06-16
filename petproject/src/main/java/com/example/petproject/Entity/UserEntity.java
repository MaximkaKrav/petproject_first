package com.example.petproject.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    //mappedBy ссылается на TodoEntity в шаблоне UserEntity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")//если удаляем юзера, то и все дела его
    private List<TodoEntity> todos;

    public Long getId() {
        return id;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity(){

    }
}
