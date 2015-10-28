package com.hibernate.service;

import com.hibernate.dao.RoleDaoHibernateImpl;
import com.hibernate.model.Role;

import java.util.List;

public class RoleManagerHibernateImpl implements RoleManager{

  private RoleDaoHibernateImpl rdao;
  
  public RoleManagerHibernateImpl(){
    rdao = new RoleDaoHibernateImpl();
  }

  public List listRoles(){
    return rdao.listRoles();
  }

  public Role getRole(int roleId){
    return rdao.getRole(roleId);
  }
  public void updateRole(Role role){
    rdao.updateRole(role);
    System.out.println("Role Updated!");
  }
}