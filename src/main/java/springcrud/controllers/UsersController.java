package springcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springcrud.services.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }
    @RequestMapping("/{id}")
    public String showOne(@PathVariable("id") int id) {
        return "users/user";
    }
}
