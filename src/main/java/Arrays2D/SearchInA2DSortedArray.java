package Arrays2D;

// search in 2d sorted array
import java.io.*;
        import java.util.*;

public class SearchInA2DSortedArray {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();
        int[][] arr=new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=scn.nextInt();
            }
        }

        int search_ele=scn.nextInt();


        int row=0;
        int col=n-1;

        while(col>=0 && row<n){
            if(arr[row][col]==search_ele){
                System.out.println(row);
                System.out.println(col);

                return;
            }

            if(arr[row][col]<search_ele){
                //move down
                row++;
            } else {
                //move left
                col--;
            }
        }

        System.out.println("Not Found");
    }

}

