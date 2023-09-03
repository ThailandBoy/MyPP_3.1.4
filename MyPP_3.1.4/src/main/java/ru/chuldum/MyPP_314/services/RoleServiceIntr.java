package ru.chuldum.MyPP_314.services;

import ru.chuldum.MyPP_314.entities.Role;

import java.util.List;

public interface RoleServiceIntr {
    public List<Role> getAllRoles();

    public Role getById(Long id);
}
