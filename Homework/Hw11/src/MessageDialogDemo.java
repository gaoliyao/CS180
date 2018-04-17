import javax.swing.*;

/**
 * Created by mars on 4/7/18.
 */
public class MessageDialogDemo {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Eggs are not supposed to be green.",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }
}
