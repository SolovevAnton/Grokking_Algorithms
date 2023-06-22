package com.solovev;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static com.solovev.model.OtherAlgorithms.binarySearch;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Unit test for algorithms
 */
public class otherAlgorithmsTest {
    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private List<Integer>[] testCasesSorted = new List[]{
            new ArrayList<Integer>(List.of(1)),
            new ArrayList<Integer>(List.of(0, 0)),
            new ArrayList<Integer>(List.of(0, 0, 0)),
            new ArrayList<Integer>(List.of(1, 2)),
            new ArrayList<Integer>(List.of(1, 2, 3)),
            new ArrayList<Integer>(List.of(1, 2, 3, 4)),
            new ArrayList<Integer>(List.of(-4, -3, -2, -1)),
            new ArrayList<>(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE))
    };
    private List<Integer> nullList = null;
    private List<Integer> emptyList = List.of();
    private List<Integer>[] randomLists = myRandom();

    //RandomLists creation
    private List<Integer>[] myRandom() {
        int numberOfLists = 100;
        List<Integer>[] result = new List[numberOfLists];
        int maxListLength = 1000;
        for (int i = 0; i < numberOfLists; i++) {
            int length = random.nextInt(maxListLength) + 1; //since random lists cannot be empty
            List<Integer> randomList = new ArrayList<>(length);
            //fill random list in sorted order
            randomList.add(random.nextInt());
            for (int n = 1; n < length; n++) {
                int numberToAdd = random.nextInt(randomList.get(n - 1), Integer.MAX_VALUE); //guarantees next value is more then prev
                randomList.add(numberToAdd);
            }
            result[i] = randomList;
        }
        return result;
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
    public void testBinarySearchNotFoundRandom() {
        for (List<Integer> randomList : randomLists) {
            int numberToLookFor = notPresentedInList(randomList);
            assertEquals(-1, binarySearch(randomList, numberToLookFor));
        }
    }

    @Test
    public void testNullPointer() {
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
            int indexOfElement = testCase.size() -1;//always last element
            int numberToLookFor = testCase.get(indexOfElement);

            int foundIndex = binarySearch(testCase, numberToLookFor);
            assertEquals(testCase.get(indexOfElement), testCase.get(foundIndex));
        }
    }

    @Test
    public void testBinarySearchFoundCasesRandom() {
        for (List<Integer> randomList : randomLists) {
            int indexOfElement = random.nextInt(randomList.size());
            int numberToLookFor = randomList.get(indexOfElement);
            int foundIndex = binarySearch(randomList, numberToLookFor);

            assertEquals(randomList.get(indexOfElement), randomList.get(foundIndex));
        }
    }
}


