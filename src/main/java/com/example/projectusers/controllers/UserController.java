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
        model.addAttribute("edit_user", userService.getUserId(id));
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
    public String editUser(@ModelAttribute("edit_user") @Valid User user, BindingResult bindingResult, @PathVariable(
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
}
