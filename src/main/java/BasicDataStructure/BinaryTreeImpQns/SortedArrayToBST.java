package BasicDataStructure.BinaryTreeImpQns;
import java.util.Scanner;

public class SortedArrayToBST {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node construct(int[] inOrder,int si, int ei)
    {
        if(si>ei) return null;
        if(si==ei)return new Node(inOrder[si]);

        int mid=(si+ei)/2;
        Node root = new Node(inOrder[mid]);

        root.left=construct(inOrder,si,mid-1);
        root.right=construct(inOrder,mid+1,ei);

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
        int[] inOrder = new int[n];

        for (int i = 0; i < n; i++) {
            inOrder[i]=sc.nextInt();
        }


        Node root = construct(inOrder,0,inOrder.length-1);
        display(root);

        //System.out.println(res);

    }
}
/*
* 5
-10 -3 0 5 9
-10 <- 0 -> 5
. <- -10 -> -3
. <- -3 -> .
. <- 5 -> 9
. <- 9 -> .*/

/*
8
1 2 3 4 5 6 7 8
2 <- 4 -> 6
1 <- 2 -> 3
. <- 1 -> .
. <- 3 -> .
5 <- 6 -> 7
. <- 5 -> .
. <- 7 -> 8
. <- 8 -> .*/

/*
9
1 2 3 4 5 6 7 8 9
2 <- 5 -> 7
1 <- 2 -> 3
. <- 1 -> .
. <- 3 -> 4
. <- 4 -> .
6 <- 7 -> 8
. <- 6 -> .
. <- 8 -> 9
. <- 9 -> .*/