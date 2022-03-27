package recursion.recursionWithArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList< String> paths = getMazePaths(0, 0, n-1, m-1);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList< String> getMazePaths(int sr, int sc, int dr, int dc) {


        if (sr == dr && sc == dc) {
            ArrayList< String> ba = new ArrayList< >();
            ba.add("");
            return ba;
        }
        ArrayList< String> paths = new ArrayList<>();
        //we do not need empty ArrayList base case
        //as this controls the tree and it does not grow out of dc
        for(int hjumps=1;sc+hjumps<=dc;hjumps++) {
            ArrayList<String> hpaths = getMazePaths(sr, sc + hjumps, dr, dc);
            for (String s : hpaths) {
                paths.add("h" +hjumps+ s);
            }
        }
        for(int vjumps=1;sr+vjumps<=dr;vjumps++) {
            ArrayList<String> vpaths = getMazePaths(sr + vjumps, sc, dr, dc);
            for (String s : vpaths) {
                paths.add("v" +vjumps+ s);
            }
        }

        for(int djumps=1;sc+djumps<=dc && sr+djumps<=dr;djumps++) {
            ArrayList<String> dpaths = getMazePaths(sr + djumps, sc+djumps, dr, dc);
            for (String s : dpaths) {
                paths.add("d" +djumps+ s);
            }
        }
        return paths;
    }

}