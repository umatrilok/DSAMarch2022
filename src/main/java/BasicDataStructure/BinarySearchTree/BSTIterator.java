package BasicDataStructure.BinarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {

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

    LinkedList<Node> st;//we can use stack too
    //but we are using LinkedList , because we can use LinkeList as Stack, Queue & ArrayList

    public BSTIterator(Node root)
    {
        this.st=new LinkedList<>();
        addAllLeft(root);
    }
    private void addAllLeft(Node node)
    {
        while(node!=null)
        {
            this.st.addFirst(node);
            node=node.left;
        }
    }
    public int next()
    {
        Node topNode=this.st.removeFirst();
        addAllLeft(topNode.right);
        return topNode.data;
    }
    public boolean hasNext()
    {
        return this.st.size()!=0;
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

        Stack< Pair> st = new Stack< >();
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
        BSTIterator itr= new BSTIterator(root);
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
}
/*
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
12
25
30
37
50
62
70
75
87*/