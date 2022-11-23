package tv.example;

public class MinSteps {

    /**
     * Write a method to find the minimum number of steps/operations to reach a number 'm' from another number 'n'
     * arithmetic operations allowed are multiply by 2 and subtraction of 1
     * e.g - n = 5, m = 12 min steps = 4
     * @param n starting number
     * @param m destination number
     * @return minimum number of steps
     */
    public int getMinimumSteps(int n, int m) {
        int minSteps = 0;

        while (m > n) {
            // If m is odd, add 1
            if (m % 2 != 0) {
                m++;
                minSteps++;
            }
            m /= 2;
            minSteps++;
        }
        return minSteps + n - m;
    }
}
