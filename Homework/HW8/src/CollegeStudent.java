/**
 * Created by mars on 3/5/18.
 */
public class CollegeStudent {
    private double dormCost = 0;
    private double tuition = 0;
    private Residency residency;
    private boolean livesOffCampus;


    CollegeStudent(String residency) throws IllegalArgumentException{
        if (residency.equalsIgnoreCase("IN STATE")){
            this.residency = Residency.IN_STATE;
            this.tuition = 23000;
        }
        else if (residency.equalsIgnoreCase("OUT OF STATE")){
            this.residency = Residency.OUT_OF_STATE;
            this.tuition = 42000;
        }

        else if (residency.equalsIgnoreCase("INTERNATIONAL")){
            this.residency = Residency.INTERNATIONAL;
            this.tuition = 44500;
        }
        else{
            throw new IllegalArgumentException("Student residency must be one of the three specified statuses.");
        }
        this.dormCost = 800;
        this.livesOffCampus = false;

    }

    CollegeStudent(String residency, boolean livesOffCampus) throws IllegalArgumentException {
        if (residency.equalsIgnoreCase("IN STATE")){
            this.residency = Residency.IN_STATE;
            this.tuition = 23000;
        }
        else if (residency.equalsIgnoreCase("OUT OF STATE")){
            this.residency = Residency.OUT_OF_STATE;
            this.tuition = 42000;
        }

        else if (residency.equalsIgnoreCase("INTERNATIONAL")){
            this.residency = Residency.INTERNATIONAL;
            this.tuition = 44500;
        }
        else{
            throw new IllegalArgumentException("Student residency must be one of the three specified statuses.");
        }

        this.livesOffCampus = livesOffCampus;
        if (this.livesOffCampus){
            this.dormCost = 500;
        }
        else{
            this.dormCost = 800;
        }
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public void setDormCost(double dormCost) {
        this.dormCost = dormCost;
    }

    double calculateYearlyCost(){
        return this.tuition + this.dormCost*12;
    }

    public double getTuition() {
        return tuition;
    }

    public double getDormCost(){
        return this.dormCost;
    }

    public Residency getResidency() {
        return residency;
    }

    boolean isLivingOffCampus(){
        return this.livesOffCampus;
    }

    public String toString(){
        String output = "The total expenses are: ";
        output += String.format("%.1f", calculateYearlyCost()) + "\n";
        output += "Here is the breakdown\n";
        output += "This student is ";
        if (this.residency == Residency.IN_STATE){
            output += "In State\n";
        }
        if (this.residency == Residency.OUT_OF_STATE){
            output += "Out of State\n";
        }
        if (this.residency == Residency.INTERNATIONAL){
            output += "International\n";
        }
        output += "Yearly Tuition: ";
        output += String.format("%.1f", getTuition()) + "\n";
        output += "Dorm Costs: ";
        output += String.format("%.1f", getDormCost() * 12) + "\n";



        return output;
    }
}
