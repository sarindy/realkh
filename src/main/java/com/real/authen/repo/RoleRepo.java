package com.real.authen.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.real.authen.model.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {

	public List<Role> findByRoleContaining(String role);
	public Role findByRole(String role);

}
