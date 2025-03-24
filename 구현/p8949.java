import java.util.*;
import java.io.*;

public class p8949{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();

        int aLength = A.length();
        int bLength = B.length();
        int first = 0 ;
        int middle = 0;
        int end = 0;

        if(aLength > bLength){
            middle = bLength;
            end = aLength;
        }
        else if(aLength < bLength){
            
        }
    }
}