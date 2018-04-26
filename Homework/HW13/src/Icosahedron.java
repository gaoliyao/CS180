/**
 * Created by mars on 4/21/18.
 */
public class Icosahedron extends Polyhedron {
    public Icosahedron(double sideLength) throws IllegalArgumentException{
        super(sideLength);
    }
    //5.0 * sqrt(3.0) * (sideLength)^

    public static int value;
    int a;
    int b;
    int c;
    int d;
    @Override
    public double getSurfaceArea() {
        return 5.0 * Math.sqrt(3) * Math.pow(getSideLength(), 2);
    }

    @Override
    public String toString() {
        return "Icosahedron[" + String.format("%f", getSideLength()) + "]";
    }

    public boolean equals(Object anObject){
        if (anObject instanceof Icosahedron){
            if (((Polyhedron) anObject).getSideLength() == this.getSideLength()){
                return true;
            }
        }
        return false;
    }

    // ((15.0 + (5.0 * sqrt(5.0))) / 12.0) * (sideLength)^3
    @Override
    public double getVolume() {
        return ((15.0 + (5.0 * Math.sqrt(5.0))) / 12.0) * Math.pow(getSideLength(), 3);
    }


}
