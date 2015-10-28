package com.hibernate.service;

import com.hibernate.model.Role;
import java.util.List;

interface RoleManager{
	List listRoles();
	Role getRole(int roleId);
	void updateRole(Role role);
}