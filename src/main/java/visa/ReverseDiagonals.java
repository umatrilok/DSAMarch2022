
package visa;

//https://algorithms.tutorialhorizon.com/print-all-diagonals-of-a-given-matrix/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseDiagonals {
    public static void main(String[] args) {
        int [][] a = {{1,2,3},{4,5,6},{7,8,9}};
        //print(a);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                System.out.print(a[i][j]+" ");

            System.out.println();
        }
        ReverseDiagonals obj= new ReverseDiagonals();
        obj.reverseD(a);

        List<List<Integer>> matrix = new LinkedList<>();
        List<Integer> zero = new ArrayList<>();
        zero.add(1);
        zero.add(2);
        zero.add(3);
        List<Integer> one = new ArrayList<>();
        one.add(4);
        one.add(5);
        one.add(6);
        List<Integer> two = new ArrayList<>();
        two.add(7);
        two.add(8);
        two.add(9);
        matrix.add(0,zero);
        matrix.add(1,one);
        matrix.add(2,two);
        obj.reverseDiagonalInList(matrix);


    }
    void reverseD(int a[][]) {
        System.out.println("Reverse diagonal");
        int col = a.length - 1;
        int row;
        while (col >= 0) {
            int coltemp = col;
            row = 0;
            while (coltemp <= a.length - 1) {
                //System.out.print("[" + row + "][" + coltemp + "]" + a[row][coltemp] + "      ");
                System.out.println(a[row][coltemp]);
                coltemp++;
                row++;

            }


            col--;
        }


        row = 1;
        while (row < a.length) {
            col = 0;
            int rowtemp = row;
            while (rowtemp <= a.length - 1) {
                //System.out.print("[" + rowtemp + "][" + col + "]" + a[rowtemp][col] + "      ");
                System.out.println(a[rowtemp][col]);
                rowtemp++;
                col++;
            }

            row++;
        }
    }

    void reverseDiagonalInList(List<List<Integer>> matrix) {
        System.out.println("Reverse diagonal in List<List<Integer>>");
        int col = matrix.size() - 1;
        int row;
        while (col >= 0) {
            int coltemp = col;
            row = 0;
            while (coltemp <= matrix.size() - 1) {
                //System.out.print("[" + row + "][" + coltemp + "]" + a[row][coltemp] + "      ");
                System.out.println( matrix.get(row).get(coltemp));
                coltemp++;
                row++;

            }


            col--;
        }


        row = 1;
        while (row < matrix.size()) {
            col = 0;
            int rowtemp = row;
            while (rowtemp <= matrix.size() - 1) {
                //System.out.print("[" + rowtemp + "][" + col + "]" + a[rowtemp][col] + "      ");
                System.out.println(matrix.get(rowtemp).get(col));
                rowtemp++;
                col++;
            }

            row++;
        }
    }
}
