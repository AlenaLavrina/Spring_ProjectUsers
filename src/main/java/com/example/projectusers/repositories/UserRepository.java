package com.example.projectusers.repositories;

import com.example.projectusers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Запрос на получение пользователей по email
    List<User> findByEmail(String email);

    //Запрос на получение пользователей по номеру телефона
    List<User> findByPhoneNumber(String phone_number);

    //Запрос на получение пользователей по фамилии и сортировка по возрасту
    List<User> findByLastNameOrderByAge(String last_name);

    //Запрос на получение пользователей по фамилии, начинающейся с определенной последовательности
    List<User> findByLastNameStartingWith(String starting_with);
}
