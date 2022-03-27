package BasicDataStructure.Stacks;

import java.io.*;
import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        // nge begin
        int[] nge = new int[arr.length];
        Stack< Integer> st = new Stack<>();
        st.push(arr.length - 1);

        //next greatest element is either infinity or n but not -1
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        // nge end
        int j = 0;
        for (int w = 0; w <= arr.length - k; w++) {

            if (j < w) {//whenever window changes j's work is to point to first index in window
                j = w;
            }

            //window
            while (nge[j] < w + k) {
                j = nge[j];//in every window j should point to max element
            }
            System.out.println(arr[j]);
        }
    }
}
/*9
7
5
2
6
4
3
8
1
5
--------
4-window
--------
7
6
6
8
8
8
*/