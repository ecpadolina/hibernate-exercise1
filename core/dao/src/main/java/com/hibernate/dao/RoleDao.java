package com.hibernate.dao;

import com.hibernate.model.Role;
import java.util.List;

interface RoleDao{
	List listRoles();
	Role getRole(int roleId);
	void updateRole(Role role);
}