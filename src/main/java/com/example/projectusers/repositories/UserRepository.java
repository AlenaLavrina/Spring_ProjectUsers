package com.example.projectusers.repositories;

import com.example.projectusers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Запрос на получение пользователей по email
    List<User> findByEmail(String email);

    //Запрос на получение пользователей по номеру телефона
    List<User> findByPhoneNumber(String phoneNumber);

    //Запрос на получение пользователей по фамилии и сортировка по возрасту
    List<User> findByLastNameOrderByAge(String lastName);

    //Запрос на получение пользователей по фамилии, начинающейся с определенной последовательности
    List<User> findByLastNameStartingWith(String starting_with);


    @Query(value="select * from user_site where user_site .last_name=?1 order by age asc", nativeQuery = true)
    List<User> findByLastNameOrderByAgeAsv(String last_name);
}
