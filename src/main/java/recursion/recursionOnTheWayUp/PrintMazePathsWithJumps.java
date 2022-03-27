package recursion.recursionOnTheWayUp;


import java.io.*;
        import java.util.*;

public class PrintMazePathsWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePathsWithJumps(1, 1, n, m,"");


    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    //psf - path so far
    public static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String psf) {

        if(sr==dr && sc==dc)
        {
            System.out.println(psf);
            return;
        }
        if(sr>dr||sc>dc)
        {
            return;
        }
        for(int hjumps=1;sc+hjumps<=dc;hjumps++) {
            printMazePathsWithJumps(sr, sc + hjumps, dr, dc, psf + "h"+hjumps);
        }
        for(int vjumps=1;sr+vjumps<=dr;vjumps++) {
            printMazePathsWithJumps(sr + vjumps, sc, dr, dc, psf + "v"+vjumps);
        }
        for(int djumps=1;sc+djumps<=dc && sr+djumps<=dr;djumps++) {
            printMazePathsWithJumps(sr + djumps, sc+djumps, dr, dc, psf + "d"+djumps);
        }
    }



}