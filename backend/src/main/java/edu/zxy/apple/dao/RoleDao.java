package edu.zxy.apple.dao;

import java.util.List;

import edu.zxy.apple.entity.Role;

public interface RoleDao
{
    public List<Role> getAll();

    public void add(Role person);

}
