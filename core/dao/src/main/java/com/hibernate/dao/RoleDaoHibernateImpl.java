package com.hibernate.dao;

import com.hibernate.dao.commands.GetRole;
import com.hibernate.dao.commands.ListRoles;
import com.hibernate.dao.commands.UpdateRole;
import com.hibernate.model.Role;
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