package medical_clinic_system;

public class Treatment {
    private String description;

    public Treatment(){}

    public Treatment(String description){
        setDescription(description);
    }

    public void setDescription(String aDescription){
        this.description = aDescription;
    }

     public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return String.format("Treatment: %s\n", this.description);
    }
}
