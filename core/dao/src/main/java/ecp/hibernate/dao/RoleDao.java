package ecp.hibernate.dao;

import ecp.hibernate.model.Role;
import java.util.List;

public interface RoleDao{
	List listRoles();
	Role getRole(int roleId);
	Boolean updateRole(Role role);
}