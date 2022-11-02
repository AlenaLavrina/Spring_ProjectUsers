package com.example.projectusers.services;

import com.example.projectusers.models.User;
import com.example.projectusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly=true)
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Данный метод позволяет вернуть всех пользователей
    public List<User> getAllUsers() {
        return userRepository.findAll(); //select *
    }
    //Данный метод позволяет вернуть пользователя по id
    public User getUserId(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null); //select * from user_site where id = переменная id
    }
    //Данный метод позволяет сохранить пользователя
    @Transactional
    public void save(User user){
        userRepository.save(user); //insert into user_site(last_Name, first_Name, patronymic, age, email, phone_number)
        // values('Иванов', 'Иван', 'Иванович', '31', 'ivanov@mail.ru', '81234567890')
    }
    //Данный метод позволяет обновить данные пользователя
    @Transactional
    public void update(int id, User user){
        user.setId(id);
        userRepository.save(user); //update user_site SET last_Name = user.last_Name where id = параметру id
    }

    //Данный метод позволяет удалить пользователя
    @Transactional
    public void delete(int id)
    {
        userRepository.deleteById(id); //delete from user_site where id = параметру id
    }
}
