package BasicDataStructure.BinaryTree;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BottomView {

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
    public static class Pair2 {

        int hd;
        Node node;
        Pair2( int hd,Node node) {
            this.node = node;
            this.hd = hd;
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
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Queue<Pair2> q= new ArrayDeque<>();
        Map<Integer,Integer> map= new TreeMap<>();

        q.add(new Pair2(0,root));
        while(!q.isEmpty())
        {
            Pair2 cur=q.remove();
            //if(map.containsKey(cur.hd))
            {
                map.put(cur.hd,cur.node.data);
            }

            //if(cur.node.left!=null)
            {
                q.add(new Pair2(cur.hd-1,cur.node.left));
            }
            //if(cur.node.right!=null)
            {
                q.add(new Pair2(cur.hd+1,cur.node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;

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

        ArrayList<Integer> vec = topView(root);
        for(int x : vec)
            System.out.print(x + " ");
        System.out.println();

    }

}
/*
* 19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
12 25 50 75 87 */