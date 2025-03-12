import java.util.*;
import java.io.*;

public class p13116{
    static int T;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < T; i++){
            String input[] = br.readLine().split(" ");
            int K = 0;
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            while(a != b){

                if(a > b){
                    a = a / 2;
                }
                else if( b > a){
                    b = b / 2;
                }
            }

            System.out.println(10 * a);
        }
    }
}