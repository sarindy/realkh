package com.real.authen.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.real.authen.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	public List<User> findByFirstNameContaining(String firstName);

	public List<User> findByLastNameContaining(String lastName);

	public List<User> findByEmailContaining(String email);

	public User findByEmail(String email);

	public List<User> findByActive(int active);

}
