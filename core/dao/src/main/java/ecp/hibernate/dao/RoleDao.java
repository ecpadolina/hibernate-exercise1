package ecp.hibernate.dao;

import ecp.hibernate.model.Role;
import java.util.List;

interface RoleDao{
	List listRoles();
	Role getRole(int roleId);
	void updateRole(Role role);
}