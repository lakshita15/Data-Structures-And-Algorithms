
import java.io.*;
import java.util.*;

public class Q3getcommonelements2{

public static void main(String[] args) throws Exception {
    
     Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        for (int idx = 0; idx < n1; idx++) {
            arr1[idx] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        for (int idx = 0; idx < n2; idx++) {
            arr2[idx] = scn.nextInt();
        }

    HashMap<Integer, Integer> fmap = new HashMap<>();
    for(int val: arr1){
       if(fmap.containsKey(val)){
         int of = fmap.get(val);
         int nf = of + 1;
         fmap.put(val, nf);
       } else {
          fmap.put(val, 1);
       }
    }

    for(int val: arr2){
       if(fmap.containsKey(val) && fmap.get(val) > 0){
          System.out.println(val);
          fmap.put(val, fmap.get(val) - 1);
       }
    }
 }

}