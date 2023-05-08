package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Calculator;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {

    public CalculatorGUI() {
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();

        JTextField textField = new JTextField(20);
        JLabel resultLabel = new JLabel("Result: 0.00");

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calculator calculator = new Calculator();
                calculator.calculate(textField.getText());
                resultLabel.setText("Result: " + Double.toString(calculator.getResult()));
            }
        });

        panel.add(textField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
