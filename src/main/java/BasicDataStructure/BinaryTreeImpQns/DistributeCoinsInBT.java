package BasicDataStructure.BinaryTreeImpQns;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class DistributeCoinsInBT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair() {
        }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    //Binary Tree Construct
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);

        Stack<Pair> st = new Stack<>();
        Pair root_pair = new Pair(root, 1);

        st.push(root_pair);
        int idx = 1;

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {
                //waiting for left child
                top.state++;
                if (arr[idx] != null) {
                    Node lc = new Node(arr[idx]);
                    top.node.left = lc;

                    Pair lcp = new Pair(lc, 1);
                    st.push(lcp);
                }
                idx++;
            } else if (top.state == 2) {
                //waiting for right child
                top.state++;
                if (arr[idx] != null) {
                    Node rc = new Node(arr[idx]);
                    top.node.right = rc;

                    Pair rcp = new Pair(rc, 1);
                    st.push(rcp);
                }
                idx++;
            } else if (top.state == 3) {
                st.pop();
            }
        }
        return root;

    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = " <- " + node.data + " -> ";

        String left = (node.left == null) ? "." : "" + node.left.data;
        String right = (node.right == null) ? "." : "" + node.right.data;

        str = left + str + right;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    static int moves;

    public static int minMovesNeeded(Node node) {
       int lc;
       int rc;
        if(node==null)
        {
            return 0;
        }
        lc=minMovesNeeded(node.left);
        rc=minMovesNeeded(node.right);

        moves+=Math.abs(lc)+Math.abs(rc);
        return lc+rc+(node.data-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        display(root);

        moves = 0;
        System.out.println("Root Covered:" + minMovesNeeded(root));
        System.out.println("No.of Moves needed:" + moves);

    }
}
/*
*
15
0 0 4 n n 0 n n 0 3 n n 0 n n
0 <- 0 -> 0
4 <- 0 -> 0
. <- 4 -> .
. <- 0 -> .
3 <- 0 -> 0
. <- 3 -> .
. <- 0 -> .
Root Covered:0
No.of Moves needed:8*/