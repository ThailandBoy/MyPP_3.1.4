package ru.chuldum.MyPP_314.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import ru.chuldum.MyPP_314.entities.User;
import ru.chuldum.MyPP_314.entities.UserRoleWrap;
import ru.chuldum.MyPP_314.services.RoleService;
import ru.chuldum.MyPP_314.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String user(Model model) {

        Authentication userRole = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(userRole.getName());
        model.addAttribute("user", user);
        model.addAttribute("alluserlist", userService.getAllUsers());

        UserRoleWrap userRoleWrap = new UserRoleWrap();
        userRoleWrap.setUser(new User());
        userRoleWrap.setRoleList(roleService.getAllRoles());
        model.addAttribute("userRoleWrap", userRoleWrap);

        return "mainPage";
    }
}
