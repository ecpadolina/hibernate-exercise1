package ecp.hibernate.model;

public class ContactInfo{
  private int id;
  private String contactType;
  private String contactInfo;
  
  public ContactInfo(){}
  
  public ContactInfo(int id, String contactType, String contactInfo){
    this.id = id;
    this.contactType = contactType;
    this.contactInfo = contactInfo;
  }
  
  public void setId(int id){
    this.id = id;
  }
  
  public void setContactType(String contactType){
    this.contactType = contactType;
  }
  
  public void setContactInfo(String contactInfo){
    this.contactInfo = contactInfo;
  }
  
  public int getId(){
    return id;
  }
  
  public String getContactType(){
    return contactType;
  }
  
  public String getContactInfo(){
    return contactInfo;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (!this.getClass().equals(obj.getClass())) return false;
      ContactInfo obj2 = (ContactInfo)obj;
      if((this.id == obj2.getId()) && (this.contactInfo.equals(obj2.getContactInfo()))){
        return true;
      }
    return false;
  }
  
  @Override
  public int hashCode() {
    int tmp = 0;
    tmp = ( id + contactInfo ).hashCode();
    return tmp;
  }
}
