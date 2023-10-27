package firstWeb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSystemConverter {
    private JFrame frame;
    private JTextField inputField1, inputField2, outputField;
    private JComboBox<String> numberSystemDropdown;

    public NumberSystemConverter() {
        frame = new JFrame("Number System Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        JLabel label1 = new JLabel("Input 1:");
        label1.setBounds(20, 20, 80, 25);
        frame.add(label1);

        inputField1 = new JTextField();
        inputField1.setBounds(100, 20, 200, 25);
        frame.add(inputField1);

        JLabel label2 = new JLabel("Input 2:");
        label2.setBounds(20, 50, 80, 25);
        frame.add(label2);

        inputField2 = new JTextField();
        inputField2.setBounds(100, 50, 200, 25);
        frame.add(inputField2);

        JLabel systemLabel = new JLabel("Number System:");
        systemLabel.setBounds(20, 80, 100, 25);
        frame.add(systemLabel);

        String[] numberSystems = {"Binary", "Octal", "Decimal", "Hexadecimal"}; // Add more number systems as needed
        numberSystemDropdown = new JComboBox<>(numberSystems);
        numberSystemDropdown.setBounds(130, 80, 150, 25);
        frame.add(numberSystemDropdown);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(20, 120, 100, 25);
        frame.add(convertButton);

        outputField = new JTextField();
        outputField.setBounds(130, 120, 200, 25);
        outputField.setEditable(false);
        frame.add(outputField);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = inputField1.getText();
                String input2 = inputField2.getText();
                String selectedSystem = (String) numberSystemDropdown.getSelectedItem();

                try {
                    int num1 = Integer.parseInt(input1);
                    int num2 = Integer.parseInt(input2);
                    int sum = num1 + num2;
                    String result = "";

                    switch (selectedSystem) {
                        case "Binary":
                            result = Integer.toBinaryString(sum);
                            break;
                        case "Octal":
                            result = Integer.toOctalString(sum);
                            break;
                        case "Decimal":
                            result = String.valueOf(sum);
                            break;
                        case "Hexadecimal":
                            result = Integer.toHexString(sum);
                            break;
                    }

                    outputField.setText(result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter valid decimal numbers.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberSystemConverter();
            }
        });
    }
}
