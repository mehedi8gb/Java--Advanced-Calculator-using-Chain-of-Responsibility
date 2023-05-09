package view;

import javax.swing.*;
import controller.Calculator;
import java.awt.event.*;

public class CalculatorGUI extends JFrame{
        JPanel panel;
        JTextField textField;
        JLabel resultLabel;

    public CalculatorGUI() {
        this.panel = new JPanel();

        this.textField = new JTextField(20);
        this.resultLabel = new JLabel("Result: 0.00000");

        final JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                final Calculator calculator = new Calculator();
                calculator.calculate(CalculatorGUI.this.textField.getText());
                CalculatorGUI.this.resultLabel.setText("Result: " + Double.toString(calculator.getFloatResult()));
            }
        });

        this.panel.add(this.textField);
        this.panel.add(calculateButton);
        this.panel.add(this.resultLabel);

        add(this.panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
