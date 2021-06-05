

import java.io.*;
import java.util.*;

public class fractionalknapsack {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int vls[] = new int[n];
        for (int i = 0; i < n; i++) {
            vls[i] = scn.nextInt();
        }
        int wts[] = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        System.out.println(fracKnapsack(wts, vls, cap));
    }

    public static class Pair implements Comparable<Pair> {
        int wt, vl;
        double ratio;

        public int compareTo(Pair o) {
            if (o.ratio < this.ratio) {
                return -1;
            } else if (o.ratio == this.ratio) {
                return 0;
            } else {
                return +1;
            } // return o.ratio - this.ratio;
        }
    }
}