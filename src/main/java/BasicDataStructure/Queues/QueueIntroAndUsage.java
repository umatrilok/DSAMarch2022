package BasicDataStructure.Queues;

import java.util.*;

        import java.lang.*;
        import java.io.*;

class QueueIntroAndUsage
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Queue< Integer> q = new ArrayDeque< >();
        q.add(10);
        System.out.println(q + "->" + q.peek() + " " + q.size());
        q.add(20);
        System.out.println(q + "->" + q.peek() + " " + q.size());
        q.add(30);
        System.out.println(q + "->" + q.peek() + " " + q.size());
        q.add(40);
        System.out.println(q + "->" + q.peek() + " " + q.size());
        q.remove();
        System.out.println(q + "->" + q.peek() + " " + q.size());
        q.remove();
        System.out.println(q + "->" + q.peek() + " " + q.size());
        q.remove();
        System.out.println(q + "->" + q.peek() + " " + q.size());
        q.remove();
        System.out.println(q + "->" + " " + q.size());
    }
}
/*
[10]->10 1
[10, 20]->10 2
[10, 20, 30]->10 3
[10, 20, 30, 40]->10 4
[20, 30, 40]->20 3
[30, 40]->30 2
[40]->40 1
[]-> 0*/