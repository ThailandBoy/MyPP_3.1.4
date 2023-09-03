package ru.chuldum.MyPP_314.services;

import ru.chuldum.MyPP_314.entities.User;

import java.util.List;

public interface UserServiceIntr {

    public List<User> getAllUsers();

    public void save(User user);

    public void deleteViaId(Long id);

    public User findByUsername(String username);

}
