import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class ConfirmationFrame extends JFrame{
    
    //frame components
    JPanel labelContainer;
    JLabel label;
    String text;

    JButton confirm;
    JButton cancel;

    
    //JFrame constructor
    public ConfirmationFrame(){

        //Frame components
        this.setTitle("Appointment Confirmation");
        this.setVisible(true);
        this.setSize(800, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel (label container) components
        Border border = BorderFactory.createLineBorder(Color.black, 3);

        labelContainer = new JPanel();
        labelContainer.setBounds(0, 0, 784, 250);
        labelContainer.setBackground(Color.CYAN);
        labelContainer.setBorder(border);
        this.add(labelContainer);

        //top label components
        text = "<br><br>Is this correct?<br><br>Placeholder text";
        label = new JLabel("<html><div style ='text-align: center;'" + text + "</div></html>");
        //label.setBounds(0, 25, 800, 225);
        //label.setVerticalAlignment(SwingConstants.CENTER);
        //label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Verdana", Font.PLAIN, 22));
        labelContainer.add(label);

        //button to confirm
        confirm = new JButton();
        confirm.setFocusable(false);
        confirm.setText("Confirm");
        confirm.setBounds(270, 275, 100, 50);
        this.add(confirm);

        //bottun to cancel
        cancel = new JButton();
        cancel.setFocusable(false);
        cancel.setText("Cancel");
        cancel.setBounds(430, 275, 100, 50);
        this.add(cancel);

        this.repaint();

    }

}
