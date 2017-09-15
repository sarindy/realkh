package com.real.authen.service;

import java.util.List;

import com.real.authen.model.Role;

public interface RoleService {

	public Role addRole(Role role);

	public Role updateRole(Role role);

	public List<Role> findRole(Role role);

	public Role findRoleById(Role role);

	public List<Role> getAllRole();

}
