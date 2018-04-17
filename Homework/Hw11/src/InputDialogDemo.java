import javax.swing.*;

/**
 * Created by mars on 4/7/18.
 */
public class InputDialogDemo {
    public static void main(String[] args){
        String teamOneName = JOptionPane.showInputDialog("Enter the name of team one: ");
        System.out.println(teamOneName);
    }
}
