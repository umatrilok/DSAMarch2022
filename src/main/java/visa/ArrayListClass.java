package visa;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListClass {
    public static void main(String[] args) {

        //Java Collection means a single unit of objects.
        //Java Collection framework provides many interfaces(Set, List, Queue, Deque) and
        //classes(ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet)

        List a = new ArrayList();
        a.add("Neethu");
        a.add("Uma");
        a.add("Uma");
        a.forEach(System.out::println);
        System.out.println("\n");


        List b= new LinkedList();
        b.add("two");
        b.add("one");
        b.add("one");
        b.forEach(System.out::println);
        System.out.println("\n");

        //list data structure------->1)array list and 2)linked list
        //ArrayList class---all elements of an ArrayList are stored in a Java array
        //               ---an ArrayList named words has its underlying array of the size n
        //LinkedList---Internally, it is implemented using Doubly Linked List Data Structure.
        // It supports duplicate elements. It stores or maintains it's elements in Insertion order.
        // We can add any number of null elements. Linked List contains a link element called first.
        // Each link carries a data field(s) and a link field called next

        Set s = new HashSet();//Unordered & unsorted
        s.add("Pinky");
        s.add("Pinky");
        s.forEach(System.out::println);

        Set t = new TreeSet();//Unordered & sorted
        t.add(89);
        t.add(20);
        t.add(1);
        t.add(5);
        t.add(5);
        t.forEach(System.out::println);

        //List b = new List();
        //Hash set and tree set both belong to the collection framework.
        // HashSet is the implementation of the Set interface where as Tree set implements sorted set.
        //Tree set is backed by TreeMap while HashSet is backed by a hashmap.
        //The tree set does not allow the null object


        //HashSet is unordered and unsorted Set. LinkedHashSet is the ordered version of HashSet.
        //The only difference between HashSet and LinkedHashSet is that: LinkedHashSet maintains the insertion order
        //Map is not done yet
    }
}
