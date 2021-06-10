
import java.util.Scanner;
import java.util.ArrayList;

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
        //     return (int)-1e9;
        
        // int msf = maximum(arr , idx+1);
        // if(msf < arr[idx]){
        //     return arr[idx];
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
        //     arr[i] = scn.nextInt();
        // }
        // display(arr, 0);
        // displayReverse(arr, 0);
        // int max = maximum(arr, 0);
        // System.out.println(max);
        // System.out.println(find(arr, 0, 7));

    }

}