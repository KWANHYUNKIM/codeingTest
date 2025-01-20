import java.util.*;
import java.io.*;

public class p2002 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        HashMap <String, Integer> start = new HashMap<>();

        for(int i = 0 ; i < N; i++ ){
            String input = br.readLine();
            start.put(input, i + 1);
        }

        int result = 0;
        // 차량 하나 때문에 번호가 전부 밀린다.
        int index = 1;
        while(N-- != 0){
            String input_ = br.readLine();
            int carOrder = start.get(input_);

            if(carOrder != index - result){
                result++;
                if(N == 0){ // 마지막은 알 수 없다.
                    result--;
                }
            }
            index++;
        }
        
        System.out.println(result);

    }
}