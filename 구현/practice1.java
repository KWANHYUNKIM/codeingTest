import java.util.*;
import java.io.*;

public class practice1 {
    public static void main(String args[]) throws Exception{
        Integer arr1 [] = {1 ,3 ,5, 1 ,2 ,3 ,4};

        Arrays.sort(arr1);

        for(int i = 0 ; i < arr1.length; i ++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        Arrays.sort(arr1,Collections.reverseOrder());

        for(int i = 0 ; i < arr1.length; i ++){
            System.out.print(arr1[i] + " ");
        }
    }    
}