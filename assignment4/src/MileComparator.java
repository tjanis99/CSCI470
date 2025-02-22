/**********************************************************
 * CSCI 470/502     Assignment 4    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/19/2024.
 * Purpose: Mile comparator to use default java comparisons
 **********************************************************/
import java.util.Comparator;

/*
 * MileComparator.java
 *
 * Compares destinations
 */
public class MileComparator implements Comparator<Destination> {

    @Override
    public int compare(Destination d1, Destination d2) {    //overrides previous comparison statement
        return (d2.getNormalMiles() - d1.getNormalMiles());
    }
}
