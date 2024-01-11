public class Prescription {
    
    String medication;
    String quantity;
    String instruction;

    public Prescription(){}
    
    public Prescription( String aMedication, String aQuantity, String anInstruction){
        this.medication = aMedication;
        this.quantity = aQuantity;
        this.instruction = anInstruction;      
    }
    //SET methods
    public void setMedication (String theMedication){
        this.medication = theMedication;
    }
    public void setQuantity(String theQuantity){
        this.quantity = theQuantity;
    }
    public void setInstruction(String theInstruction){
        this.instruction = theInstruction;
    }
    //GET Methods
    public String getMedication(){
        return this.medication;
    }
    public String getQuantity(){
        return this.quantity;
    }
    public String getInstruction(){
        return this.instruction;
    }
}
