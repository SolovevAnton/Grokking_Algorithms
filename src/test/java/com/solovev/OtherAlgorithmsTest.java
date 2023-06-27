package com.solovev;

import org.junit.Test;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.solovev.model.OtherAlgorithms.binarySearch;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Unit test for algorithms
 */
public class OtherAlgorithmsTest {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final List<Integer>[] testCasesSorted = new List[]{
            new ArrayList<Integer>(List.of(1)),
            new ArrayList<Integer>(List.of(0, 0)),
            new ArrayList<Integer>(List.of(0, 0, 0)),
            new ArrayList<Integer>(List.of(1, 2)),
            new ArrayList<Integer>(List.of(1, 2, 3)),
            new ArrayList<Integer>(List.of(1, 2, 3, 4)),
            new ArrayList<Integer>(List.of(-4, -3, -2, -1)),
            new ArrayList<>(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE))
    };
    private final List<Integer> nullList = null;
    private final List<Integer> emptyList = List.of();
    private static final int NUMBER_OF_RANDOM_TESTS = 500;


    //RandomLists creation
    private List<Integer> myRandom() {
        int maxListLength = 1000;

        List<Integer> randomList = new ArrayList<>();
        int length = random.nextInt(maxListLength) + 1; // since random lists cannot be empty

        int currentValue = random.nextInt();
        randomList.add(currentValue);

        for (int n = 1; n < length; n++) {
            int numberToAdd = random.nextInt(currentValue,Integer.MAX_VALUE);
            randomList.add(numberToAdd);
            currentValue = numberToAdd;
        }
        return randomList;
    }

    /**
     * Generates random number not presented in given list
     *
     * @param list list to check
     * @return number not presented in this list
     */
    private Integer notPresentedInList(List<Integer> list) {
        int number = random.nextInt();
        return !list.contains(number) ? number : notPresentedInList(list);
    }


    @Test
    public void testBinarySearchNotFound() {
        int valueToLookFor = 100;
        assertEquals(-1, binarySearch(emptyList, valueToLookFor));
        for (List<Integer> testCase : testCasesSorted) {
            assertEquals(-1, binarySearch(testCase, valueToLookFor));
        }
    }

    @Test
    @RepeatedTest(NUMBER_OF_RANDOM_TESTS)
    public void testBinarySearchNotFoundRandom() {
        List<Integer> randomList = myRandom();
        int numberToLookFor = notPresentedInList(randomList);
        String message = String.format("For list %s and value %s", randomList, numberToLookFor);
        assertEquals(message, -1, binarySearch(randomList, numberToLookFor));
    }

    @Test
    public void testNullPointer() {
        Assumptions.assumingThat(emptyList == null, () -> assertThrows(NullPointerException.class, () -> binarySearch(emptyList, 0)));
        assertThrows(NullPointerException.class, () -> binarySearch(nullList, 0));
    }

    @Test
    public void testBinarySearchFoundCasesFirstElement() {
        for (List<Integer> testCase : testCasesSorted) {
            int indexOfElement = 0;//always 0 element
            int numberToLookFor = testCase.get(indexOfElement);
            int foundIndex = binarySearch(testCase, numberToLookFor);
            assertEquals(testCase.get(0), testCase.get(foundIndex));
        }
    }

    @Test
    public void testBinarySearchFoundCasesLastElement() {
        for (List<Integer> testCase : testCasesSorted) {
            int indexOfElement = testCase.size() - 1;//always last element
            int numberToLookFor = testCase.get(indexOfElement);

            int foundIndex = binarySearch(testCase, numberToLookFor);
            assertEquals(testCase.get(indexOfElement), testCase.get(foundIndex));
        }
    }

    @Test
    @RepeatedTest(NUMBER_OF_RANDOM_TESTS)
    public void testBinarySearchFoundCasesRandom() {
        List<Integer> randomList = myRandom();

        int indexOfElement = random.nextInt(randomList.size());
        int numberToLookFor = randomList.get(indexOfElement);
        int foundIndex = binarySearch(randomList, numberToLookFor);

        String message = String.format("For list %s and value %s", randomList, numberToLookFor);
        assertEquals(message, randomList.get(indexOfElement), randomList.get(foundIndex));
    }
}



