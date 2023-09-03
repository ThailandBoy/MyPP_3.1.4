package ru.chuldum.MyPP_314.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.chuldum.MyPP_314.entities.Role;
import ru.chuldum.MyPP_314.entities.User;
import ru.chuldum.MyPP_314.services.RoleService;
import ru.chuldum.MyPP_314.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class DownloadEntitiesRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/allUsers")
    public List<User> allUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/allRoles")
    public List<Role> allRoles(){
        return roleService.getAllRoles();
    }

}
