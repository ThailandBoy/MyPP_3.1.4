package ru.chuldum.MyPP_314.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.chuldum.MyPP_314.entities.Role;
import ru.chuldum.MyPP_314.entities.User;
import ru.chuldum.MyPP_314.entities.UserRoleWrap;
import ru.chuldum.MyPP_314.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService, UserServiceIntr {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void saveWrapper(UserRoleWrap userRoleWrap) {
        User user = userRoleWrap.getUser();
        user.setPassword(passwordEncoder.encode(userRoleWrap.getUser().getPassword()));
        List<Role> roleList = new ArrayList<>();
        for (Long roleId : userRoleWrap.getRoleList2()) {
            roleList.add(roleService.getById(roleId));
        }
        user.setRoles(roleList);
        save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteViaId(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return user;
    }
}
