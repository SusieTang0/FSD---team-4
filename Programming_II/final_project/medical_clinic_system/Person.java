package medical_clinic_system;


public class Person {
    String firstname;
    String lastname;
    int age;
    String sex;
    String dateOfBirth;
    String email;
    String phoneNumber;
    String address;

    public Person(){};

    public Person(String firstName, String lastName,String email, String phoneNumber){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    };

    public Person(String firstName, String lastName, int age, String sex, String dateOfBirth, String email, String phoneNumber, String address){
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSex(sex);
        setDateOfBirth(dateOfBirth);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }



    public void setFirstName(String theFirstName){
        this.firstname = theFirstName;
    }
    public void setLastName(String theLastName){
        this.lastname = theLastName;
    }
    public void setAge(int theAge){
        this.age = theAge;
    }
    public void setSex(String theSex){
        this.sex = theSex;
    }
    public void setDateOfBirth(String theDateOfBirth){
        this.dateOfBirth = theDateOfBirth;
    }
    public void setEmail(String theEmail){
        this.email = theEmail;
    }
    public void setPhoneNumber(String thePhoneNumber){
        this.phoneNumber = thePhoneNumber;
    }
    public void setAddress(String theAddress){
        this.address = theAddress;
    }


    public String getFirstName(){
        return this.firstname;
    }
    public String getLastName(){
        return this.lastname;
    }
    public String getName(){
        return this.firstname + " " + this.lastname;
    }

    public int getAge(){
        return this.age;
    }
    public String getSex(){
        return this.sex;
    }
    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
     public String getEmail(){
        return this.email;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getAddress(){
        return this.address;
    }

    



}
