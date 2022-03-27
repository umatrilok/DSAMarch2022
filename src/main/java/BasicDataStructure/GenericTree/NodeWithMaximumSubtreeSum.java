package BasicDataStructure.GenericTree;
import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Stack;

public class NodeWithMaximumSubtreeSum {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    static int maxNode;
    static int maxSum;

    public static int sum(Node root)
    {
        int ans=0;

        for(Node child:root.children)
        {
            ans+=sum(child);
        }
        //System.out.println(root.data+":"+ans);
        ans=ans+ root.data;

       // System.out.println(root.data+":"+ans);
        if(ans>maxSum)//&& root.data!=100)
        {
            maxNode=root.data;
            maxSum=ans;
        }
        //System.out.println(maxSum);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        maxNode=0;
        maxSum=Integer.MIN_VALUE;
        System.out.println("total Sum:"+sum(root));

        System.out.println(maxNode+"@"+maxSum);
    }

}