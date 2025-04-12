package ru.kolotov.springMvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kolotov.springMvc.Dao.UserDao;
import ru.kolotov.springMvc.models.User;

@Controller
@RequestMapping("/user")
public class UsersController {

    private UserDao userDao;

    @Autowired
    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.index());
        return "user/index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userDao.getUserById(id));
        return "user/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {

        userDao.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("user", userDao.getUserById(id));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id){

        userDao.update(id, user);
        return "redirect:/user";
    }

    @PostMapping("/")
    public String delete(@RequestParam("id") int id, Model model){
        userDao.deleteById(id);
        return "redirect:/user";
    }
}
