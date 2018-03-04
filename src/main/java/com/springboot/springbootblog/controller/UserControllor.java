package com.springboot.springbootblog.controller;

import com.springboot.springbootblog.domain.User;
import com.springboot.springbootblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserControllor {

    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ModelAndView listUsers(Model model){
        model.addAttribute("userList",userRepository.getListUsers());
        model.addAttribute("title","User Manage");
        return new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","view user");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","create user");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user , Model model){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:users");
    }


    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteUser(id);

        model.addAttribute("userList", userRepository.getListUsers());
        model.addAttribute("title", "deleteUser");
        return new ModelAndView("users/list", "userModel", model);
    }


    @GetMapping(value = "/modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "modify user");
        return new ModelAndView("users/form", "userModel", model);
    }
}
