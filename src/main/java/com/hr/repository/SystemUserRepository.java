package com.hr.repository;

import java.util.List;

import com.hr.domain.SystemUser;
import com.hr.domain.User;

public interface SystemUserRepository {
	public List<SystemUser> getAllSystemUsers();

	public User getSystemUser(int id);

	public void updateSystemUser(SystemUser systemUser);

	public void deleteSystemUser(SystemUser systemUser);
}
