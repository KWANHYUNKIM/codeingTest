import java.util.*;
import java.io.*;

public class p15552 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            String input[] = br.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int sum = A + B;
            bw.write("Case #" + (i + 1) + ": "  + sum + "\n");
        }
        bw.flush();
        bw.close(); 
    }
}