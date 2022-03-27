package AdvancedDataStructure.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.io.*;


public class MedianPriorityQueue {

     PriorityQueue<Integer> left;
     PriorityQueue<Integer> right;
    MedianPriorityQueue()
    {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();

    }



    public static void solve(int[] arr, int k) {
        //if we remove anything from PriorityQueue, bydefault min value will be removed

    }
    public void add(int val)
    {
        if(right.size()>0 && right.peek()<val)
        {
            right.add(val);
        }
        else{
            left.add(val);
        }

        //balance
        if(left.size()-right.size()==2)
        {
            right.add(left.remove());
        }
        else if(right.size()-left.size()==2)
        {
            left.add(right.remove());
        }
    }

    public int remove()
    {
        if(left.size()==0&&right.size()==0)
        {
            System.out.println("Underflow");
            return -1;
        }
        else if(right.size()>left.size())
        {
            return right.remove();
        }
        else{
            return left.remove();
        }
    }
    public int peek()
    {
    //finish this code//completed
        if(left.size()==0&&right.size()==0)
        {
            System.out.println("Underflow");
            return -1;
        }
        else if(right.size()>left.size())
        {
            return right.peek();
        }
        else{
            return left.peek();
        }

    }
    public int size()
    {

        return left.size()+ right.size();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
               int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
/*
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit20
30
30
20
20
40
40
10
10
50*/