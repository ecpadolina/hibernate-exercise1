package com.hibernate.model;

public class Name{
  
  private String lastName;
  private String firstName;
  private String middleName;

  public Name(String lastName, String firstName, String middleName){
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
  }
  
  public Name(){}
  
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  
  public  void setFirstName(String firstName){
    this.firstName = firstName;
  }
  
  public void setMiddleName(String middleName){
    this.middleName = middleName;
  }
  
  public String getLastName(){
    return lastName;
  }
  
  public String getFirstName(){
    return firstName;
  }  
  
  public String getMiddleName(){
    return middleName;
  }
  
  public String toString(){
    return getLastName() + ", " + getFirstName();
  }
}
