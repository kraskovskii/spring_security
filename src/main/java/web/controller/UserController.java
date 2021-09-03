package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.users.UserService;

import java.security.Principal;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")//показать 1 юзера
    public String getUser(
            @PathVariable("id") long id,
            ModelMap model) {

        model.addAttribute("user", userService.getUserById(id));
        return "users/person";
    }


    @GetMapping(value = "")
    public String viewUser(
            Principal principal) {

        long id = userService.getUserFirstName(principal.getName()).getId();
        return "redirect:/user/" + id;
    }
}
