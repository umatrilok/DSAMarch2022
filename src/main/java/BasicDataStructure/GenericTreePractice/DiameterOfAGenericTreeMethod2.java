package BasicDataStructure.GenericTreePractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfAGenericTreeMethod2 {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

static int global_dia;
public static int diameter(Node root)
{
    int mh=-1;//maximum height
    int smh=-1;//second maximum height

    for(Node child:root.children)
    {
        int rec_h=diameter(child);
        if(rec_h>mh)
        {
            smh=mh;
            mh=rec_h;
        }else if(rec_h>smh)
        {
            smh=rec_h;
        }
    }
    int dia=mh+smh+2;

    global_dia=Math.max(dia,global_dia);

    mh=mh+1;

    return mh;
}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here

        System.out.println(  diameter(root));
        System.out.println(global_dia);
    }

}
/*
*
36
10 30 40 70 80 -1 -1 -1 50 60 100 -1 90 -1 -1 -1 -1 91 92 93 98 -1 99 130 -1 -1 100 110 120 -1 -1 -1 -1 -1 -1 -1
6
10*/