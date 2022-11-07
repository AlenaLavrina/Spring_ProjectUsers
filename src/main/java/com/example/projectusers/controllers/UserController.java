package com.example.projectusers.controllers;


import com.example.projectusers.DAO.UserDAO;
import com.example.projectusers.models.User;
import com.example.projectusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Метод по открытию страницы с пользователями
    @GetMapping("/user")
    public String index(Model model) {
//        model.addAttribute("getUsers", userDAO.getUsers());
        model.addAttribute("getUsers", userService.getAllUsers());
        return "index";
    }

    //Метод по отправке информации о конкретном пользователе в шаблон
    @GetMapping("/user/{id}")
    public String infoUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("infoUser", userDAO.getUserID(id));
        model.addAttribute("infoUser", userService.getUserId(id));
        return "infoUser";
    }

    //Метод по нажатию на ссылку редактирования и отправление объекта пользователя в шаблон
    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
//        model.addAttribute("editUser", userDAO.getUserID(id));
        model.addAttribute("editUser", userService.getUserId(id));
        return "editUser";
    }

    //Метод по нажатию на ссылку удаления и удаление пользователя по id
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
//        userDAO.deleteUser(id);
        userService.delete(id);
        return "redirect:/user";
    }

    //Метод по открытию страницы добавления пользователей и передачи объекта
    @GetMapping("/add/user")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    //Метод по добавлению пользователя через объект с формы в лист
    @PostMapping("/add/user")
    public String newUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
//        userDAO.addUser(user);
        userService.save(user);
        return "redirect:/user";
    }

    @PostMapping("/edit/user/{id}")
    public String editUser(@ModelAttribute("editUser") @Valid User user, BindingResult bindingResult, @PathVariable(
            "id") int id) {
         {
            if (bindingResult.hasErrors()) {
                return "editUser";
            }
//             userDAO.updateUser(id, user);
             userService.update(id, user);
            return "redirect:/user";
        }
    }

    //Метод по отражению страницы с сортировкой и поиском
    @GetMapping("/sortingandsearching/user")
    public String sorting_and_searching(){
        return "sorting_and_searching";
    }

    @PostMapping("/sortingandserching/user")
    public String sorting_and_searching(@RequestParam("SortingOrFilteringOptions") String SortingOrFilteringOptions, @RequestParam("option_sort_or_search") String option_sort_or_search, Model model) {
        if (SortingOrFilteringOptions.equals("email")) {
            model.addAttribute("sort_user",userService.getUserEmail(option_sort_or_search));
        } else if (SortingOrFilteringOptions.equals("phone_number")) {
            model.addAttribute("sort_user",userService.getUserPhoneNumber(option_sort_or_search));
        } else if (SortingOrFilteringOptions.equals("last_name_and_sort_age")) {
            model.addAttribute("sort_user",userService.getUserLastNameOrderByAge(option_sort_or_search));
        } else if (SortingOrFilteringOptions.equals("last_name_start")) {
            model.addAttribute("sort_user",userService.getUserLastNameStartWith(option_sort_or_search));
        }
        return "sorting_and_searching";
    }

    @GetMapping("/get")
    public void text(){
        for (User user: userService.test("Иванов")
             ) {
            System.out.println("Пользователь №: " + user.getId());
            System.out.println("Фамилия: " + user.getLastName());
            System.out.println("Имя: " + user.getFirstName());
            System.out.println("Отчество: " + user.getPatronymic());
            System.out.println("Возраст: " + user.getAge());
            System.out.println("E-mail: " + user.getEmail());
            System.out.println("Номер телефона: " + user.getPhoneNumber());
            System.out.println();
        }
    }
}
