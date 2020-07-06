package com.example.code.controller;

import com.example.code.entity.User;
import com.example.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/index")
    public String index(Model model){

        model.addAttribute("user",new User());
        return "userIndex";
    }

    @PostMapping("/user/insert")
    public String insert(@ModelAttribute("user") User user){
        if(user.getUsername() == "" || user.getCha() == "" || user.getPwd() == ""){
            return "InsertWrong";
        }
        userService.insert(user);
        return "redirect:/user/getAllUser";
    }

    @GetMapping("/user/getAllUser")
    public String getAllUser(Model model){
        model.addAttribute("userList",userService.getAllUser());
        return "userList";
    }


    @GetMapping("/user/delete")
    public String deleteByIdTwo(@RequestParam("id") Integer id){
        userService.deleteById(id);
        return "redirect:/user/getAllUser";
    }

    @GetMapping("/user/update")
    public String updateUser(@RequestParam("id") Integer id, Model model){
        model.addAttribute("user",userService.getUserById(id));

        return "userIndex";
    }
}
