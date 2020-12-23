package listeners;

import blogic.Calculations;
import utils.Constants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private final TextField firstNum;
    private final TextField secondNum;
    private final TextField operation;
    private final TextField output;
    private final Calculations calculations;

    public ButtonClickListener(TextField firstNum, TextField secondNum, TextField operation, TextField output, Calculations calculations) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operation = operation;
        this.output = output;
        this.calculations = calculations;
    }

    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(firstNum.getText());
        double num2 = Double.parseDouble(secondNum.getText());
        char operationSymbol = operation.getText().charAt(0);
        double result;
        switch (operationSymbol) {
            case '*':
                result = calculations.multiply(num1, num2);
                break;
            case '/':
                result = calculations.divinity(num1, num2);
                break;
            case '-':
                result = calculations.minus(num1, num2);
                break;
            case '+':
                result = calculations.sum(num1, num2);
                break;
            case '%':
                result = calculations.modulo(num1, num2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operationSymbol);
        }
        output.setText(String.valueOf(result));
    }
}
