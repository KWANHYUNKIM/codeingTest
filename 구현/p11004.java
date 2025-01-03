import java.util.*;
import java.io.*;

public class p11004 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int size = Integer.parseInt(input[0]);
        int search = Integer.parseInt(input[1]);

        String input_1 [] = br.readLine().split(" ");

        int N[] = new int[size];

        for(int i = 0 ; i < size; i ++){
            N[i] = Integer.parseInt(input_1[i]);
        }

        Arrays.sort(N);

        System.out.println(N[search - 1]);
    }
}