import java.util.*;

public class Main{
  private static Options op = new Options();  
  private static Scanner sc = new Scanner(System.in);
  private static Validation v = new Validation();
  public static void main(String[] args){
    int option, option2;
    String optionDisplay = "";
    
    do{
      optionDisplay = "\n=======================HIBERNATE EXERCISE=======================\n"
                       + "[1] Person Management\n"
                       + "[2] Contact Management\n"
                       + "[3] Role Management\n" 
                       + "[4] List Person\n"
                       + "[5] Exit\n"
                       + "Choice: "; 
      option = v.validIntOption(optionDisplay, 1, 5);
      switch(option){
        case 1:
          optionDisplay = "\n=======================PERSON MANAGEMENT=======================\n"
                         +"[1] Add Person\n"
                         + "[2] Update Person Information\n"
                         + "[3] Delete Person\n"
                         + "[4] Go Back\n"
                         + "Choice: ";
          option2 = v.validIntOption(optionDisplay, 1, 4);
          switch(option2){
            case 1:
              op.addPerson();
              break;
            case 2:
              op.updatePerson();
              break;
            case 3:
              op.deletePerson();
              break;
          }
          break;
        case 2:
          optionDisplay = "\n=======================CONTACT MANAGEMENT=======================\n"
                         + "\n[1] Add Contact to Person"
                         + "\n[2] Update Contacts of Person"
                         + "\n[3] Delete Contact of Person"
                         + "\n[4] Display Contacts of Person"
                         + "\n[5] Go Back"
                         + "\nChoice: ";
          option2 = v.validIntOption(optionDisplay, 1, 5);
          switch(option2){
            case 1:
              op.addContactToPerson();
              break;
            case 2:
              int contactOption;
              optionDisplay = "\nEDIT CONTACT\n"
	            + "[1] Landline\n"
	            + "[2] Mobile\n"
	            + "[3] Email Address\n"
	            + "[4] Go Back\n"
	            + "Choice: ";
	            contactOption = v.validIntOption(optionDisplay, 1, 4);
	            switch(contactOption){
	              case 1:
	                op.editContactOfPerson("Landline");
	                break;
	              case 2:
	                op.editContactOfPerson("Mobile");
	                break;
	              case 3:
	                op.editContactOfPerson("Email");    
	                break;
	            }
              break;
            case 3:
              op.deleteContactOfPerson();
              break;
            case 4:
              op.displayContactsOfPerson();
              break;
          }
          break;
        case 3:
          optionDisplay =  "\n=======================ROLE MANAGEMENT=======================\n"
                         + "\n[1] Add Role to Person"
                         + "\n[2] Remove Role from Person"
                         + "\n[3] List Roles of Person"
                         + "\n[4] Activate/Deactivate Roles"
                         + "\n[5] Go Back"
                         + "\nChoice: ";
          option2 = v.validIntOption(optionDisplay, 1, 5);
          switch(option2){
            case 1:
              op.addRoleToPerson();
              break;
            case 2:
              op.removeRoleFromPerson();
              break;
            case 3:
              op.listPersonRoles();
              break;
            case 4 :
              op.updateRoleStatus();
              break;
          }
          break;
        case 4:
          optionDisplay  = "\n=======================LIST PERSON=======================\n"
                         + "\n[1] List Person By Id"
                         + "\n[2] List Person By Last Name"
                         + "\n[3] List Person By GWA"
                         + "\n[4] Go Back"
                         + "\nChoice: ";
          option2 = v.validIntOption(optionDisplay, 1, 4);
          int order;
          optionDisplay = "Order By: \n[1] Ascending\n[2] Descending\n[3] Go Back\nChoice: ";
          switch(option2){
            case 1:
              order = v.validIntOption(optionDisplay, 1, 3);
              op.listPerson(order, "id");
              break;
            case 2:
              order = v.validIntOption(optionDisplay, 1, 3);
              op.listPerson(order, "name.lastName");
              break;
            case 3:
              order = v.validIntOption(optionDisplay, 1, 3);
              op.listPerson(order, "gwa");
              break;
          }
          break;         
      }
      break;
    }while(option != 5);
  }
}
