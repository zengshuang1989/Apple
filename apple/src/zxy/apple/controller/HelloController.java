package zxy.apple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zxy.apple.dao.RoleDao;
import zxy.apple.pojo.Role;
import zxy.apple.vo.RoleVO;

@Controller
public class HelloController {

	@Autowired
	RoleDao roleDao;
	
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public @ResponseBody RoleVO addRole(@RequestBody RoleVO role) {
		Role addRole = new Role();
		addRole.setName("Bank of China");
		addRole.setType("Orgnization");
		roleDao.add(addRole);
		return role;
	}

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public @ResponseBody List<RoleVO> getAllRole() {
		List<Role> list = roleDao.getAll();
		List<RoleVO> list2= new ArrayList<RoleVO>();
		if(list!=null){
            for(Role role:list){
                RoleVO roleVO = new RoleVO();
                roleVO.setId(role.getId());
                roleVO.setName(role.getName());
                roleVO.setType(role.getType());
                list2.add(roleVO);
            }
        }

		return list2;
	}
}