package medical_clinic_system;

import java.util.ArrayList;

public class Prescription {
    private String medicine;
    private int quantity;
    private String instruction;
    

    public Prescription(){}

    public Prescription(String medicine,int quantity,String instruction){
        setMedicine(medicine);
        setQuantity(quantity);
        setInstruction(instruction);
        
    }

    public void setMedicine(String aMedicine){
        this.medicine = aMedicine;
    }
    public void setQuantity(int theQuantity){
        this.quantity = theQuantity;
    }
    public void setInstruction(String instruction){
        this.instruction = instruction;
    }
    public String getMedicine(){
        return this.medicine;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getDescription(){
        return this.instruction;
    }

    

    @Override
    public String toString(){
        return String.format("%s %d %s\n",this.medicine ,this.quantity, this.instruction);
    }

    public String displayInfo(){
        String temp = String.format("Prescription: \nMedicine: %s \tQuantity: %5d \tDescriptions: %s\n",this.medicine ,this.quantity, this.instruction);
        return temp;
    }
}
