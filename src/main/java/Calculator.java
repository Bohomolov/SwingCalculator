import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    JButton operationPlus, operationMinus, operationMultiply, operationDivision, operationD, button;
    JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    TextField number1, number2, output;
    int firstField, secondField;
    String string1, string2;
    Listener listener = new Listener();

    public Calculator(String s) {
        super(s);
        number1 = new TextField();
        number2 = new TextField();
        jLabel1 = new JLabel("Enter first number");
        jLabel2 = new JLabel("Enter second number");
        jLabel3 = new JLabel("Select operation");
        jLabel4 = new JLabel("Your result");
        operationPlus = new JButton("+");
        operationMinus = new JButton("-");
        operationMultiply = new JButton("*");
        operationDivision = new JButton("/");
        operationD = new JButton("%");
        output = new TextField();
        button = new JButton("Calculate");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 350);
        setTitle("Calculator");
        setResizable(false);

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);
        jLabel1.setBounds(70, 5, 400, 10);
        jLabel2.setBounds(70, 65, 400, 10);
        jLabel3.setBounds(70, 125, 400, 10);
        jLabel4.setBounds(70, 245, 400, 10);
        setLayout(null);
        setFocusable(true);
        add(button);
        button.setBounds(70, 200, 400, 30);

        add(number1);
        number1.setBounds(70, 20, 400, 30);

        add(number2);
        number2.setBounds(70, 80, 400, 30);

        add(operationPlus);
        operationPlus.setBounds(70, 140, 50, 30);
        add(operationMinus);
        operationMinus.setBounds(130, 140, 50, 30);
        add(operationMultiply);
        operationMultiply.setBounds(190, 140, 50, 30);
        add(operationDivision);
        operationDivision.setBounds(250, 140, 50, 30);
        add(operationD);
        operationD.setBounds(310, 140, 50, 30);

        add(output);
        output.setBounds(70, 260, 400, 30);
        output.setEditable(false);
        operationPlus.addActionListener(listener);
        operationD.addActionListener(listener);
        operationMinus.addActionListener(listener);
        operationMultiply.addActionListener(listener);
        operationDivision.addActionListener(listener);
        button.addActionListener(listener);
    }

    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            firstField = Integer.parseInt(number1.getText());
            secondField = Integer.parseInt(number2.getText());

            if (event.getSource() == operationPlus) {
                    output.setText(String.valueOf(firstField + secondField));
            }else if (event.getSource() == operationMinus) {
                output.setText(String.valueOf(firstField - secondField));
            }else if (event.getSource() == operationMultiply) {
                output.setText(String.valueOf(firstField * secondField));
            }else if (event.getSource() == operationDivision) {
                output.setText(String.valueOf(firstField / secondField));
            }else if (event.getSource() == operationD) {
                output.setText(String.valueOf(firstField % secondField));
            }
        }
    }
}


