package ecp.hibernate.model;

import java.util.Date;
import java.util.Set;

public class Person{
  private int id;
  private Name name;
  private Address address;
  private float gwa;
  private Date birthday;
  private String employmentStatus;
  private Set<ContactInfo> contacts;
  private Set<Role> roles;

  public Person(){}
  public Person(int id, Name name, Address address, Date birthday, String employmentStatus, Set<ContactInfo> contact, Set<Role> roles){
    this.id = id;
    this.name = name;
    this.address = address;
    this.birthday = birthday;
    this.employmentStatus = employmentStatus;
    this.contacts = contacts;
    this.roles = roles;
  }
  
  public void setId(int id){
    this.id = id;
  }
  
  public int getId(){
    return id;
  }
  
  public void setName(Name name){
    this.name = name;
  }
  
  public Name getName(){
    return this.name;
  }
  
  public void setBirthday(Date birthday){
    this.birthday = birthday;
  }
  
  public Date getBirthday(){
    return birthday;
  }
  
  public void setAddress(Address address){
    this.address = address;
  }
  
  public Address getAddress(){
    return address;
  }
  
  public void setGwa(float gwa){
    this.gwa = gwa;
  }
  
  public float getGwa(){
    return gwa;
  }
  
  public void setEmploymentStatus(String employmentStatus){
    this.employmentStatus = employmentStatus;
  }
  
  public String getEmploymentStatus(){
    return employmentStatus;
  }
  
  public void setContacts(Set<ContactInfo> contacts){
    this.contacts = contacts;
  }
  
  public Set<ContactInfo> getContacts(){
    return contacts;
  }
  
  public void setRoles(Set<Role> roles){
    this.roles = roles;
  }
  
  public Set<Role> getRoles(){
    return roles;
  }
}
