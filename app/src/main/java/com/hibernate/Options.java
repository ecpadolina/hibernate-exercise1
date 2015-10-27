import com.hibernate.model.*;
import com.hibernate.service.*;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Options{
  
  private PersonManager pm;
  private Scanner sc = new Scanner(System.in);
  private Validation v = new Validation();
  public Options(){
    pm = new PersonManager();
  }
  
  public Person getPersonInfo(Person person){
    Name name = new Name();
    Address address = new Address();
    
    name.setFirstName(v.validString("First Name: "));
    name.setMiddleName(v.validString("Middle Name: "));
    name.setLastName(v.validString("Last Name: "));
    person.setName(name);
    
    person.setBirthday(v.validBirthday());
    
    address.setHouseNo(v.validString("House No: "));
    address.setStreet(v.validString("Street: "));
    address.setBarangay(v.validString("Barangay: "));
    address.setSubdivision(v.validString("Subdivision: "));
    address.setMunicipality(v.validString("Municipality: "));
    address.setProvince(v.validString("Province: "));
    address.setZipcode(v.validIntInput("Zipcode: "));
    person.setAddress(address);
    
    person.setGwa(v.validGwa());
    person.setEmploymentStatus(getEmploymentStatus());
    return person;
  }
  
  public String getEmploymentStatus(){
    String displayOption = "Employment Status: \n"
                    +"[1] Intern\n"
                    +"[2] Probationary\n"
                    +"[3] Regular\n"
                    +"[4] Resigned\n"
                    +"Choice: ";
    int choice = v.validIntOption(displayOption, 1, 4);
    switch(choice){
      case 1:
        return "Intern";
      case 2:
        return "Probationary";
      case 3:
        return "Regular";
      case 4:
        return "Resigned";
    }
    return "";
  }
  
  public Set<ContactInfo> newContact(Set<ContactInfo> set){ 	 	
		int choice = 1;
		boolean contactExist = false;
		do{
			ContactInfo contact = new ContactInfo();
			String displayOption = "Contact Information: \n"
			               + "[1] Landline \n" 
			               + "[2] Cellphone Number\n" 
			               + "[3] Email Address\n"
			               + "Choice: ";
			int numberType = v.validIntOption(displayOption, 1, 4);
			if(numberType == 1){
				contact.setContactType("Landline");
			  	contact.setContactInfo(v.validContact("Landline"));
			} else if(numberType == 2) {
				contact.setContactType("Mobile");
				contact.setContactInfo(v.validContact("Mobile"));
			} else if(numberType == 3) {
			  	contact.setContactType("Email");
			  	contact.setContactInfo(v.validContact("Email"));
			}

			if(set.isEmpty()){
	  		  set.add(contact);
	  		} else {
	    		for(ContactInfo info : set){
	    		  if(info.getContactInfo().equals(contact.getContactInfo())){
	    		    System.out.println("Contact information already exists");
	    		    contactExist = true;
	    		  }
	    		}
  		}
  		if(!contactExist){
  		  set.add(contact);
  		  System.out.println("Contact added!");
  		}
			displayOption = "Add another contact information? \n[1]YES \n[2]No\nChoice: ";
			choice = v.validIntOption(displayOption, 1, 2);
		} while(choice==1);
		return set;
	}
	
	public void addContactToPerson(){
	  System.out.print("Person ID: ");
		int id = sc.nextInt();
		Person person = pm.getPerson(id);
		if(person != null){
		  Set<ContactInfo> contactInfo = person.getContacts();
		  person.setContacts(newContact(contactInfo));
		  pm.updatePerson(person);
		} else {
		  System.out.println("Person does not exist..");
		}
	}
	
	public void displayContacts(String type, Set<ContactInfo> set){
	  for(ContactInfo info : set){
	    if(!type.equals("")){
	      if((info.getContactType()).equals(type)){
	        System.out.println("[" + info.getId() + "] " + info.getContactInfo());
	      }
	    } else {
          System.out.println("[" + info.getId() + "] " + info.getContactInfo());
	    }
	  }
	}
	
	public void displayContactsOfPerson(){
	  System.out.print("Person ID: ");
	  int id = sc.nextInt();
	  Person person = pm.getPerson(id);
	  Set<ContactInfo> contacts = person.getContacts();
	  if(!contacts.isEmpty()){
		  System.out.println(person.getName().toString() + " contacts:");
		  displayContacts("",contacts);
	  } else {
	  		System.out.println("Person has no contacts!");
	  }
	}
	
	public void editContactOfPerson(String type){
	  int id = v.validIntInput("Person ID: ");
	  Person person = pm.getPerson(id);
	  if(person != null){
	    Set<ContactInfo> contactInfo = person.getContacts();
		    if(!contactInfo.isEmpty()){
	  	  	System.out.println(person.getName().toString() + " " + type + " contacts:");
		    displayContacts(type, contactInfo);
		    int contactIdToEdit = v.validIntInput("Enter Contact Id: ");
		    ContactInfo newContact = new ContactInfo();
		    ContactInfo oldContact = new ContactInfo();
		    for(ContactInfo tempContactInfo : contactInfo){
		      if(tempContactInfo.getId() == contactIdToEdit){
		        oldContact = tempContactInfo;
		        newContact = tempContactInfo;
		      }
		    }
		    newContact.setContactInfo(v.validContact(newContact.getContactType()));
		    contactInfo.remove(oldContact);
		    contactInfo.add(newContact);
		    person.setContacts(contactInfo);
		    pm.updatePerson(person);
	    } else {
	    	System.out.println("Person has no contacts!");
	    }
	  } else {
	      System.out.println("Person does not exist!");
	  }
	}
	
	public void deleteContactOfPerson(){
	  int id = v.validIntInput("Person ID: ");
	  Person person = pm.getPerson(id);
	  if(person != null){
	    Set<ContactInfo> contactInfo = person.getContacts();
	    if(!contactInfo.isEmpty()){
		    displayContacts("",contactInfo);
		    int contactIdToDelete = v.validIntInput("Enter Contact Id: ");
		    ContactInfo contactToDelete = new ContactInfo();
		    
		    for(ContactInfo tempContactInfo : contactInfo){
		      if(tempContactInfo.getId() == contactIdToDelete){
		        contactInfo.remove(tempContactInfo);
		      }
		    }
		    person.setContacts(contactInfo);
		    pm.updatePerson(person);
		 } else {
		 	System.out.println("Person has no contacts!");
		 }
	  } else {
	      System.out.println("Person doesn't exist!");
	  }
	}

  
  public void addPerson(){
    Person person = getPersonInfo(new Person());
    person.setContacts(newContact(new HashSet<ContactInfo>()));
    person.setRoles(newRole(new HashSet<Role>()));
    pm.addPerson(person);
  }
  
  public void updatePerson(){
	int id = v.validIntInput("Person ID: ");
	Person person = pm.getPerson(id);
	
	if(person!=null){
		pm.updatePerson(getPersonInfo(person));
	}else {
		System.out.println("Person does not exist..");
	}	
  }

	public void deletePerson(){ 
		int id = v.validIntInput("Person ID: ");
		Person person = pm.getPerson(id);

		if(person!=null){
			pm.deletePerson(id);
		} else {
			System.out.println("Person does not exist.");
		}	
	}
	
	public void listPerson(int order, String column){
	  List list;
	  
	  if(column.equals("gwa")){
	    list = pm.listPerson(order,"id");
	    if(order == 2){
	      Collections.sort(list, Sort.ascending);
	    } else
	      Collections.sort(list, Sort.descending);
	  } else{
	    list = pm.listPerson(order,column);
	  }

    for(Iterator ir = list.iterator(); ir.hasNext();){
      Person person = (Person)ir.next();
      Set<ContactInfo> contacts = person.getContacts();
      Set<Role> roles = person.getRoles();
      System.out.println("\nPerson ID: " + person.getId());
      System.out.println("Person Name: " + person.getName().toString());
      System.out.println("Person Birthday: " + person.getBirthday().toString());
      System.out.println("Person Address: " + person.getAddress().toString());
      System.out.println("GWA: " + person.getGwa());
      System.out.println("\nContact Information");
      displayContacts("",contacts);
      System.out.println("\nRoles");
      for(Role role : roles){
        System.out.println(role.getRole_type());
      }
    }
	}
	
	public Role getRole(){
		int roleId = v.validIntInput("Role Id: ");
		return pm.getRole(roleId);
	}
	
	public Set<Role> newRole(Set<Role> set){
		int choice;
		boolean roleExist = false;
		do{
			listRoles();
			Role role = getRole();
			if(role!=null){
			  if(set.isEmpty()){
				  set.add(role);
				  System.out.println("Role added!");
				} else {
				    for(Role tempRole : set){
				      if(role.getRole_type().equals(tempRole.getRole_type())){
				        System.out.println("Role already exist!");
				        roleExist = true;
				      }
				    }
				    if(!roleExist){
				      set.add(role);
				      System.out.println("Role added!");
				    }
				}
			} else{
				System.out.println("Role does not exist");
			}
			System.out.print("Add another role?\n[1]Yes\n[2]No\nChoice: ");
			choice = sc.nextInt();
		}while(choice==1);
		return set;
	}
	
	public void listRoles(){
		ArrayList<Role> list = (ArrayList<Role>)pm.listRoles();
		System.out.println("Roles:");
		for(Role role: list){
			System.out.println("[" + role.getRole_id() + "] " + role.getRole_type() + "");
		}
	}
	
	public void addRoleToPerson(){
	  int id = v.validIntInput("Person Id: ");
	  Person person = pm.getPerson(id);
	  
	  if(person != null){
			Set<Role> set = person.getRoles();
			person.setRoles(newRole(set));
			pm.updatePerson(person);
		} else {		
			System.out.println("Person does not exist.");
		}
	}
	
	public void listPersonRoles(){
	  int id = v.validIntInput("Person ID: ");
	  Person person = pm.getPerson(id);
	  Set<Role> personRoles = person.getRoles();
	  if(!personRoles.isEmpty()){
		  System.out.println(person.getName().toString() + "'s Roles: ");
		  for(Role role : personRoles){
		  	if(role.getIsActive())
		    	System.out.println("[" + role.getRole_id() + "] " + role.getRole_type());
		  }
	  } else {
	  		System.out.println("Person has no roles!");
	  }
	}
	
	public void removeRoleFromPerson(){
	  int id = v.validIntInput("Person Id: ");
	  boolean roleExist = false;
	  Person person = pm.getPerson(id);
	  
	  if(person != null){
	    Set<Role> personRoles = person.getRoles();
	    if(!personRoles.isEmpty()){
	      System.out.println(person.getName().toString() + "'s Roles: ");
	      for(Role role : personRoles){
	        System.out.println("[" + role.getRole_id() + "] " + role.getRole_type());
	      }
	      int roleId = v.validIntInput("Enter Role Id: 	");
	      for(Role role : personRoles){
	        if(roleId == role.getRole_id()){
	          personRoles.remove(role);
	          roleExist = true;
	        }
	        if(roleExist){
	          person.setRoles(personRoles);
	          System.out.println("Role removed");
	          pm.updatePerson(person);
	        } else {
	            System.out.println("Role doesn't exist..");
	        }
	      }
	    } else{
  	      System.out.println("Person doesn't have roles..");
	    }
	  } else {
  	    System.out.println("Person doesn't exist..");
	  }
	}

	public void updateRoleStatus(){
		listRoles();
		int id = v.validIntInput("Role ID: ");
		Role role = pm.getRole(id);

		if(role != null){
			if(role.getIsActive()){
				System.out.print("Deactive role? [Y/N]: ");
				String choice = sc.next();
				if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
					role.setIsActive(false);
					pm.updateRole(role);
				} else
					System.out.println("Role deactivation cancelled");
			} else {
				System.out.print("Activate role? [Y/N]: ");
				String choice = sc.next();
				if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
					role.setIsActive(true);
					pm.updateRole(role);
				} else
					System.out.println("Role activation cancelled");
			}
		} else {
			System.out.println("Role doesn't exist");
		}
	}
}