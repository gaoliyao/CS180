import java.util.Scanner;

public class BasicLoops {
    
    public static void main(String[] args) {
        boolean continueLoop = true;
        Scanner s = new Scanner(System.in);
        
        while(continueLoop == true){
            System.out.println("1. Sum of Numbers\n2. Decrements of 10\n3. Print Repetition\n4. Quit");
            int choice = s.nextInt();
             s.nextLine();
            if(choice == 1){
                //Request for two numbers and find the sum from the first number to the other number
                System.out.println("Enter a number: ");
                int one = s.nextInt();
                 s.nextLine();
                System.out.println("Enter a second number: ");
                int two = s.nextInt();
                 s.nextLine();
                int total = 0;
                for(int i = one; i <= two; i++){
                    total += i;
                }
                System.out.println("Total Sum: " + total);
              
            }else if(choice == 2){
               //Request for a number and print out decrements of 10 until the number is negative
                System.out.println("Enter a number: ");
                int number = s.nextInt();
                 s.nextLine();
                while(number >= 0){
                    number -= 10;
                    System.out.println(number);
                }
            }else if(choice == 3){
                //Print repetition and continue if the user inputs "y" or "Y"
                String nextIteration;
                do{
                   System.out.println("REPETITION");
                   System.out.println("Continue Printing Repetition? (\"y\" or \"Y\" to continue and anything else to exit)");
                   nextIteration = s.nextLine();
                }while(nextIteration.equalsIgnoreCase("Y"));
            }else if(choice == 4){
                continueLoop = false;
            }
        }
        
    }
    
}
