package com.example.projectusers.DAO;

import com.example.projectusers.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private int id;
    private List<User> users;
    {
        users = new ArrayList<>();
    }

    //Добавление пользователей в List через модель
    public void addUser(User user_new){
        users.add(user_new);
        user_new.setId(++id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    //Добавление пользователя по id
    public User getUserID(int id){
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    //Редактирование информации о пользователях
    public void updateUser(int id, User user){
        User userUpdate = getUserID(id);
        userUpdate.setLast_Name(user.getLast_Name());
        userUpdate.setFirst_Name(user.getFirst_Name());
        userUpdate.setPatronymic(user.getPatronymic());
        userUpdate.setAge(user.getAge());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPhone_number(user.getPhone_number());
    }
    //Удаление пользователя из листа по id
    public void deleteUser(int id){
        users.removeIf(user -> user.getId() == id);
    }
}
