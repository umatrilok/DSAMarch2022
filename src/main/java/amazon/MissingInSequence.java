package amazon;

import java.util.*;
        import java.lang.*;
        import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MissingInSequence
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(4);
        sequence.add(5);
        sequence.add(7);
        sequence.add(8);
        int match = 0;
        int first = sequence.get(0); // sets the first value in seq. to var
        int size = sequence.size(); // sets the seq size to var
        for (int i = 0; i < size; i++)
        {
            if ((first + i) != sequence.get(i)) {
                match = (first + i);
                break;
            }
        }
        System.out.println(match + " is not in the sequence.");

    }
}