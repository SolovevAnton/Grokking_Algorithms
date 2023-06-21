package com.solovev;

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
        ThreadLocalRandom random = ThreadLocalRandom.current();
        random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE);

        System.out.println( "Hello World!" );
    }
}
