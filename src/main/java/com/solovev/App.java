package com.solovev;

import com.solovev.model.OtherAlgorithms;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(OtherAlgorithms.binarySearch(List.of(1,23,25),25));
    }
}
