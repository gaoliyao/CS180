/**
 * Created by mars on 3/6/18.
 */
public class PurdueStudent extends CollegeStudent {
    private double bookFees;
    private double financialAid;
    private String major;

    PurdueStudent(String residency, String major, boolean livesOffCampus, double GPA) throws IllegalArgumentException{
        super(residency, livesOffCampus);
        this.bookFees = 0;
        this.major = major;
        if (residency.equalsIgnoreCase("OUT OF STATE")){
            setTuition(28794);
        }
        else if (residency.equalsIgnoreCase("IN STATE")){
            setTuition(9992);
        }
        else if (residency.equalsIgnoreCase("INTERNATIONAL")){
            setTuition(30954);
        }
        else{
        }
        if (major.equalsIgnoreCase("Computer Science")){
            this.bookFees = 200;
        }
        else if (major.equalsIgnoreCase("Engineering")){
            this.bookFees = 500;
        }
        else if (major.equalsIgnoreCase("Liberal Arts")){
            this.bookFees = 750;
        }
        else{
            this.bookFees = 100;
        }
        if (GPA >= 3.75){
            this.financialAid = 5000;
        }
        else if (GPA >= 3.5){
            this.financialAid = 4500;
        }
        else if (GPA >= 3){
            this.financialAid = 3000;
        }
        else if (GPA >= 2.5){
            this.financialAid = 2500;
        }
        else if (GPA < 2){
            throw new IllegalArgumentException("GPA needs to be above or equal to a 2.00");
        }


    }
    public void setBookFees(double bookFees) {
        this.bookFees = bookFees;
    }

    public void setFinancialAid(double financialAid) {
        this.financialAid = financialAid;
    }
    public double getBookFees() {
        return this.bookFees;
    }
    public double getFinancialAid() {
        return this.financialAid;
    }
    public String getMajor(){
        return this.major;
    }
    @Override
    public double calculateYearlyCost() {
        return this.bookFees - this.financialAid + getTuition() + getDormCost()*12;
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
        if (getResidency() == Residency.INTERNATIONAL){
            output += "International\n";
        }
        output += "Yearly Tuition: ";
        output += String.format("%.1f", getTuition()) + "\n";
        output += "Dorm Costs: ";
        output += String.format("%.1f", getDormCost() * 12) + "\n";
        output += "Book Fees: ";
        output += String.format("%.1f", getBookFees()) + "\n";
        output += "Financial Aid: ";
        output += String.format("%.1f", getFinancialAid()) + "\n";

        return output;
    }
}
