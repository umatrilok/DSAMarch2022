package BasicDataStructure.BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class MorrisTraversal {


    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static ArrayList<Integer> inorderMorrisTraversal(Node root)
    {
        Node curr=root;
        ArrayList<Integer> ans = new ArrayList<>();
        while(curr!=null)
        {
            Node left=curr.left;
            if(left==null)
            {
                ans.add(curr.data);
                curr=curr.right;
            }
            else{
                Node rm= rightMost(left,curr);
                if(rm.right==null)//thread creation
                {
                    rm.right=curr;
                    curr=left;
                }
                else{//thread break
                    rm.right=null;
                    ans.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
    public static Node rightMost(Node node,Node curr)
    {
        while(node.right!=null && node.right!=curr)
        {
            node=node.right;
        }
        return node;
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
        //int data = Integer.parseInt(br.readLine());
        Node root = construct(arr);
        System.out.println(inorderMorrisTraversal(root));
        ;
        //System.out.println(x);
    }
}

/*
19
1 2 3 8 n n 9 n n 4 n n 5 6 n n 7 n n
[8, 3, 9, 2, 4, 1, 6, 5, 7]*/
/*
29   
1 2 4 9 10 n n n 8 n n 5 n 6 7 n n n 13 14 15 n 16 n 17 n n n n
[10, 9, 4, 8, 2, 5, 7, 6, 1, 15, 16, 17, 14, 13]*/