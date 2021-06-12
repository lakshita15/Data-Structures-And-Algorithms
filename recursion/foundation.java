import java.io.*;
import java.util.*;

public class foundation {

    public static Scanner scn = new Scanner(System.in);

    public static void printDec(int a, int b) {
        if (a == b + 1)
            return;
        printDec(a + 1, b);
        System.out.print(a + " ");
    }

    public static void printinc(int a, int b) {
        if (a == b + 1)
            return;
        System.out.print(a + " ");
        printinc(a + 1, b);
    }

    public static void printincDec(int a, int b) {
        if (a == b + 1)
            return;

        System.out.print(a + " ");
        printincDec(a + 1, b);
        System.out.print(a + " ");
    }

    public static void printEvenOdd(int a, int b) {
        if (a > b)
            return;
        if (a % 2 == 0)
            System.out.println(a);
        printEvenOdd(a + 1, b);
        if (a % 2 != 0)
            System.out.println(a);
    }

    public static int factorial(int a) {

        return a == 0 ? 1 : factorial(a - 1) * a;

    }

    public static int power(int a, int b) {
        return b == 0 ? 1 : power(a, b - 1) * a;
    }

    public static int power1(int a, int b) {
        if (b == 0)
            return 1;
        int smallAns = power(a, b - 1);
        return smallAns * a;
    }

    public static int powerBtr(int a, int b) {
        if (b == 0)
            return 1;
        int smallAns = powerBtr(a, b / 2);
        smallAns *= smallAns;
        return b % 2 != 0 ? smallAns * a : smallAns; // in case the power is odd just multiply with an "a"
    }

    public static void display(int[] arr, int idx) {
        if (idx == arr.length)
            return;

        System.out.print(arr[idx] + " ");
        display(arr, idx + 1);
    }

    public static void displayReverse(int[] arr, int idx) {
        if (idx == arr.length)
            return;

        displayReverse(arr, idx + 1);
        System.out.print(arr[idx] + " ");
    }

    public static int maximum(int[] arr, int idx) {
        if (idx == arr.length)
            return (int) -1e9;
        int maxSF = maximum(arr, idx + 1);
        return Math.max(maxSF, arr[idx]);

        // if(idx == arr.length)
        // return (int)-1e9;

        // int msf = maximum(arr , idx+1);
        // if(msf < arr[idx]){
        // return arr[idx];
        // }
        // return msf;

    }

    public static int minimum(int[] arr, int idx) {
        if (idx == arr.length)
            return (int) 1e9;
        int minSF = minimum(arr, idx + 1);
        return Math.min(minSF, arr[idx]);

    }

    public static boolean find(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return false;
        return arr[idx] == data || find(arr, idx + 1, data);
    }

    public static int firstIndex(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;

        if (arr[idx] == data)
            return idx;
        return firstIndex(arr, idx + 1, data);

        // return arr[idx] == data ? idx : firstIndex(arr,idx +1 ,data);
    }

    public static int lastIndex(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;
        int smallRes = lastIndex(arr, idx + 1, data);
        if (smallRes != -1)
            return smallRes;

        return arr[idx] == data ? idx : -1;
    }

    public static int[] allIndex(int[] arr, int idx, int data, int count) {
        if (idx == arr.length) {
            int[] base = new int[count];
            return base;

        }

        if (arr[idx] == data)
            count++;
        int[] ans = allIndex(arr, idx + 1, data, count);
        if (arr[idx] == data)
            ans[count - 1] = idx;

        return ans;
    }

    public static ArrayList<String> subSeq(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = subSeq(str, idx + 1);
        ArrayList<String> myAns = new ArrayList<>(recAns);
        for (String s : recAns)
            myAns.add(str.charAt(idx) + s);

        return myAns;
    }

    // public static ArrayList<String> getKPC(String str) {

