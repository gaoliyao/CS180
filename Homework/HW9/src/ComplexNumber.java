import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mars on 3/19/18.
 */
public final class ComplexNumber extends Object implements Comparable<ComplexNumber>  {
    private double realPart;
    private double imaginaryPart;

    public static List list = Collections.synchronizedList(new ArrayList());

    @Override
    public int compareTo(ComplexNumber o) {
        if (o == null){
            return -1;
        }
        else if (this.realPart > o.getRealPart​()){
            return 1;
        }
        else if (this.realPart < o.getRealPart​()){
            return -1;
        }
        else if (this.realPart == o.getRealPart​()){
            if (this.realPart > o.getRealPart​()){
                return 1;
            }
            else if (this.realPart < o.getRealPart​()){
                return -1;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }

    }

    public ComplexNumber (double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber (ComplexNumber aComplexNumber​) throws IllegalArgumentException{
        if (aComplexNumber​ == null){
            throw new IllegalArgumentException();
        }
        this.realPart = aComplexNumber​.getRealPart​();
        this.imaginaryPart = aComplexNumber​.getImaginaryPart​();
    }

    public ComplexNumber (){
        this.imaginaryPart = 0;
        this.realPart = 0;
    }

    public ComplexNumber add​(ComplexNumber aComplexNumber) throws IllegalArgumentException {
        if (aComplexNumber == null){
            throw new IllegalArgumentException();
        }
        return new ComplexNumber(this.realPart + aComplexNumber.getRealPart​(), this.imaginaryPart+aComplexNumber.getImaginaryPart​());

    }
    public ComplexNumber conjugate​(){
        return new ComplexNumber(this.realPart, -this.imaginaryPart);
    }
    public ComplexNumber divide​(ComplexNumber aComplexNumber)  throws IllegalArgumentException {
        if (aComplexNumber == null){
            throw new IllegalArgumentException();
        }
        double a, b, c, d;
        a = this.realPart;
        b = this.imaginaryPart;
        c = aComplexNumber.getRealPart​();
        d = aComplexNumber.getImaginaryPart​();
        return new ComplexNumber((a*c + b*d) / (c*c + d*d), (b*c - a*d) / (c*c + d*d));

    }
    @Override
    public boolean equals​(Object anObject){
        if (compareTo((ComplexNumber) anObject) == 0){
            return true;
        }
        return false;
    }
    public double getImaginaryPart​(){
        return this.imaginaryPart;
    }
    public double getRealPart​(){
        return this.realPart;
    }
    @Override
    public int hashCode​(){
        return super.hashCode();
    }
    public ComplexNumber multiply​(ComplexNumber aComplexNumber)  throws IllegalArgumentException {
        if (aComplexNumber == null){
            throw new IllegalArgumentException();
        }
        return new ComplexNumber(this.realPart*aComplexNumber.getRealPart​()-this.imaginaryPart*aComplexNumber.getImaginaryPart​(),
                this.imaginaryPart*aComplexNumber.getRealPart​()+this.realPart*aComplexNumber.getImaginaryPart​());

    }
    public ComplexNumber reciprocal​(){
        return new ComplexNumber(this.realPart / (this.realPart*this.realPart + this.imaginaryPart*this.imaginaryPart),
                this.imaginaryPart / (this.realPart*this.realPart + this.imaginaryPart*this.imaginaryPart));
    }
    public void setImaginaryPart​(double imaginaryPart){
        this.imaginaryPart = imaginaryPart;
    }
    public void setRealPart​(double realPart){
        this.realPart = realPart;
    }
    public ComplexNumber subtract​(ComplexNumber aComplexNumber) throws IllegalArgumentException {
        if (aComplexNumber == null){
            throw new IllegalArgumentException();
        }
        return new ComplexNumber(this.realPart - aComplexNumber.getRealPart​(), this.imaginaryPart-aComplexNumber.getImaginaryPart​());

    }
    @Override
    public String toString​(){
        if (this.imaginaryPart > 0) {
            return Double.toString(this.realPart) + " + " + Double.toString(this.imaginaryPart) + "i";
        }
        else{
            return Double.toString(this.realPart) + Double.toString(this.imaginaryPart) + "i";
        }
    }

}
