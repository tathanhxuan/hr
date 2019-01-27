package com.hr.repository;

import java.util.List;

import com.hr.domain.User;

public interface UserRepository {
	public List<User> getAllUsers();

	public User getUser(int id);

	public void updateUser(User user);

	public void deleteUser(User user);
}
