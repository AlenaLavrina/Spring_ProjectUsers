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

    //Данный метод позволяет получить пользователя по email адресу
    public List<User> getUserEmail(String email) {
        List<User> users = userRepository.findByEmail(email);
        return users;
    }

    //Данный метод позволяет получить пользователя по номеру телефона
    public List<User> getUserPhoneNumber(String phone_number){
        List<User> users = userRepository.findByPhoneNumber(phone_number);
        return users;
    }

    //Данный метод позволяет получить пользователей по фамилии и отсортировать по возрасту
    public List<User> getUserLastNameOrderByAge(String lastName){
        List<User> users = userRepository.findByLastNameOrderByAge(lastName);
        return users;
    }


    //Данный метод позволяет получить пользователей по фамилии, где фамилия начинается с определенных символов
    public List<User> getUserLastNameStartWith(String starting_with){
        List<User> users = userRepository.findByLastNameStartingWith(starting_with);
        return users;
    }

    public List<User> test(String last_name){
        List<User> users = userRepository.findByLastNameOrderByAgeAsv(last_name);
                return users;
    }

}
