package BasicDataStructure.BinaryTreeImpQns;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class CamerasInABinaryTree {
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

    //Binary Tree Construct
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
    static int camera;
    public static int minCamerasNeededinBT(Node node)
    {
        int lc;
        int rc;
        if(node == null)
        {
            return 1;//because null childs are covered
        }
        lc=minCamerasNeededinBT(node.left);
        rc=minCamerasNeededinBT(node.right);

        if(lc==-1||rc==-1)
        {
            System.out.println("Camera Installed at:"+node.data);
            camera++;
            return 0;//children asking for camera, so parent is incrementing camera
        }
        if(lc==0||rc==0)
        {
            return 1;//children has camera, so I am covered
        }
        if(lc ==1||rc==1)
        {
            return -1;//children are covered, Parent(I) need a camera
        }
        return -1;
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

        camera=0;
        System.out.println("Root Covered:"+minCamerasNeededinBT(root));
        System.out.println("Minimum Cameras Needed:"+camera);

    }
}

/*
* 29
1 2 3 n n 4 5 n 6 7 n n 8 n n n 9 10 n n 11 12 n n 13 14 n n n */

/*
* 29
1 2 3 n n 4 5 n 6 7 n n 8 n n n 9 10 n n 11 12 n n 13 14 n n n
2 <- 1 -> 9
3 <- 2 -> 4
. <- 3 -> .
5 <- 4 -> .
. <- 5 -> 6
7 <- 6 -> 8
. <- 7 -> .
. <- 8 -> .
10 <- 9 -> 11
. <- 10 -> .
12 <- 11 -> 13
. <- 12 -> .
14 <- 13 -> .
. <- 14 -> .
Camera Installed at:6
Camera Installed at:2
Camera Installed at:13
Camera Installed at:11
Camera Installed at:9
Root Covered:1
Minimum Cameras Needed:5*/