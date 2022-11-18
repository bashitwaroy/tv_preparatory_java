package tv.example;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrivalDep {

    private static final Logger logger = Logger.getLogger("tv.example.ArrivalDep");

    /**
     * Write a function to get the minimum number of platforms required based on arrival and departure time of trains
     * These times are provided in two lists in 24h format
     */
    public int getMinimumNumberOfPlatforms(List<Integer> arrList, List<Integer> depList) {

        if(arrList == null || depList == null)
            throw new NullPointerException();
        int result = 1;
        int noOfPlatforms = 1;
        try {
            for (int i = 0; i < depList.size(); i++) {
                for (int j = 0; j < arrList.size(); j++) {
                    if (arrList.get(i) >= arrList.get(j) && arrList.get(i) <= depList.get(j) && i != j) {
                        noOfPlatforms++;
                    }
                }
                result = Math.max(result, noOfPlatforms);
            }
        } catch (NullPointerException ne) {
            logger.log(Level.INFO, "Error - One of the entries in the list is null");
        }
        return result;
    }
}
