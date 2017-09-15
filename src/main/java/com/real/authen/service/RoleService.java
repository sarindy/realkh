package com.real.authen.service;

import java.util.List;

import com.real.authen.model.Role;

public interface RoleService {

	public Role addRole(Role role);

	public Role updateRole(Role role);

	public Role findRole(Role role);

	public Role findRoleByUid(Role role);

	public List<Role> getAllRole();

}
