import java.io.*;
import java.util.*;

public class Sudoku {
    public static void display(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int arr[][], int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[r][i]  == num)
                return false;
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (arr[i][c]  == num)
                return false;
        }

        // mat
        r = (r / 3) * 3;
        c = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[r + i][c + j]  == num)
                    return false;
            }
        }

        return true;
    }

    

    public static boolean solveSudoku(int[][] arr, ArrayList<Integer> emptyIndex, int idx) {
        // base case (when idx = empty index Al size)
        if (idx == emptyIndex.size()) {
            display(arr);
            return true;
        }
        // find cell
        int cell = emptyIndex.get(idx);
        int r = cell / 9;
        int c = cell % 9;
        for (int num = 1; num <= 9; num++) {
            if( isValid(arr, r, c, num)){
         
            // agr true aaya to place
            arr[r][c] = num;

            if (solveSudoku(arr, emptyIndex, idx + 1))
                return true;
            arr[r][c] = 0;
        }
    }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> emptyIndex = new ArrayList<>();
        int[][] arr = {{3, 0, 0, 0, 0, 0, 0, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               
                if (arr[i][j] == 0)
                    emptyIndex.add(i * 9 + j);
            }
        }

        solveSudoku(arr, emptyIndex, 0);
    }
}