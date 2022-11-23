package org.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tv.example.MinSteps;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test cases for MinSteps class")
public class MinStepsTests {

    MinSteps minSteps;

    @BeforeEach
    void init() {
        minSteps = new MinSteps();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("validTestScenariosData")
    void validTestScenarios(String testCaseName, int number1, int number2, int expected) {
        assertEquals(expected, minSteps.getMinimumSteps(number1, number2), "test case failed : " + testCaseName);
    }

    private static Stream<Arguments> validTestScenariosData() {
        return Stream.of(Arguments.of("When number1 is less than number2", 5, 12, 4),
                Arguments.of("When number1 is greater than number2", 22, 15, 7),
                Arguments.of("When number1 is equal to number2", 5, 5, 0));
    }
}
