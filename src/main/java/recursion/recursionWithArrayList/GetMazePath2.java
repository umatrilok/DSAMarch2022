package recursion.recursionWithArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePath2 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList< String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList< String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr>dr || sc>dc )
        {
            ArrayList< String> ba = new ArrayList< >();
            return ba;
        }

        if (sr == dr && sc == dc) {
            ArrayList< String> ba = new ArrayList< >();
            ba.add("");
            return ba;
        }

        ArrayList< String> paths = new ArrayList< >();


        ArrayList< String> hpaths  = getMazePaths(sr, sc + 1, dr, dc);
        for (String hpath : hpaths) {
            paths.add("h" + hpath);
        }

        ArrayList< String> vpaths = getMazePaths(sr + 1, sc, dr, dc);
        for (String vpath : vpaths) {
            paths.add("v" + vpath);
        }
        return paths;
    }

}