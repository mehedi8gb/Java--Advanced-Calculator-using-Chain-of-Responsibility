package view;

import javax.swing.*;
import controller.Calculator;

public class CalculatorGUI extends JFrame {
    private JTextField textField;
    private JLabel resultLabel;

    public CalculatorGUI() {
        JPanel panel = new JPanel();
        Calculator calculator = new Calculator();
        textField = new JTextField(20);
        resultLabel = new JLabel("Result: 0.000");

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> {
            calculator.calculate(textField.getText());
            resultLabel.setText("Result: " + Double.toString(calculator.getFloatResult()));
        });

        panel.add(textField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
