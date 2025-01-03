import java.util.*;
import java.io.*;

public class p31472 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        int N = Integer.parseInt(br.readLine());

        double square =(double)N * 2;

        double result = Math.sqrt(square) * 4;

        System.out.print((int)result);

    }
}