    // }
    // top to bottom
    public static ArrayList<String> mazepath_HVD(int sr, int sc, int er, int ec) {

        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        // Vertical jump
        if (sr + 1 <= er) {
            ArrayList<String> verticalans = mazepath_HVD(sr + 1, sc, er, ec);
            if (verticalans.size() > 0) {
                for (int i = 0; i < verticalans.size(); i++) {
                    ans.add('V' + verticalans.get(i));
                }
            }
        }
        // horizontal jump
        if (sc + 1 <= ec) {
            ArrayList<String> horizontal = mazepath_HVD(sr, sc + 1, er, ec);
            // if (horizontal.size() > 0) {
            // for (int i = 0; i < horizontal.size(); i++) {
            // ans.add('H' + horizontal.get(i)); //make apna ans by adding it to ans vali
            // }
            // }
            for (String s : horizontal) {
                ans.add("H" + s);
            }
        }
        // diagonal jump
        if (sr + 1 <= er && sc + 1 <= ec) {
            ArrayList<String> diagonal = mazepath_HVD(sr + 1, sc + 1, er, ec);
            if (diagonal.size() > 0) {
                for (int i = 0; i < diagonal.size(); i++) {
                    ans.add('D' + diagonal.get(i));
                }
            }
        }

        return ans;

    }

    // bottom to top
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        for (int jmp = 1; sc + jmp <= dc; jmp++) {
            printMazePaths(sr, sc + jmp, dr, dc, psf + "h" + jmp);
        }

        for (int jmp = 1; sr + jmp <= dr; jmp++) {
            printMazePaths(sr + jmp, sc, dr, dc, psf + "v" + jmp);
        }

