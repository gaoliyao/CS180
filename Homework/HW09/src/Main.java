public class Main {

    public static void main(String[] args){
        ComplexNumber operandOne = new ComplexNumber(5.0, 5.0);
        ComplexNumber operandTwo = new ComplexNumber(operandOne);
        ComplexNumber operandThree = new ComplexNumber(5.0, 7.5);
        System.out.println(new ComplexNumber(0.0,-1.0)); //displays 10.000000 + 10.000000i
        System.out.println(operandOne.equals(operandTwo)); //displays true
        System.out.println(operandOne.compareTo(operandThree)); //displays -1
    }
}
