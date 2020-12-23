package viev;

import blogic.Calculations;
import listeners.ButtonClickListener;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final TextField number1;
    private final TextField number2;
    private final TextField operation;
    private final TextField output;
    private final JButton result;


    public Calculator(String s) {
        super(s);
        number1 = new TextField();
        number2 = new TextField();
        operation = new TextField();
        jLabel1 = new JLabel(Constants.FIRST_NUMBER);
        jLabel2 = new JLabel(Constants.SECOND_NUMBER);
        jLabel3 = new JLabel(Constants.SELECT_OPERATION);
        jLabel4 = new JLabel(Constants.RESULT);
        output = new TextField();
        result = new JButton();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 350);
        setTitle(Constants.CALCULATOR);

        setVisible(true);
        setResizable(false);
        setLayout(null);
        setFocusable(true);

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);
        jLabel1.setBounds(70, 5, 400, 10);
        jLabel2.setBounds(70, 65, 400, 10);
        jLabel3.setBounds(70, 125, 400, 10);
        jLabel4.setBounds(70, 245, 400, 10);

        add(number1);
        number1.setBounds(70, 20, 400, 30);

        add(number2);
        number2.setBounds(70, 80, 400, 30);

        add(operation);
        operation.setBounds(70, 140, 400, 30);

        add(result);
        result.setBounds(70, 200, 400, 30);
        result.setText("Result");

        add(output);
        output.setBounds(70, 260, 400, 30);
        output.setEditable(false);

        ActionListener listener = new ButtonClickListener(number1, number2, operation, output, new Calculations());
        result.addActionListener(listener);
    }
}