        for (int jmp = 1; sr + jmp <= dr && sc + jmp <= dc; jmp++) {
            printMazePaths(sr + jmp, sc + jmp, dr, dc, psf + "d" + jmp);
        }
    }

    // give count of limited jumps
    public static int mazepath_HVD(int sr, int sc, int er, int ec, String ans, ArrayList<String> res) {
        if (sr == er && sc == ec) {
            res.add(ans);
            return 1;
        }

        int cnt = 0;

        if (sr + 1 <= er)
            cnt += mazepath_HVD(sr + 1, sc, er, ec, ans + 'V', res);

        if (sc + 1 <= ec)
            cnt += mazepath_HVD(sr, sc + 1, er, ec, ans + 'H', res);

        if (sr + 1 <= er && sc + 1 <= ec)
            cnt += mazepath_HVD(sr + 1, sc + 1, er, ec, ans + 'D', res);

        return cnt;

    }

    public static ArrayList<String> mazepath_Multi_HVD(int sr, int sc, int er, int ec) {

        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; sr + i <= er; i++) {
            ArrayList<String> recans = mazepath_Multi_HVD(sr + i, sc, er, ec);
            if (recans.size() > 0) {
                for (int j = 0; j < recans.size(); j++) {
                    ans.add("V" + i + recans.get(j));
                }
            }
        }

        for (int i = 1; sc + i <= ec; i++) {
            ArrayList<String> recans = mazepath_Multi_HVD(sr, sc + i, er, ec);
            if (recans.size() > 0) {
                for (int j = 0; j < recans.size(); j++) {
                    ans.add("H" + i + recans.get(j));
                }
            }
        }

        for (int i = 1; sc + i <= ec && sr + i <= er; i++) {
            ArrayList<String> recans = mazepath_Multi_HVD(sr + i, sc + i, er, ec);
            if (recans.size() > 0) {
                for (int j = 0; j < recans.size(); j++) {
                    ans.add("D" + i + recans.get(j));
                }
            }
        }

        return ans;

    }

    public static int mazepath_Multi_HVD(int sr, int sc, int er, int ec, String ans, ArrayList<String> res) {
        if (sr == er && sc == ec) {
            res.add(ans);
            return 1;
        }
        int cnt = 0;
        for (int i = 1; sr + i <= er; i++)
            cnt += mazepath_Multi_HVD(sr + i, sc, er, ec, ans + "V" + i, res);

        for (int i = 1; sc + i <= ec; i++)
            cnt += mazepath_Multi_HVD(sr, sc + i, er, ec, ans + "H" + i, res);

        for (int i = 1; sc + i <= ec && sr + i <= er; i++)
            cnt += mazepath_Multi_HVD(sr + i, sc + i, er, ec, ans + "D" + i, res);

        return cnt;

    }

    public static int mazePath_HVD_2(int sr, int sc, int er, int ec, int[][] dir, String[] dirS, ArrayList<String> ans,
            String psf) {
        if (sr == er && sc == ec) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if (x >= 0 && y >= 0 && x <= er && y <= ec)
                count += mazePath_HVD_2(x, y, er, ec, dir, dirS, ans, psf + dirS[d]);
        }

        return count;
    }

    public static int floodFill(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS, ArrayList<String> ans,
            String psf) {
        int n = vis.length, m = vis[0].length;

        if (sr == n - 1 && sc == m - 1) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c])
                count += floodFill(r, c, vis, dir, dirS, ans, psf + dirS[d]);

        }

        vis[sr][sc] = false;
        return count;
    }

    public static int floodFill_multi(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS,
            ArrayList<String> ans, String psf) {
        int n = vis.length, m = vis[0].length;

        if (sr == n - 1 && sc == m - 1) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;

        for (int d = 0; d < dir.length; d++)
            for (int rad = 1; rad <= Math.max(n, m); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (!vis[r][c])
                        count += floodFill_multi(r, c, vis, dir, dirS, ans, psf + dirS[d] + rad);
                } else
                    break;
            }

        vis[sr][sc] = false;
        return count;
    }

    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

    public static ArrayList<String> RatInAMaze(int r, int c, int[][] visit, int[][] dir, String[] dirS) {
        int n = visit.length, m = visit[0].length;

        if (r == n - 1 && c == m - 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        visit[r][c] = 0;

        for (int i = 0; i < dir.length; i++) {
            for (int rad = 1; rad <= Math.max(n, m); rad++) {
                int row = r + rad * dir[i][0];
                int col = c + rad * dir[i][1];

                if (row >= 0 && row < n && col >= 0 && col < m && visit[row][col] != 0) {
                    ArrayList<String> recAns = RatInAMaze(row, col, visit, dir, dirS);
                    for (String s : recAns) {
                        myAns.add(dirS[i] + s);
                    }
                } else {
                    break;
                }
            }
        }

        visit[r][c] = 1;
        return myAns;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        if (m[0][0] == 0) {
            return new ArrayList<>();
        }

        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        String[] dirS = { "U", "D", "L", "R" };
        ArrayList<String> ans = RatInAMaze(0, 0, m, dir, dirS);
        Collections.sort(ans);
        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1
    public static int floodFillsm(int sr, int sc, int[][] vis, int[][] dir) {
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
                count += floodFillsm(r, c, vis, dir);

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

        return floodFillsm(1, 1, vis, dir);
    }

    // https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/?ref=rp

    public static class pair {
        String psf = "";
        int len = 0;

        pair(String psf, int len) {
            this.len = len;
            this.psf = psf;
        }
    }

    public static pair longestPath(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS) {
        int n = vis.length, m = vis[0].length;
        if (sr == n - 1 && sc == m - 1) {
            return new pair("", 0);
        }

        vis[sr][sc] = true; // blocked
        pair myAns = new pair("", -1);
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m) {
                if (!vis[r][c]) {
                    pair recAns = longestPath(r, c, vis, dir, dirS);
                    if (recAns.len != -1 && recAns.len + 1 > myAns.len) {
                        myAns.len = recAns.len + 1;
                        myAns.psf = dirS[d] + recAns.psf;
                    }
                }
            }
        }

        vis[sr][sc] = false; // unblocked
        return myAns;
    }

    public static pair shortestPath(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS) {
        int n = vis.length, m = vis[0].length;
        if (sr == n - 1 && sc == m - 1) {
            return new pair("", 0);
        }

        vis[sr][sc] = true; // blocked
        pair myAns = new pair("", (int)1e9);
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m) {
                if (!vis[r][c]) {
                    pair recAns = shortestPath(r, c, vis, dir, dirS);
                    if (recAns.len != (int)1e9 && recAns.len + 1 < myAns.len) {
                        myAns.len = recAns.len + 1;
                        myAns.psf = dirS[d] + recAns.psf;
                    }
                }
            }
        }

        vis[sr][sc] = false; // unblocked
        return myAns;
    }

    public static void longestShortestPath() {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        String[] dirS = { "D", "R", "U", "L" };

        boolean[][] vis = new boolean[3][3];
        // vis[1][1] = vis[1][2] = vis[2][1] = true;

        pair ans = longestPath(0, 0, vis, dir, dirS);
        System.out.println(ans.psf + " @ " + ans.len);
    }


    // =========================================================================

    public static void floodFill() {
        int sr = 0, sc = 0, n = 3, m = 3;
        boolean[][] vis = new boolean[n][m];

        int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
        String[] dirS = { "V", "H", "D" };

        ArrayList<String> ans = new ArrayList<>();

        System.out.println(floodFill_multi(sr, sc, vis, dir, dirS, ans, ""));

        System.out.println(ans);
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

        // int x = 3 , y =3;
        // int[][] dir = {{1,2},{3,2}};
        // System.out.println(FindWays( x , y , dir));
        
        longestShortestPath();
    }

}