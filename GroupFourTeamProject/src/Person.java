

public class Person {
    String firstname;
    String lastname;
    String dateOfBirth;

    public Person(){};

    public Person(String theFirstName, String theLastName, String theDateOfBirth){
        setFirstName(theFirstName);
        setLastName(theLastName);
        setDateOfBirth(theDateOfBirth);
    }



    public void setFirstName(String theFirstName){
        this.firstname = theFirstName;
    }
    public void setLastName(String theLastName){
        this.lastname = theLastName;
    }
    public void setDateOfBirth(String theDateOfBirth){
        this.dateOfBirth = theDateOfBirth;
    }

    public String getFirstName(){
        return this.firstname;
    }
    public String getLastName(){
        return this.lastname;
    }
    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    



}
