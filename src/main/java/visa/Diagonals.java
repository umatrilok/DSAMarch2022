package visa;

public class Diagonals {
//https://algorithms.tutorialhorizon.com/print-all-diagonals-of-a-given-matrix/
    public static void print(int [][] a){

        //print first half
        int row =0;
        int col;

        System.out.println("a.length:"+a.length);
        while(row<a.length){
            col =0;
            int rowTemp = row;
            while(rowTemp>=0){
                System.out.print("["+rowTemp+"]["+col+"]"+a[rowTemp][col]+"      ");
                //"["+i+"]["+j+"]"+a[i][j]+"    "
                //a[rowTemp][col]
                rowTemp--;
                col++;
            }
            System.out.println();
            row++;
        }

        //print second half
        col = 1;

        while(col<a.length){
            int colTemp = col;
            row = a.length-1;
            while(colTemp<=a.length-1){
                System.out.print("["+row+"]["+colTemp+"]"+a[row][colTemp]+"      ");
                //a[row][colTemp]
                row--;
                colTemp++;
            }
            System.out.println();
            col++;
        }


        //reverse diagonal
        System.out.println("Reverse diagonal");
        col =a.length-1;
        while (col >= 0)
        {
            int coltemp=col;
            row=0;
            while(coltemp <=a.length-1)
            {
                System.out.print("["+row+"]["+coltemp+"]"+a[row][coltemp]+"      ");
                coltemp++;
                row++;

            }
            System.out.println();
            col --;
        }


        row=1;
        while(row<a.length)
        {
            col=0;
            int rowtemp=row;
            while(rowtemp<=a.length-1)
            {
                System.out.print("["+rowtemp+"]["+col+"]"+a[rowtemp][col]+"      ");
                rowtemp++;
                col++;
            }
            System.out.println();
            row++;
        }

    }

    public static void main(String[] args) {
        int [][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print("["+i+"]["+j+"]"+a[i][j]+"    ");

            System.out.println();
        }
        print(a);

    }
}
