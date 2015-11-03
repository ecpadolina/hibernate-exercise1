package ecp.hibernate.dao;

import ecp.hibernate.dao.commands.Get;
import ecp.hibernate.dao.commands.GetList;
import ecp.hibernate.dao.commands.Update;
import ecp.hibernate.model.Role;
import java.util.List;

public class RoleDaoHibernateImpl implements RoleDao{

	public List listRoles() {
        return HibernateUtil.perform(new GetList(1, "role_id", Role.class), List.class);
    }
    public Role getRole(int roleId) {
        return HibernateUtil.perform(new Get(roleId, Role.class), Role.class);
    }
    public Boolean updateRole(Role role){
    	return HibernateUtil.perform(new Update(role), Boolean.class);
    }
}