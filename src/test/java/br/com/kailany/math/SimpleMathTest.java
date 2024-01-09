package br.com.kailany.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

    SimpleMath math;
    double firstNumber;
    double secondNumber;

    @BeforeAll // antes de tudo
    static void setup() {
        System.out.println("Running @BeforeAll method");
    }

    @AfterAll // depois de tudo
    static void cleanup() {
        System.out.println("Running @AfterAll method");
    }

    @BeforeEach // antes de cada teste
    void beforeEachMethod() {
        System.out.println("Running @BeforeEach method");
        math = new SimpleMath();
        firstNumber = 6.2D;
        secondNumber = 2D;
    }

    @AfterEach // depois de cada teste
    void afterEachMethod() {
        System.out.println("Running @AfterEach method");
    }

    @Test
    @DisplayName("Test 6.2 + 2 = 8.8")
    void testSum() {
        System.out.println("Running testSum method");

        Double actual = math.sum(firstNumber, secondNumber);
        double expected = 8.2D;

        assertEquals(expected, actual,
                () -> firstNumber + "+" + secondNumber +
                        " did not produce " + expected + "!");
    }

    @Test
    void testSubtraction() {
        System.out.println("Running testSubtraction method");

        Double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 4.2D;

        assertEquals(expected, actual,
                () -> firstNumber + "-" + secondNumber +
                        " did not produce " + expected + "!");
    }

    @Test
    void testMultiplication() {
        System.out.println("Running testMultiplication method");

        Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 12.4D;

        assertEquals(expected, actual,
                () -> firstNumber + "*" + secondNumber +
                        " did not produce " + expected + "!");
    }

    @Test
    void testDivision() {
        System.out.println("Running testDivision method");

        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3.1D;

        assertEquals(expected, actual,
                () -> firstNumber + "/" + secondNumber +
                        " did not produce " + expected + "!");
    }

    @Test
    void testMean() {
        System.out.println("Running testMean method");

        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4.1D;

        assertEquals(expected, actual,
                () -> "(" + firstNumber + "+" + secondNumber + ")/2" +
                        " did not produce " + expected + "!");
    }

    @Test
    void testSquareRoot() {
        System.out.println("Running testSquareRoot method");

        double number = 81D;
        double expected = 9D;

        Double actual = math.squareRoot(number);

        assertEquals(expected, actual,
                () -> "Square Root of " + number +
                        " did not produce " + expected + "!");
    }

    @Test
    @DisplayName("Test with throws")
    void testWithThrows() {

        var expectedMessage = "Impossible to divide by zero";

        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
            math.division(firstNumber, 0D);
        });

        assertEquals(expectedMessage, actual.getMessage());
    }
}