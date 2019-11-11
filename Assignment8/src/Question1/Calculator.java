package Question1;

import javax.swing.*;
import java.awt.*;

public class Calculator extends Baseframe {

    private JLabel label1, label2, operatorLabel, resultLabel;
    private JTextField tf1, tf2;
    private JComboBox optionsBox;
    private JButton calculateButton;

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void create() {
        label1 = new JLabel("First Number");
        label2 = new JLabel("Second Number");
        operatorLabel = new JLabel("Operation");
        resultLabel = new JLabel("Result");

        tf1 = new JTextField(10);
        tf2 = new JTextField(10);

        optionsBox = new JComboBox(new String[]{"+", "-", "x", "/"});

        calculateButton = new JButton("Compute");
    }

    @Override
    public void add(Container con) {
        BoxLayout bl = new BoxLayout(con, 1); // placing components vertically
        con.setLayout(bl);

        addFirstComponent(con);
        addOptions(con);
        addSecondComponent(con);
        addResultsButton(con);
        addResultsLabel(con);
    }

    private void addFirstComponent(Container con) {
        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(tf1);

        con.add(panel);
    }

    private void addOptions(Container con) {
        JPanel panel = new JPanel();
        panel.add(operatorLabel);
        panel.add(optionsBox);

        con.add(panel);
    }

    private void addSecondComponent(Container con) {
        JPanel panel = new JPanel();
        panel.add(label2);
        panel.add(tf2);

        con.add(panel);
    }

    private void addResultsButton(Container con) {
        con.add(calculateButton);
    }

    private void addResultsLabel(Container con) {
        resultLabel.setPreferredSize(new Dimension(300, 50));

        con.add(resultLabel);
    }

    @Override
    public void addListeners() {
        calculateButton.addActionListener((e) -> calculateAndStoreResult());
    }

    void calculateAndStoreResult() {
        boolean isInvalidInput = false;

        int a = 0;
        try {
            a = Integer.parseInt(tf1.getText());
        } catch (RuntimeException re) {
            isInvalidInput = true;
            JOptionPane.showMessageDialog(this, "Number should be entered in the first text field");
        }

        int b = 0;
        try {
            b = Integer.parseInt(tf2.getText());
        } catch (RuntimeException re) {
            isInvalidInput = true;
            JOptionPane.showMessageDialog(this, "Number should be entered in the second text field");
        }

        String choice = optionsBox.getSelectedItem().toString();

        if (b == 0 && choice.equals("/")) {
            isInvalidInput = true;
            JOptionPane.showMessageDialog(this, "Denominator should not be 0");
        }

        if (isInvalidInput) {
            resultLabel.setText("No result to display");
        } else {
            int result = getResult(a, b, choice);

            String answer = a + " " + choice + " " + b + " = " + result;
            resultLabel.setText(answer);
        }
    }

    private int getResult(int a, int b, String choice) {
        if (choice.equals("+")) {
            return a + b;
        }
        if (choice.equals("-")) {
            return a - b;
        }
        if (choice.equals("x")) {
            return a * b;
        }

        return a / b;
    }
}
