/**
 * Created by mars on 4/21/18.
 */
public class Tetrahedron extends Polyhedron{
    public Tetrahedron(double sideLength) throws IllegalArgumentException{
        super(sideLength);
    }

    @Override
    public double getSurfaceArea() {
        return Math.sqrt(3) * Math.pow(getSideLength(), 2);
    }
    //(sideLength)^3 / (6.0 * sqrt(2.0)
    @Override
    public double getVolume() {
        return Math.pow(getSideLength(), 3) / (6.0 * Math.sqrt(2));
    }
    public boolean equals(Object anObject){
        if (anObject instanceof Tetrahedron){
            if (((Polyhedron) anObject).getSideLength() == this.getSideLength()){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Tetrahedron[" + String.format("%f", getSideLength()) + "]";
    }
}
