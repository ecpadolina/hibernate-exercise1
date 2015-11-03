package ecp.hibernate.service;

import ecp.hibernate.model.Role;
import java.util.List;

public interface RoleManager{
	List listRoles();
	Role getRole(int roleId);
	void updateRole(Role role);
}