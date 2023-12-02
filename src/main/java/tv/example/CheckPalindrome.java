package tv.example;

public class CheckPalindrome {

    public boolean isPalindrome(String inputStr, int start, int end) {

        if (inputStr == null || inputStr.isEmpty())
            return false;
        if (start >= end) {
            return true;
        }
        if (inputStr.charAt(start) == inputStr.charAt(end)) {
            return isPalindrome(inputStr, start + 1, end - 1);
        } else {
            return false;
        }
    }
}
