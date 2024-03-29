package org.example.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tv.example.ArrivalDep;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Below test class uses Junit concepts like Nested Class, assertThrows
 * Injected dependencies like TestInfo and TestReporter
 */

@DisplayName("Test Cases for ArrivalDep Class")
public class ArrivalDepTests {

    ArrivalDep arrivalDep;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        arrivalDep = new ArrivalDep();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        Map<String, String> testReports = Map.ofEntries(
                entry("test info: ", testInfo.toString()));
        testReporter.publishEntry(testReports);
    }

    @DisplayName("tests for minimum number of platforms")
    @Nested
    class MinimumNumberOfPlatformTests {

        @Test
        @DisplayName("check if the train time list is empty or invalid")
        void checkForInvalidTrainTimes() {
            assertAll(() -> assertEquals(1, arrivalDep.getMinimumNumberOfPlatforms(Collections.<Integer>emptyList(), Collections.<Integer>emptyList()),
                            "test failed when train time table is empty"),
                    () -> assertEquals(1, arrivalDep.getMinimumNumberOfPlatforms(new ArrayList<>(), new ArrayList<>()),
                            "test failed when train time table contains null entries"),
                    () -> assertThrows(NullPointerException.class, () -> arrivalDep.getMinimumNumberOfPlatforms(null, null)));
        }

        @ParameterizedTest(name = "{0}")
        @MethodSource("checkMinimumNumberOfTrainsData")
        @DisplayName("check if there is more than one train in the list")
        void checkMinimumNumberOfTrains(String testCaseName, List<Integer> arrList, List<Integer> depList) {
            assertEquals(1, arrivalDep.getMinimumNumberOfPlatforms(arrList, depList),
                    () -> "test failed when there is only one train in the time table");
        }

        @ParameterizedTest(name = "{0}")
        @MethodSource("getMinimumNumberOfPlatformsTestData")
        @DisplayName("happy path - more than one trains present on the time table")
        void getMinimumNumberOfPlatforms(String testCaseName, int expected, List<Integer> arrList, List<Integer> depList) {

            assertEquals(expected, arrivalDep.getMinimumNumberOfPlatforms(arrList, depList),
                    () -> "happy path test cases for minimum number of platforms failed");
        }

        private static Stream<Arguments> checkMinimumNumberOfTrainsData() {
            return Stream.of(Arguments.of("single train test case 1", new ArrayList<>(Arrays.asList(1100)), new ArrayList<>(Arrays.asList(1200))),
                    Arguments.of("single train test case 2", new ArrayList<>(Arrays.asList(1300)), new ArrayList<>(Arrays.asList(1330))));
        }

        private static Stream<Arguments> getMinimumNumberOfPlatformsTestData() {
            return Stream.of(Arguments.of("multiple train test case 1", 2, new ArrayList<>(Arrays.asList(1300, 1400, 1530, 1700)), new ArrayList<>(Arrays.asList(1330, 1410, 1800, 1830))),
                    Arguments.of("multiple train test case 2", 1, new ArrayList<>(Arrays.asList(1300, null, 1400)), new ArrayList<>(Arrays.asList(1330, null))));
        }
    }

}
