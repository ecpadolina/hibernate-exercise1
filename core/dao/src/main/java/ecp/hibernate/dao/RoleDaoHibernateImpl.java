package ecp.hibernate.dao;

import ecp.hibernate.dao.commands.GetRole;
import ecp.hibernate.dao.commands.ListRoles;
import ecp.hibernate.dao.commands.UpdateRole;
import ecp.hibernate.model.Role;
import java.util.List;

public class RoleDaoHibernateImpl{

	public List listRoles() {
        return HibernateUtil.perform(new ListRoles(), List.class);
    }
    public Role getRole(int roleId) {
        return HibernateUtil.perform(new GetRole(roleId), Role.class);
    }
    public void updateRole(Role role){
    	HibernateUtil.perform(new UpdateRole(role), Role.class);
    }
}