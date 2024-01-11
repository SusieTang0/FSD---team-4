package medical_clinic_system;

public class Prescription {
    private String medicine;
    private int quantity;
    private String description;

    public Prescription(){}

    public Prescription(String medicine,int quantity,String description){
        setMedicine(medicine);
        setQuantity(quantity);
        setDescription(description);
    }

    public void setMedicine(String aMedicine){
        this.medicine = aMedicine;
    }
    public void setQuantity(int theQuantity){
        this.quantity = theQuantity;
    }
    public void setDescription(String aDescription){
        this.description = aDescription;
    }
    public String getMedicine(){
        return this.medicine;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getDescription(){
        return this.description;
    }
    

    @Override
    public String toString(){
        return String.format("Prescription: Medicine: %s \tQuantity: %5d \tDescriptions: %s\n",this.medicine ,this.quantity, this.description);
    }
}
