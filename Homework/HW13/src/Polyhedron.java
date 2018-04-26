/**
 * Created by mars on 4/21/18.
 */
public abstract class Polyhedron {
    private double sideLength;
    public Polyhedron(double sideLength) throws IllegalArgumentException{
        if (sideLength < 0){
            throw new IllegalArgumentException();
        }
        this.sideLength = sideLength;
    }
    public double getSideLength(){
        return this.sideLength;
    }
    public void setSideLength(double sideLength) throws IllegalArgumentException{
        if (sideLength < 0){
            throw new IllegalArgumentException();
        }
        this.sideLength = sideLength;
    }
    public boolean equals(Object anObject){
        if (anObject instanceof Polyhedron){
            if (((Polyhedron) anObject).sideLength == this.sideLength){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Polyhedron[" + String.format("%f", sideLength) +
                ']';
    }
    public abstract double getSurfaceArea();
    public abstract double getVolume();
}
