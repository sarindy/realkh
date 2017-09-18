package com.real.authen.service;

import java.util.List;

import com.real.authen.model.Role;

public interface RoleService {

	public Role addRole(Role role);

	public Role updateRole(Role role, Role newRole);

	public Role findRole(String role);
	
	public List<Role> findRoleContain(String role);

	public Role findRoleById(int id);

	public List<Role> getAllRole();

}
