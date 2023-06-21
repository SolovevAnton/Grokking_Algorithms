package com.solovev;

import static com.solovev.model.OtherAlgorithms.binarySearch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Unit test for algorithms
 */
public class AppTest {
    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private int randomMaxRange = Integer.MAX_VALUE; //to test with max value as not presented in random
    private int knownRandom = myRandom();
    private List<Integer>[] testCasesSorted = new List[] {
            new ArrayList<Integer>(List.of()),
            new ArrayList<Integer>(List.of(1)),
            new ArrayList<Integer>(List.of(1,2)),
            new ArrayList<Integer>(List.of(1,2,3,4)),
            new ArrayList<Integer>(List.of(-4,-3,-2,-1)),
            new ArrayList<>(List.of(Integer.MAX_VALUE,Integer.MIN_VALUE,0))
    };
    private List<Integer> nullList = null;
    private List<Integer> randomList =
    private List<Integer> myRandom(){
        List<Integer> result = new ArrayList<>();
        int numberOfLists = 100;
        int maxListLength = 1000;
        for(int i =0; i < numberOfLists;i++){

        }
        return result;
    }


    @Test
    public void testBinarySearchNotFound(){
        int valueToLookFor = Integer.MAX_VALUE;
        for(List<Integer> testCase:testCasesSorted){
            assertEquals(Optional.empty(),binarySearch(testCase,valueToLookFor));
        }
        assertEquals(Optional.empty(),binarySearch(randomList,valueToLookFor));
    }

    @Test
    public void testNullPointer(){
        assertThrows(NullPointerException.class,() -> binarySearch(nullList,0));
    }
    @Test
    public void testFoundCases(){
        qwe
    }
}


