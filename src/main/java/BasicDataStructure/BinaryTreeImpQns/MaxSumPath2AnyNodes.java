package BasicDataStructure.BinaryTreeImpQns;

import BasicDataStructure.BinaryTree.NodeToRootPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MaxSumPath2AnyNodes {
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

        Pair() { }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[]arr) {
        Node root = new Node(arr[0]);

        Stack< Pair>st = new Stack< >();
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
            }
            else if (top.state == 2) {
                //waiting for right child
                top.state++;
                if (arr[idx] != null) {
                    Node rc = new Node(arr[idx]);
                    top.node.right = rc;

                    Pair rcp = new Pair(rc, 1);
                    st.push(rcp);
                }
                idx++;
            }
            else if (top.state == 3) {
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

        String left = (node.left == null) ? "." :  "" + node.left.data;
        String right = (node.right == null) ? "." : "" + node.right.data;

        str = left + str + right;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int max(Node node)
    {
        if(node==null)
        {
            return Integer.MIN_VALUE;
        }
        int max=Integer.MIN_VALUE;
        int left_max=max(node.left);
        int right_max=max(node.right);
        max=Math.max(left_max,right_max);
        max=Math.max(max,node.data);
        return max;
    }

    public static int ltlMaxSum = Integer.MIN_VALUE;




    public static int res;
    static int findMaxUtil(Node node)
    {

        // Base Case
        if (node == null)
            return 0;


        int l = findMaxUtil(node.left);
        int r = findMaxUtil(node.right);

        int max_1_2_nodes = Math.max(Math.max(l, r) + node.data, node.data);
        int max_1_2_3_nodes = Math.max(max_1_2_nodes, l + r + node.data);

        res = Math.max(res, max_1_2_3_nodes);

        return max_1_2_nodes;
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
        findMaxUtil(root);
        System.out.println(res);

    }
}
/*
* 11
10 8 3 n n 5 n n 2 n n
25*/

/*
11
10 8 -3 n n -5 n n 2 n n
20*/