package BasicDataStructure.BinaryTreeImpQns;

import java.util.Scanner;

public class BSTFromPreOrderTraversal {
    static int idx;
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    public  static Node construct(int[] preOrder,int l_bound,int u_bound)
    {
        if(idx>=preOrder.length||preOrder[idx]<l_bound||preOrder[idx]>u_bound)
        {
            return null;
        }
        Node root= new Node(preOrder[idx]);
        idx++;

        root.left=construct(preOrder,l_bound,root.data);
        root.right=construct(preOrder,root.data,u_bound);

        return root;
    }


    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = " <- " + node.data + " -> ";

        String left = (node.left == null) ? "." :  "" + node.left.data;
        String right = (node.right == null) ? "." : "" + node.right.data;

        str = left + str + right;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] preOrder = new int[n];

        for (int i = 0; i < n; i++) {
            preOrder[i]=sc.nextInt();
        }

        idx=0;
        Node root = construct(preOrder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        display(root);
    }
}
/*
8
4 2 1 3 6 5 7 8
2 <- 4 -> 6
1 <- 2 -> 3
. <- 1 -> .
. <- 3 -> .
5 <- 6 -> 7
. <- 5 -> .
. <- 7 -> 8
. <- 8 -> .
*/
