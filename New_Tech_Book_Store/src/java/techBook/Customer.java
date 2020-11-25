package techBook;
import java.util.Date;

public class Customer  implements java.io.Serializable {


     private String userid;
     private String firstname;
     private String lastname;
     private String gender;
     private Date dob;
     private String address;
     private String phone;
     private String email;
     private String password;

    public Customer() {
    }

	
    public Customer(String userid) {
        this.userid = userid;
    }
    public Customer(String userid, String firstname, String lastname, String gender, Date dob, String address, String phone, String email, String password) {
       this.userid = userid;
       this.firstname = firstname;
       this.lastname = lastname;
       this.gender = gender;
       this.dob = dob;
       this.address = address;
       this.phone = phone;
       this.email = email;
       this.password = password;
    }
   
    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


