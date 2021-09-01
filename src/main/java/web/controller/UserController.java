package web.controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.roles.RoleService;
import service.users.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/admin";
    }

    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user) {
        System.out.println("PAST ADD " + user);
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}")//показать 1 юзера
    public String getUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("users", userService.getUserById(id));
        return "users/admin";
    }

    @GetMapping(value = "/new")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "users/new";
    }


    @GetMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("userForEdit", userService.getUserById(id));
        System.out.println(userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("userForEdit") User updateUser,
                         @PathVariable("id") int id) {
        System.out.println("bbbbbbbbbbb" + updateUser.toString()   );
        userService.updateUser(updateUser);
        return "redirect:/users";
    }
}
