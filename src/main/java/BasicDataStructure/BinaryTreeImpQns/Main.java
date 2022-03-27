package BasicDataStructure.BinaryTreeImpQns;

import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class pair{
        int LTMaxSum = -(int)1e9-1;
        int NTLMaxSum = -(int)1e9-1;
    }
    public static pair maxPathSum_(TreeNode root)
    {
        pair myans = new pair();
        if(root == null)
            return myans;
        if(root.left == null && root.right == null)
        {
            myans.NTLMaxSum = root.val;
            return myans;
        }

        pair lp = maxPathSum_(root.left);
        pair rp = maxPathSum_(root.right);

        myans.LTMaxSum = Math.max(lp.LTMaxSum,rp.LTMaxSum);

        if(root.left != null && root.right!=null)
        {
            myans.LTMaxSum = Math.max(myans.LTMaxSum, lp.NTLMaxSum+root.val+rp.NTLMaxSum);
        }
        myans.NTLMaxSum = Math.max(lp.NTLMaxSum,rp.NTLMaxSum) + root.val;
        return myans;
    }

    public static int maxPathSum(TreeNode root) {
        return maxPathSum_(root).LTMaxSum;
    }

    // input_Section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
/*
* 7
1
2
-1
-1
3
-1
-1
6*/
/*
* 31
-12 5 -8 2 -3 -1 -1 -4 -1 -1 6 -1 -1 1 -1 -1 6 3 -1 -1 9 -1 2 4 -1 -1 0 10 -1 -1 -1
24*/

/*
11
1 2 4 -1 -1 -2 -1 -1 3 -1 -1
10*/
/*
*
31
-12 5 -8 2 -3 -1 -1 -4 -1 -1 6 -1 -1 1 -1 -1 6 3 -1 -1 9 -1 2 4 -1 -1 0 10 -1 -1 -1
30*/