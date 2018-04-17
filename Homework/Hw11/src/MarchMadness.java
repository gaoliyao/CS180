import javax.swing.*;
import java.util.Random;

public class MarchMadness {

    public static void main(String[] args) {
        // write your code here
        boolean isContinue = true;
        while (isContinue) {
            JFrame frame = new JFrame();
            String teamOneName = "";
            String teamTwoName = "";
            while (true) {
                teamOneName = JOptionPane.showInputDialog("Enter the name of team one: ");
                if (!teamOneName.isEmpty()) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid Input",
                            "March Madness Simulator",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            while (true) {
                teamTwoName = JOptionPane.showInputDialog("Enter the name of team two: ");
                if (!teamTwoName.isEmpty()) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid Input",
                            "March Madness Simulator",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            int teamOneWinPercentage = -1;
            int teamTwoWinPercentage = -1;

            while (true) {
                teamOneWinPercentage = Integer.parseInt(JOptionPane.showInputDialog("Enter team one's win percentage: "));
                if (teamOneWinPercentage >= 0 && teamOneWinPercentage <= 100) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid Input: The win percentage must be between 0 and 100",
                            "March Madness Simulator",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            while (true) {
                teamTwoWinPercentage = Integer.parseInt(JOptionPane.showInputDialog("Enter team two's win percentage: "));
                if (teamTwoWinPercentage >= 0 && teamTwoWinPercentage <= 100) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid Input: The win percentage must be between 0 and 100",
                            "March Madness Simulator",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            Integer[] numbers = {20, 15, 10, 5};

            int n = JOptionPane.showOptionDialog(null,
                    "Choose the number of simulations you want to run",
                    "March Madness Simulator",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    numbers,
                    numbers[3]);
            n = 20 - n * 5;
            System.out.println(teamOneName);
            System.out.println(teamTwoName);
            System.out.println(n);

            int teamOneWinTime = 0;
            int teamTwoWinTime = 0;

            Random random = new Random();
            for (int i = 0; i < n; i++) {
                int rn = random.nextInt(100);
                if (rn >= teamOneWinPercentage) {
                    teamTwoWinTime++;
                } else {
                    teamOneWinTime++;
                }
            }
            System.out.println(teamOneWinTime);
            System.out.println(teamTwoWinTime);
            JOptionPane.showMessageDialog(frame,
                    teamOneName + " Wins: " + Integer.toString(teamOneWinTime) + " " +
                            teamTwoName + " Wins: " + Integer.toString(teamTwoWinTime),
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);

            String[] options = {"No", "Yes"};
            int n2 = JOptionPane.showOptionDialog(null,
                    "Would you like to run another simulation?",
                    "March Madness Simulator",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (n2 == 0) {
                JOptionPane.showMessageDialog(frame,
                        "Thank you for simulating March Madness!",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                isContinue = false;
            }
            else{
                isContinue = true;
            }
        }
    }
}
