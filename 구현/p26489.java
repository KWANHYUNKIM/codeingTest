import java.util.*;
import java.io.*;

public class p26489 {
    static int result = 0;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        String str = "";

        while((str = br.readLine()) != null){
            
            if(str.contains("gum gum for jay jay")){
                result++;
            }
        }
        System.out.print(result);
    }
}