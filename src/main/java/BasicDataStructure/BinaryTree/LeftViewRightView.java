package BasicDataStructure.BinaryTree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class LeftViewRightView {

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


    public static void printLeftView(Node root)
    {
        ArrayList<Node> listl = new ArrayList<>();
        printLeftViewUntil(root, listl, 0);
        System.out.println("Left View of a Tree");
        for(Node curr:listl)
        {
            System.out.println(curr.data);
        }

    }

    public static void printRightView(Node root)
    {
        ArrayList<Node> list = new ArrayList<>();
        printRightViewUntil(root, list, 0);
        System.out.println("Right View of a Tree");
        for(Node curr:list)
        {
            System.out.println(curr.data);
        }

    }
    public static void printLeftViewUntil(Node root, ArrayList<Node> listl,int level)
    {
        //Pre Order
        if(root==null)
        {
            return;
        }
        //if(listl.get(level)==null)
        if(listl.size()==level)
        {
            listl.add(root);
        }
        printLeftViewUntil(root.left,listl,level+1);
        printLeftViewUntil(root.right,listl,level+1);

    }

    public static void printRightViewUntil(Node root, ArrayList<Node> list,int level)
    {
        //Reverse Pre Order
        if(root==null)
        {
            return;
        }
        //if(listl.get(level)==null)
        if(list.size()==level)
        {
            list.add(root);
        }
        printRightViewUntil(root.right,list,level+1);
        printRightViewUntil(root.left,list,level+1);

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
        printLeftView(root);
        printRightView(root);


    }

}
/*
* 19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Left View of a Tree
50
25
12
30
Right View of a Tree
50
75
87
70*/