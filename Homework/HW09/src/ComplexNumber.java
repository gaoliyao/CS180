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
    public synchronized int compareTo(ComplexNumber o) {
        synchronized (list) {
            if (o == null) {
                return -1;
            } else if (this.realPart > o.getRealPart()) {
                return 1;
            } else if (this.realPart < o.getRealPart()) {
                return -1;
            } else if (this.realPart == o.getRealPart()) {
                if (this.imaginaryPart > o.getImaginaryPart()) {
                    return 1;
                } else if (this.imaginaryPart < o.getImaginaryPart()) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    public ComplexNumber (double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber (ComplexNumber aComplexNumber) throws IllegalArgumentException{
        if (aComplexNumber == null){
            throw new IllegalArgumentException();
        }
        this.realPart = aComplexNumber.getRealPart();
        this.imaginaryPart = aComplexNumber.getImaginaryPart();
    }

    public ComplexNumber (){
        this.imaginaryPart = 0;
        this.realPart = 0;
    }




    

    public synchronized ComplexNumber add(ComplexNumber aComplexNumber) throws IllegalArgumentException {
            if (aComplexNumber == null) {
                throw new IllegalArgumentException();
            }
            return new ComplexNumber(this.realPart + aComplexNumber.getRealPart(), this.imaginaryPart + aComplexNumber.getImaginaryPart());
    }








    public synchronized ComplexNumber conjugate(){
        synchronized (list) {
            return new ComplexNumber(this.realPart, -this.imaginaryPart);
        }
    }
    public synchronized ComplexNumber divide(ComplexNumber aComplexNumber)  throws IllegalArgumentException {
        synchronized (list) {
            if (aComplexNumber == null) {
                throw new IllegalArgumentException();
            }
            double a, b, c, d;
            a = this.realPart;
            b = this.imaginaryPart;
            c = aComplexNumber.getRealPart();
            d = aComplexNumber.getImaginaryPart();
            return new ComplexNumber((a * c + b * d) / (c * c + d * d), (b * c - a * d) / (c * c + d * d));
        }
    }
    public synchronized boolean equals(Object anObject){
        synchronized (list) {
            if (compareTo((ComplexNumber) anObject) == 0) {
                return true;
            }
            return false;
        }
    }
    public synchronized double getImaginaryPart(){
        synchronized (list) {
        return this.imaginaryPart;
    }
    }
    public synchronized double getRealPart(){
        synchronized (list) {
            return this.realPart;
        }
    }
    public synchronized int hashCode(){
        synchronized (list) {
            return super.hashCode();
        }
    }
    public synchronized ComplexNumber multiply(ComplexNumber aComplexNumber)  throws IllegalArgumentException {
        synchronized (list) {
            if (aComplexNumber == null) {
                throw new IllegalArgumentException();
            }
            return new ComplexNumber(this.realPart * aComplexNumber.getRealPart() - this.imaginaryPart * aComplexNumber.getImaginaryPart(),
                    this.imaginaryPart * aComplexNumber.getRealPart() + this.realPart * aComplexNumber.getImaginaryPart());
        }

    }
    public synchronized ComplexNumber reciprocal(){
        synchronized (list) {
            return new ComplexNumber(this.realPart / (this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart),
                    -this.imaginaryPart / (this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart));
        }
    }
    public synchronized void setImaginaryPart(double imaginaryPart){
        synchronized (list) {
            this.imaginaryPart = imaginaryPart;
        }
    }
    public synchronized void setRealPart(double realPart){
        synchronized (list) {
            this.realPart = realPart;
        }
    }
    public synchronized ComplexNumber subtract(ComplexNumber aComplexNumber) throws IllegalArgumentException {
        synchronized (list) {
            if (aComplexNumber == null) {
                throw new IllegalArgumentException();
            }
            return new ComplexNumber(this.realPart - aComplexNumber.getRealPart(), this.imaginaryPart - aComplexNumber.getImaginaryPart());
        }
    }
    public synchronized String toString(){
        synchronized (list) {
            if (this.imaginaryPart >= 0) {
                return String.format("%.6f", this.realPart) + " + " + String.format("%.6f", this.imaginaryPart) + "i";
            } else {
                return String.format("%.6f", this.realPart) + " - " + String.format("%.6f", -this.imaginaryPart) + "i";
            }
        }
    }

}
