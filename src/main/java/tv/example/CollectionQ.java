package tv.example;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CollectionQ {

    private static final Logger logger = Logger.getLogger("tv.example.CollectionQ");

    /**
     * the method returns a set containing integers that occur more than once in the list
     *
     * @param list - contains integer entries with or without multiple occurrence
     * @return set with only the duplicate elements
     */
    public Set<Integer> findDuplicatesFromList(List<Integer> list) {
        if (list == null)
            return Set.of();
        Set<Integer> setWithoutDuplicates = new HashSet<>();
        Set<Integer> setWithDuplicates = new HashSet<>();
        try {
            list.stream().forEach(p -> {
                if (!setWithoutDuplicates.add(p))
                    setWithDuplicates.add(p);
            });
        } catch (NullPointerException ne) {
            logger.log(Level.INFO, "the input list has null entries");
        }

        return setWithDuplicates;
    }

    /**
     * @param inputString - string that needs to be parsed to get the first non repeating character
     * @return unique character in the string that appears first from left
     */
    public char findFirstNonRepeatingCharacter(String inputString) {
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        inputString = inputString.toLowerCase();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (linkedHashMap.containsKey(c))
                linkedHashMap.put(c, linkedHashMap.get(c) + 1);
            else
                linkedHashMap.put(c, 1);
        }
        /* map the HashMap entries onto another map with only the non repeating characters and
        find the first element since a linked Hash map always keeps the insertion order
         */
        return linkedHashMap.entrySet().stream().filter(p -> p.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
