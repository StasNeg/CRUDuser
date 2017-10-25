package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("users", repository.getAll());
        return "index";
    }

    @GetMapping("users/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        repository.delete(id);
        model.addAttribute("users", repository.getAll());
        return "index";
    }

    @RequestMapping(value = "users/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @RequestMapping(value = "users/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", repository.get(id));
        return "user";
    }

    @RequestMapping(value = "users/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("id") String id,
                       @ModelAttribute("firstName") String firstName,
                       @ModelAttribute("lastName") String lastName,
                       @ModelAttribute("email") String email) throws ServletException, IOException {
        User user = new User(firstName, lastName, email);
        if (!id.equals("")) {
            user.setId(Long.parseLong(id));
        }
        repository.save(user);
        return "redirect:/";
    }

}
