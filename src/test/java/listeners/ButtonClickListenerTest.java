package listeners;

import blogic.Calculations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import utils.Constants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ButtonClickListenerTest {
    private final TextField textField1 = Mockito.mock(TextField.class);
    private final TextField textField2 = Mockito.mock(TextField.class);
    private final TextField textOperation = Mockito.mock(TextField.class);
    private final TextField textOutput = Mockito.mock(TextField.class);
    private final Calculations calculations = Mockito.mock(Calculations.class);
    private final ButtonClickListener cut = new ButtonClickListener(textField1, textField2, textOperation, textOutput, calculations);

    static Stream<Arguments> nominalOperationTestData() {
        return Stream.of(
                arguments("1.1", "2.2", "3.3", 1.1, 2.2, 3.3),
                arguments("5.1", "5.1", "10.2", 5.1, 5.1, 10.2),
                arguments("9.0", "1.0", "10.0", 9.0, 1.0, 10.0),
                arguments("90.0", "2.0", "92.0", 90.0, 2.0, 92.0),
                arguments("-90.0", "2.0", "-88.0", -90.0, 2.0, -88.0),
                arguments("35.5", "25.7", "61.2", 35.5, 25.7, 61.2)
        );
    }

    @ParameterizedTest(name = "Plus. Input data is {0}, {1}")
    @MethodSource("nominalOperationTestData")
    void sumTest(String num1Str, String num2Str, String resultStr, double num1, double num2, double result) {
        String operation = "+";
        Mockito.when(textField1.getText()).thenReturn(num1Str);
        Mockito.when(textField2.getText()).thenReturn(num2Str);
        Mockito.when(textOperation.getText()).thenReturn(operation);
        Mockito.when(calculations.sum(num1, num2)).thenReturn(result);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textOutput, Mockito.only()).setText(resultStr);
    }

    static Stream<Arguments> minusOperationDataTest() {
        return Stream.of(
                arguments("1.0", "1.0", "0.0", 1.0, 1.0, 0.0),
                arguments("5.0", "3.0", "2.0", 5.0, 3.0, 2.0),
                arguments("10.9", "5.4", "5.5", 10.9, 5.4, 5.5),
                arguments("5.0", "-5.0", "0.0", 5.0, -5.0, 0.0),
                arguments("-8.3", "0.3", "-8.6", -8.3, 0.3, -8.6),
                arguments("-4.0", "-4.0", "0.0", -4.0, -4.0, 0.0)
        );
    }

    @ParameterizedTest(name = "Minus. Input data {0}, {1}")
    @MethodSource("minusOperationDataTest")
    void minusTest(String num1Str, String num2Str, String numResult, double num1, double num2, double result) {
        String operation = "-";

        Mockito.when(textField1.getText()).thenReturn(num1Str);
        Mockito.when(textField2.getText()).thenReturn(num2Str);
        Mockito.when(textOperation.getText()).thenReturn(operation);
        Mockito.when(calculations.minus(num1, num2)).thenReturn(result);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textOutput, Mockito.only()).setText(numResult);
    }

    static Stream<Arguments> multiplyOperationDataTest() {
        return Stream.of(
                arguments("1.0", "2.0", "2.0", 1.0, 2.0, 2.0),
                arguments("2.0", "1.0", "2.0", 2.0, 1.0, 2.0),
                arguments("5.0", "5.0", "25.0", 5.0, 5.0, 25.0),
                arguments("-1.0", "9.0", "-9.0", -1.0, 9.0, -9.0),
                arguments("1.0", "-9.0", "-9.0", 1.0, -9.0, -9.0),
                arguments("3.8", "2.0", "7.6", 3.8, 2.0, 7.6)
        );
    }

    @ParameterizedTest(name = "Multiply. Input data {0}, {1}")
    @MethodSource("multiplyOperationDataTest")
    void multiplyTest(String num1Str, String num2Str, String resultStr, double num1, double num2, double result) {
        String operation = "*";
        Mockito.when(textField1.getText()).thenReturn(num1Str);
        Mockito.when(textField2.getText()).thenReturn(num2Str);
        Mockito.when(textOperation.getText()).thenReturn(operation);
        Mockito.when(calculations.multiply(num1, num2)).thenReturn(result);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textOutput, Mockito.only()).setText(resultStr);
    }

    static Stream<Arguments> divinityOperationDataTest() {
        return Stream.of(
                arguments("2.0", "1.0", "2.0", 2.0, 1.0, 2.0),
                arguments("2.0", "-1.0", "-2.0", 2.0, -1.0, -2.0),
                arguments("9.0", "3.0", "3.0", 9.0, 3.0, 3.0),
                arguments("6.6", "2.2", "3.3", 6.6, 2.2, 3.3),
                arguments("80.0", "10.0", "8.0", 80.0, 10.0, 8.0),
                arguments("100.0", "2.0", "50.0", 100.0, 2.0, 50.0),
                arguments("44.4", "44.4", "1.0", 44.4, 44.4, 1.0),
                arguments("5.0", "2.0", "2.5", 5.0, 2.0, 2.5)
        );
    }

    @ParameterizedTest(name = "Divinity. Input data {0}, {1}")
    @MethodSource("divinityOperationDataTest")
    void divinityTest(String num1Str, String num2Str, String resultSting, double num1, double num2, double result) {
        String operation = "/";

        Mockito.when(textField1.getText()).thenReturn(num1Str);
        Mockito.when(textField2.getText()).thenReturn(num2Str);
        Mockito.when(textOperation.getText()).thenReturn(operation);
        Mockito.when(calculations.divinity(num1, num2)).thenReturn(result);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textOutput, Mockito.only()).setText(resultSting);
    }

    static Stream<Arguments> moduloOperationDataTest(){
        return Stream.of(
                arguments("2.0","2.0","0.0",2.0,2.0,0.0),
                arguments("13.0","10.0","3.0",13.0,10.0,3.0),
                arguments("80.0","8.0","0.0",80.0,8.0,0.0),
                arguments("30.5","3.0","0.5",30.5,3.0,0.5),
                arguments("4.0","3.0","1.0",4.0,3.0,1.0),
                arguments("5.9","3.0","2.9",5.9,3.0,2.9)
        );
    }
    @ParameterizedTest(name = "Modulo. Input data {0}, {1}")
    @MethodSource("moduloOperationDataTest")
    void moduloTest(String num1Str, String num2Str, String resultStr, double num1, double num2, double result){
        String operation = "%";

        Mockito.when(textField1.getText()).thenReturn(num1Str);
        Mockito.when(textField2.getText()).thenReturn(num2Str);
        Mockito.when(textOperation.getText()).thenReturn(operation);
        Mockito.when(calculations.modulo(num1,num2)).thenReturn(result);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textOutput,Mockito.only()).setText(resultStr);
    }
    static Stream<Arguments> exceptionDataTest(){
        return Stream.of(
                arguments("1.0","0.0", Constants.ILLEGAL_ARGUMENT,1.0,0.0)
        );
    }

    @ParameterizedTest(name = "Exception. Message is {2} ")
    @MethodSource("exceptionDataTest")
    void exceptionTest(String num1Str, String num2Str, String message, double num1,double num2){
       String operation = "/";

       Mockito.when(textField1.getText()).thenReturn(num1Str);
       Mockito.when(textField2.getText()).thenReturn(num2Str);
       Mockito.when(textOperation.getText()).thenReturn(operation);
       Mockito.when(calculations.divinity(num1,num2)).thenThrow(new ArithmeticException(message));

       cut.actionPerformed(Mockito.mock(ActionEvent.class));

       Mockito.verify(textOutput,Mockito.only()).setText(message);
    }
}
