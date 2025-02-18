import java.util.*;
import java.io.*;

public class p5052{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- != 0){
            int N = Integer.parseInt(br.readLine());
            List<String> phoneList = new ArrayList<>();

            for(int i = 0 ; i < N; i++){
                phoneList.add(br.readLine());
            }

            Collections.sort(phoneList);
            boolean isConsistent = true;

            for(int i = 0 ; i < N - 1; i++){
                if(phoneList.get(i + 1).startsWith(phoneList.get(i))){
                    isConsistent = false;
                    break;
                }
            }
            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}