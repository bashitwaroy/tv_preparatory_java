package org.example.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import tv.example.CollectionQ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test cases for CollectionQ methods")
public class CollectionQTests {

    CollectionQ collectionQ;

    @BeforeEach
    void init() {
        collectionQ = new CollectionQ();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("findDuplicatesTestData")
    public void findDuplicatesFromListTests(String testCaseName, Set<Integer> expected, List<Integer> inputList) {
        assertEquals(expected, collectionQ.findDuplicatesFromList(inputList), "the set with duplicates does not match");
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void findDuplicatesFromNullList(List list) {
        assertEquals(Set.of(), collectionQ.findDuplicatesFromList(list));
    }

    @Test
    public void testForExceptions() {
        assertThrows(NullPointerException.class, ()-> collectionQ.findDuplicatesFromList(List.of(1,1,null,1,2,2,5)));
    }

    private static Stream<Arguments> findDuplicatesTestData() {
        return Stream.of(Arguments.of("basic test of finding duplicates from list", Set.of(1, 9), List.of(1, 1, 1, 5, 7, 9, 9, 9, 9, 1, 3)),
                Arguments.of("when the input list has only one entry", Set.of(), List.of(2)),
                Arguments.of("when the input list has no duplicate elements", Set.of(), List.of(1,2,3,4,5)));
    }
}
