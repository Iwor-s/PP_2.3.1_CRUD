package springcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springcrud.models.User;
import springcrud.services.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/users";
    }
    
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }
    
    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    
    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") long id) {
        model.addAttribute(userService.getUserById(id));
        return "users/edit";
    }
    
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
