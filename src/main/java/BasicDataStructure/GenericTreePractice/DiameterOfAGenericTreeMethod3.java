package BasicDataStructure.GenericTreePractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfAGenericTreeMethod3 {
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


public static int[] diameter(Node root)
{
    int mh=-1;//maximum height
    int smh=-1;//second maximum height
    int dia_arr=-1;

    for(Node child:root.children)
    {
        int[] height_dia=diameter(child);
        int rec_h=height_dia[0];

        if(rec_h>mh)
        {
            smh=mh;
            mh=rec_h;
        }else if(rec_h>smh)
        {
            smh=rec_h;
        }
        int rec_dia=height_dia[1];
        dia_arr=Math.max(dia_arr,rec_dia);
    }
    int dia=mh+smh+2;

    dia_arr=Math.max(dia,dia_arr);

    int[] ans= new int[2];
    ans[0]=mh+1;
    ans[1]=dia_arr;
    return ans;
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

        //System.out.println(  diameter(root));
        int[] main_ans=diameter(root);
        System.out.println("diameter:"+main_ans[1]);
    }

}
/*
*
36
10 30 40 70 80 -1 -1 -1 50 60 100 -1 90 -1 -1 -1 -1 91 92 93 98 -1 99 130 -1 -1 100 110 120 -1 -1 -1 -1 -1 -1 -1
diameter:10*/