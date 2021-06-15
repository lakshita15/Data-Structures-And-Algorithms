import java.io.*;
import java.util.*;


public class test {
    public static Scanner scn = new Scanner(System.in);
    public static int specialmatrix(int sr, int sc, int[][] vis, int[][] dir) {
        int n = vis.length, m = vis[0].length;

        if (sr == n - 1 && sc == m - 1) {

            return 1;
        }

        int count = 0;
        vis[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && vis[r][c] == 0)
                count += specialmatrix(r, c, vis, dir);

        }

        vis[sr][sc] = 0;
        return count;
    }
    public static int FindWays(int n, int m, int[][] blocked_cells) {

        int[][] vis = new int[m + 1][n + 1];
        for (int[] bc : blocked_cells) {
            vis[bc[0]][bc[1]] = 1; // 1 means blocked
        }

        if (vis[1][1] == 1 || vis[n][m] == 1)
            return 0;

        int[][] dir = { { 1, 0 }, { 0, 1 } };

        return specialmatrix
        (1, 1, vis, dir);
    }
    public static void main(String[] args) {
        // int a = scn.nextInt();
        // int b = scn.nextInt();
        // printDec(a , b);
        // printincDec(a, b);
        // printinc(a, b);
        // printEvenOdd(a, b);
        // System.out.println(factorial(a));

        // input an array
        // int n = scn.nextInt();
        // int[] arr = new int[n];

        // for (int i = 0; i < n; i++) {
        // arr[i] = scn.nextInt();
        // }
        // display(arr, 0);
        // displayReverse(arr, 0);
        // int max = maximum(arr, 0);
        // System.out.println(max);
        // System.out.println(find(arr, 0, 7));

        // ArrayList<String> ans = mazepath_HVD(0, 0, 2, 2);
        // System.out.println("single jump return type ==>" + ans);

        // ArrayList<String> singleJumpResult = new ArrayList<>();
        // int cnt = mazepath_HVD(0, 0, 2, 2, "", singleJumpResult);
        // System.out.print("single jump void type ==> " + cnt + " ==>");
        // System.out.println(singleJumpResult);
        // // multi jump return type
        // ArrayList<String> multiJumpReturn = mazepath_Multi_HVD(0, 0, 2, 2);
        // System.out.println("multi jump return type ==>" + multiJumpReturn);

        // // multi jump void type
        // ArrayList<String> mutliJumpResult = new ArrayList<>();
        // cnt = mazepath_Multi_HVD(0, 0, 2, 2, "", mutliJumpResult);
        // System.out.print("multi jump void type ==> " + cnt + " ==>");
        // System.out.println(mutliJumpResult);

        // multiple jumps using vector theory
        // int sr = 0, sc = 0, er = 2, ec = 2;
        // ArrayList<String> sol = new ArrayList<>();

        // int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 1 }, };
        // String[] dirS = { "V", "H", "D", "E" };
        // System.out.println(mazePath_HVD_2(sr, sc, er, ec, dir, dirS, sol, ""));

        // System.out.println(sol);

        // floodFill();

        // SPECIAL MATRIX

        int x = 3 , y =3;
        int[][] dir = {{1,2},{3,2}};
        System.out.println(FindWays( x , y , dir));
        
        // longestShortestPath();
    }
}
