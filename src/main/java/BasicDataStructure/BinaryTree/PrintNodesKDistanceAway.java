package BasicDataStructure.BinaryTree;
import java.io.*;
import java.util.*;

public class PrintNodesKDistanceAway {
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

    public static void printKNodesFar(Node root, int data, int k) {
        // write your code here
        ArrayList<Node> ntr = nodeToRootPath(root,data);
        for(int i=0;i<ntr.size();i++)
        {
            Node blocker = null;
            if(i>0)
            {
                blocker = ntr.get(i-1);
            }
            printKLevelDown(ntr.get(i),k-i,blocker);
        }
    }
    public static void printKLevelDown(Node root, int k, Node blocker)
    {
        if(root==null|| k<0||root==blocker)
        {
            return;
        }
        if(k==0)
        {
            System.out.println(root.data);
            return;
        }
        printKLevelDown(root.left,k-1,blocker);
        printKLevelDown(root.right,k-1,blocker);

    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data){
        //here we need because we are not using arraylist
        if(node==null)
            return new ArrayList<>();

        if(node.data==data)
        {
            ArrayList<Node> ba=new ArrayList<>();
            ba.add(node);
            return ba;

        }
        //for(Node child:node.children)
        //{
            //ArrayList<Node> ans = new ArrayList< >();

            ArrayList<Node> lans = nodeToRootPath(node.left,data);
            if(lans.size()>0)
            {
                lans.add(node);
                return lans;
            }
            ArrayList<Node> rans = nodeToRootPath(node.right,data);
            if(rans.size()>0)
            {
                rans.add(node);
                return rans;
            }
        //}
        return new ArrayList<>();
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

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }
}

/*
* 29
50 75 62 61 63 n n n 60 n n 57 58 59 64 n n 63 n n n n 51 n 91 n 92 n n
57
3
64
63
61
60
51
*/

/*
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2
12
50*/