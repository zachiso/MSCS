package com.example.code.controller;

import com.example.code.entity.Staff;
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
    public String insert(@RequestParam("na") String na,
                         @RequestParam("pwd") String pwd,
                         @RequestParam("cha") String cha){
        User user = new User();
        user.setUsername(na);
        user.setPwd(pwd);
        user.setCha(cha);
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

    @RequestMapping("/user/log")
    public String log(@RequestParam("username") String name,@RequestParam("pwd") String pwd
    ) {
        User user = new User();
        user = null;
        user = userService.getUser(name, pwd);
        if (user == null) {
            return "LogWrong";
        } else {
            if ("admin".equals(user.getCha())) {
                return "admin";
            } else if ("user".equals(user.getCha())) {
                return "desk";
            } else if ("manager".equals(user.getCha())) {
                return "manager";
            }else{
                return "0";
            }

        }
    }
}
