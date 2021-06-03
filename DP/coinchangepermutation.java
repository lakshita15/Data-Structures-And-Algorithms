
import java.io.*;
import java.util.*;

public class coinchangepermutation {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        System.out.println(coinChangepermutation(coins, tar));
    }

    public static int coinChangepermutation(int coins[], int tar) {
        int dp[] = new int[tar + 1];

        for (int t = 0; t <= tar; t++) {
            if (t == 0) {
                dp[t] = 1;
            } else {
                for (int coin : coins) {
                    if (y >= coin) {
                        dp[t] += dp[t - coin];
                    }
                }
            }
        }

        return dp[tar];
    }
}