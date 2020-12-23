package blogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculationsTest {
    private final Calculations cut = new Calculations();

    static Stream<Arguments> multiplyData() {
        return Stream.of(
                arguments(0, 5, 0),
                arguments(5, 0, 0),
                arguments(2, 2, 4),
                arguments(2.1, 2, 4.2),
                arguments(1, 1, 1),
                arguments(9, 2, 18),
                arguments(0, 0, 0)
        );
    }

    @ParameterizedTest(name = "Multiply. Input data is {0}, {1}")
    @MethodSource("multiplyData")
    void multiply(double num1, double num2, double expected) {
        double actual = cut.multiply(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> sumData() {
        return Stream.of(
                arguments(1, 2, 3),
                arguments(2, 2, 4),
                arguments(2.3, 2.3, 4.6),
                arguments(90, 5, 95),
                arguments(0, 0, 0),
                arguments(-1, 2, 1),
                arguments(-10, 2, -8)
        );
    }

    @ParameterizedTest(name = "Sum. Input data is {0}, {1} ")
    @MethodSource("sumData")
    void sum(double num1, double num2, double expected) {
        double actual = cut.sum(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> minusData() {
        return Stream.of(
                arguments(1, 2, -1),
                arguments(0, 0, 0),
                arguments(0, -1, 1),
                arguments(0.5, -1, 1.5),
                arguments(10, 5, 5),
                arguments(800, 200, 600),
                arguments(15, -15, 30),
                arguments(-15, 15, -30),
                arguments(10.1, 5.1, 5),
                arguments(-15, -15, 0)
        );
    }

    @ParameterizedTest(name = "Minus. Input data is {0}, {1}")
    @MethodSource("minusData")
    void minus(double num1, double num2, double expected) {
        double actual = cut.minus(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> divinityData() {
        return Stream.of(
                arguments(2, 2, 1),
                arguments(20.2, 2, 10.1),
                arguments(20, -2, -10),
                arguments(25, 5, 5),
                arguments(-2, 2, -1),
                arguments(80, 10, 8)
        );
    }

    @ParameterizedTest(name = "Divinity. Input data {0}, {1}")
    @MethodSource("divinityData")
    void divinity(double num1, double num2, double expected) {
        double actual = cut.divinity(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> moduloData() {
        return Stream.of(
                arguments(1, 2, 1),
                arguments(10, 2, 0),
                arguments(10, 5, 0),
                arguments(11, 5, 1),
                arguments(65, 5, 0),
                arguments(33, 30, 3),
                arguments(999, 990, 9)
        );
    }

    @ParameterizedTest(name = "Modulo. Input data {0}, {1}")
    @MethodSource("moduloData")
    void modulo(double num1, double num2, double expected) {
        double actual = cut.modulo(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void testDivinity_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cut.divinity(8, 0);
        }, "Incorrect value second number. Second number should not be 0.");
    }

    @Test
    public void testModulo_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cut.modulo(3, 0);
        }, "Incorrect value second number. Second number should not be 0.");
    }
}
