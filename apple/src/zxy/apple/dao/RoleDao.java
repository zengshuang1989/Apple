package zxy.apple.dao;

import java.util.List;

import zxy.apple.pojo.Role;

public interface RoleDao {
	public List<Role> getAll();
    public void add(Role person);

}
