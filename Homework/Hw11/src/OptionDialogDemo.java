import javax.swing.*;

/**
 * Created by mars on 4/7/18.
 */
public class OptionDialogDemo {
    public static void main(String[] args){
        String[] numbers = {"Hi", "H", "i", "!"};

        int n = JOptionPane.showOptionDialog(null,
                "Choose the number of simulations you want to run",
                "March Madness Simulator",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                numbers,
                numbers[3]);
        System.out.println(numbers[n]);
    }
}
