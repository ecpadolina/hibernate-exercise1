package ecp.hibernate.model;

import java.util.Set;

public class Role{

  private int role_id;
  private String role_type;
  private boolean isActive = true;
  private Set<Person> persons;
  
  public Role(){}
  public Role(int role_id, String role_type, Set<Person> persons, boolean isActive){
    this.role_id = role_id;
    this.role_type = role_type;
    this.persons = persons;
    this.isActive = isActive;
  }  
  
  public void setRole_id(int role_id){
    this.role_id = role_id;
  }
  
  public void setRole_type(String role_type){
    this.role_type = role_type;
  }
  
  public void setPersons(Set<Person> persons){
    this.persons = persons;
  }
  
  public int getRole_id(){
    return role_id;
  }
  
  public String getRole_type(){
    return role_type;
  }
  
  public Set<Person> getPersons(){
    return persons;
  }
  
  public void setIsActive(boolean isActive){
    this.isActive = isActive;
  }
  
  public boolean getIsActive(){
    return isActive;
  }
  
	@Override	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!this.getClass().equals(obj.getClass())) return false;
		Role obj2 = (Role)obj;
		if(this.role_type.equals(obj2.getRole_type()))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.role_type.hashCode();
	}
  
}
