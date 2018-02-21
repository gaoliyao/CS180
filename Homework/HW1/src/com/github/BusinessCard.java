import java.util.Scanner;

public class BusinessCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        String ageInput = sc.nextLine();
        int age = Integer.parseInt(ageInput);
        System.out.print("Enter your GPA: ");
        String GPA_input = sc.nextLine();
        double GPA = Double.parseDouble(GPA_input);
        System.out.print("Enter your major: ");
        String major = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.next();

        System.out.println("");

        System.out.println("Name:" + "\t" + name);
        System.out.println("Age:" + "\t" + Integer.toString(age));
        System.out.println("GPA:" + "\t" + String.format("%.2f", GPA));
        System.out.println("Major:" + "\t" + major);
        System.out.println("Email:" + "\t" + email);

    }
}
