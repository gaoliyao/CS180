/**
 * Created by mars on 3/5/18.
 */
public class IUStudent extends CollegeStudent{
    private double bookFees;
    private double transportationCost;
    private double financialAid;
    IUStudent(String residency, boolean livesOffcampus, double GPA) throws IllegalArgumentException{
        super(residency, livesOffcampus);
        this.bookFees = 1034;
        if (residency.equalsIgnoreCase("OUT OF STATE")){
            setTuition(34846);
        }
        else if (residency.equalsIgnoreCase("IN STATE")){
            setTuition(10534);
        }
        else{
            throw new IllegalArgumentException("“Student must be in state or out of state");
        }
        if (GPA >= 3.75){
            this.financialAid = 4500;
        }
        else if (GPA >= 3.5){
            this.financialAid = 3500;
        }
        else if (GPA >= 3){
            this.financialAid = 2750;
        }
        else if (GPA >= 2.5){
            this.financialAid = 2500;
        }
        else if (GPA < 0){
            throw new IllegalArgumentException("GPA needs to be above or equal to 0");
        }
        if (livesOffcampus){
            setDormCost(400);
            this.transportationCost = 500;
        }
        if (!livesOffcampus){
            setDormCost(800);
            this.transportationCost = 100;
        }

    }
    void setTransportationCost(double transportationCost) {
        this.transportationCost = transportationCost;
    }
    void setBookFees(double bookFees) {
        this.bookFees = bookFees;
    }

    void setFinancialAid(double financialAid) {
        this.financialAid = financialAid;
    }
    double getBookFees() {
        return this.bookFees;
    }
    double getFinancialAid() {
        return this.financialAid;
    }
    double getTransportationCost() {
        return this.transportationCost;
    }
    @Override
    double calculateYearlyCost() {
        return this.bookFees + this.transportationCost - this.financialAid + getTuition() + getDormCost()*12;
    }
    @Override
    public String toString(){
        String output = "The total expenses are: ";
        output += String.format("%.1f", calculateYearlyCost()) + "\n";
        output += "Here is the breakdown\n";
        output += "This student is ";
        if (getResidency() == Residency.IN_STATE){
            output += "In State\n";
        }
        if (getResidency() == Residency.OUT_OF_STATE){
            output += "Out of State\n";
        }
        output += "Yearly Tuition: ";
        output += String.format("%.1f", getTuition()) + "\n";
        output += "Dorm Costs: ";
        output += String.format("%.1f", getDormCost() * 12) + "\n";
        output += "Book Fees: ";
        output += String.format("%.1f", getBookFees()) + "\n";
        output += "Transportation Cost: ";
        output += String.format("%.1f", getTransportationCost()) + "\n";
        output += "Financial Aid: ";
        output += String.format("%.1f", getFinancialAid()) + "\n";



        return output;
    }
}
