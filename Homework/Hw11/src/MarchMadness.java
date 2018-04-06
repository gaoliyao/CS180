import javax.swing.*;

public class MarchMadness {

    public static void main(String[] args) {
	// write your code here
        JFrame frame = new JFrame();
        String teamOneName = "";
        String teamTwoName = "";
        while (true) {
            teamOneName = JOptionPane.showInputDialog("Enter the name of team one: ");
            if (!teamOneName.isEmpty()){
                break;
            }
            else{
                JOptionPane.showMessageDialog(frame,
                        "Eggs are not supposed to be green.",
                        "Inane error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        while (true) {
            teamTwoName= JOptionPane.showInputDialog("Enter the name of team two: ");
            if (!teamTwoName.isEmpty()){
                break;
            }
            else{

            }
        }
    }
}
