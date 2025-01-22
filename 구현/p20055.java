import java.util.*;
import java.io.*;

public class p20055 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int size = 2 * N;
        int count = 0;
        int result = 0;
        int con[] = new int [size];
        String input_[] = br.readLine().split(" ");
        for(int i = 0 ; i < size; i ++){
            con[i] = Integer.parseInt(input_[i]);
        }

        while(K != count){
            
            for(int i = 0 ; i < size; i++){
                
                if(con[i] > 0){
                    con[i] = con[i] - 1;
                }
                if(con[i] == 0){
                    count++;
                }
                if(i == size -1 ){ // 마지막 칸
                    if(con[i] > 1){
                        result += con[i] -1;
                        con[i] = 1;
                    }
                    if(con[i] == 0){
                        if(i == size - 2){
                            result += con[i] -1;
                            con[i] = 1;
                        }
                    }
                }

                if (K == count){
                    break;
                }
                result++;
                //System.out.println(result + " " + con[i]);
            }
        }
        System.out.println(result);
    }
}