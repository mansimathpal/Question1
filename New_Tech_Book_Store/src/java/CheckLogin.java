/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import techBook.CheckLoginDAO;
import techBook.Customer;

public class CheckLogin {
  private String UserID, Password;
  private String firstName;
private String lastName;
private String gender;
private String dob;
private String address;
private String phoneNumber;
private String emailID;
private String value;
Customer cst=new Customer();
    /** Creates a new instance of CheckLogin */
    public CheckLogin() {
    }
   
    public String Check()
    {
      StringBuilder fName=new StringBuilder();
      StringBuilder lName=new StringBuilder();
      StringBuilder gndr=new StringBuilder();
      StringBuilder db=new StringBuilder();
      StringBuilder add=new StringBuilder();
      StringBuilder ph=new StringBuilder();
      StringBuilder email=new StringBuilder();
      ApplicationContext apc=new ClassPathXmlApplicationContext("techBook/spring-hibernate.xml");
      CheckLoginDAO helper=(CheckLoginDAO)apc.getBean("checkLoginDAO");
      String uname=getUserID();
      String pass=getPassword();
      boolean b=false;
      List<Customer> customers=new ArrayList<Customer>();
      customers=helper.getCustomer();
      for(Iterator it=customers.iterator();it.hasNext();)
        {
           cst=(Customer)it.next();
           if((cst.getUserid().toString().equals(uname))&& (cst.getPassword().toString().equals(pass)))
            {
               b=true;
               fName.append(cst.getFirstname().toString());
               lName.append(cst.getLastname().toString());
               gndr.append(cst.getGender().toString());
               db.append(cst.getDob().toString());
               add.append(cst.getAddress().toString());
               ph.append(cst.getPhone().toString());
               email.append(cst.getEmail().toString());
               setValues(fName, lName, gndr, db, add, ph, email);
               break;
             }
            else
                b=false;
         }
      if (b==true)
      {
         return "true";
        }
      else
         return "false";
    }

    public void setValues(StringBuilder fName, StringBuilder lName, StringBuilder gndr, StringBuilder db, StringBuilder add, StringBuilder ph, StringBuilder email)
    {
       setFirstName(fName.toString());
       setLastName(lName.toString());
       setGender(gndr.toString());
       setDob(db.toString());
       setAddress(add.toString());
       setPhoneNumber(ph.toString());
       setEmailID(email.toString());
    }
    /**
     * @return the UserID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the emailID
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * @param emailID the emailID to set
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}
