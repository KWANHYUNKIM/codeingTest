import java.util.*;
import java.io.*;

public class p33612{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) -1;
        
        // init
        int year = 2024;
        int month = 8;
        int a = 0;
        int b = 0;


        int add = N * 7;
        month = month + add;
        if(month > 12){
            a = month / 12;
            b = month % 12;

            if(month % 12 == 0){
                a -= 1;
                b = 12;
            }

            year += a;

        }else{
            a = year;
            b = month;
        }
        
        System.out.print(year + " " + b);
    }
}