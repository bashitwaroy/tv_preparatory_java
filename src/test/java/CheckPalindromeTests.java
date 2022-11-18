import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tv.example.CheckPalindrome;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Cases for checking Palindrome string")
public class CheckPalindromeTests {

    CheckPalindrome checkPalindrome;

    @BeforeEach
    void init() {
        checkPalindrome = new CheckPalindrome();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("positiveTestCasesData")
    @DisplayName("Positive test cases with palindromic strings")
    public void testPositiveCases(String testCaseName, String str) {
        assertEquals(true, checkPalindrome.isPalindrome(str, 0 , str.length()-1), "");
    }

    private static Stream<Arguments> positiveTestCasesData() {
        return Stream.of(Arguments.of("test a palindromic string", "abba"),
                Arguments.of("test a longer palindromic string", "racecar"),
                Arguments.of("test a palindromic string with only whitespaces", "    "),
                Arguments.of("test a palindromic string with special characters", "%$^^$%"));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("negativeTestCasesData")
    public void testNegativeCases(String testCaseName, String str) {
        int end = 0;
        if(str!=null)
            end = str.length()-1;
        assertEquals(false, checkPalindrome.isPalindrome(str, 0, end));
    }

    private static Stream<Arguments> negativeTestCasesData() {
        return Stream.of(Arguments.of("null input string", null),
                Arguments.of("non palindromic string", "abc"),
                Arguments.of("string with uneven whitespaces", "a bb  a"));
    }
}
