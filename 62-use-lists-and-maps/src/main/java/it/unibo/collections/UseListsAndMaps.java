package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    
    public static final int ELEMS = 100000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0; i <= 1000; i++){
            //al.add(i,i+1000);
            al.add(i+1000);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> ll = new LinkedList<Integer>(al);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int last = al.get(al.size()-1);
        al.set(al.size()-1, al.get(0));
        al.set(0,last);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.println("[");
        for (Integer integer : al) {
            System.out.print(" "+integer);
        }
        System.out.println(" ]");

         /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

         /*ArrayList*/        
         long time = System.nanoTime();
        for(int i = 0; i < ELEMS; i++){
            al.addFirst(i);
        }

        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        
        System.out.println(
            "Adding "
                + ELEMS
                + " ints to ArrayList: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*LinkedList*/
        time = System.nanoTime();
        for(int i = 0; i < ELEMS; i++){
            ll.addFirst(i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        
        System.out.println(// NOPMD
            "Adding "
                + ELEMS
                + " ints to LinkedList: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

         /*ArrayList*/        
        final int times = 1000;
        int pos = (int) al.size()/2;        

        time = System.nanoTime();
         for(int i = 0; i < times; i++){
            al.get(pos);
         }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        
         System.out.println(// NOPMD
             "Reading element "
                 + ELEMS
                 + " times to ArrayList: "
                 + time
                 + "ns ("
                 + millis
                 + "ms)"
         );

       /*LinkedList*/
       time = System.nanoTime();
       for(int i = 0; i < times; i++){
          ll.get(pos);
       }
      
      time = System.nanoTime() - time;
      millis = TimeUnit.NANOSECONDS.toMillis(time);
      
       System.out.println(// NOPMD
           "Reading element "
               + ELEMS
               + " times to LinkedList: "
               + time
               + "ns ("
               + millis
               + "ms)"
       );
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> hm = new HashMap<String, Long>();
        hm.put("Africa", 1110635000L);
        hm.put("Americas",972005000L);
        hm.put("Antartica",0L);
        hm.put("Asia",4298723000L);
        hm.put("Europe",742452000L);
        hm.put("Oceania",38304000L);

        /*
         * 8) Compute the population of the world
         */
       long poptot = 0;
       for (String cont : hm.keySet()) {
            poptot += hm.get(cont);
       }
        System.out.println("World population: "+poptot);
    }
}
