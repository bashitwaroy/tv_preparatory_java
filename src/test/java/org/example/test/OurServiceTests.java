package org.example.test;

import tv.example.MockedService;
import tv.example.OurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Here we mock the third party/cloud service interface - MockedService, since we do not have any control on the implementation
 */

public class OurServiceTests {
    OurService ourService;
    MockedService mockedService = mock(MockedService.class);


    @BeforeEach
    void init() {
        ourService = new OurService(mockedService);
    }

    /**
     * We want to test only our method - perform(int, int) which uses the third party functionality - add(int, int)
     */
    @Test
    public void testPerform() {
        when(mockedService.add(2, 3)).thenReturn(5);
        assertEquals(5, ourService.perform(2, 3), () -> "the sum does not match expected");
        verify(mockedService).add(2, 3);
    }
}
