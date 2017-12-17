package edu.zxy.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.RoleDao;
import edu.zxy.apple.entity.Role;
import edu.zxy.apple.vo.RoleVO;

@Controller
public class RoleController
{

    @Autowired
    RoleDao roleDao;

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public @ResponseBody void addRole(@RequestBody RoleVO roleVO)
    {
        Role role = new Role();
        role.setName(roleVO.getName());
        role.setType(roleVO.getType());
        roleDao.add(role);
    }

    @RequestMapping(value = "/delRole", method = RequestMethod.POST)
    public @ResponseBody void delRole(@RequestBody RoleVO roleVO)
    {
        Role role = new Role();
        role.setId(roleVO.getId());
        roleDao.delete(role);
    }

    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    public @ResponseBody void updateRole(@RequestBody RoleVO roleVO)
    {
        Role role = new Role();
        role.setId(roleVO.getId());
        role.setName(roleVO.getName());
        role.setType(roleVO.getType());
        roleDao.update(role);
    }

    @RequestMapping(value = "/getRole", method = RequestMethod.POST)
    public @ResponseBody RoleVO getRole(@RequestBody Integer roleId)
    {
        Role role = roleDao.get(roleId);
        RoleVO roleVO = new RoleVO();
        roleVO.setId(role.getId());
        roleVO.setName(role.getName());
        roleVO.setType(role.getType());
        roleVO.setCreatedDatetime(role.getCreatedDatetime());
        roleVO.setLastUpdatedDatetime(role.getLastUpdatedDatetime());
        return roleVO;
    }
}