import java.util.*;
import java.io.*;

public class p13335{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        Queue <int []> bridge = new LinkedList<>();
        Deque <Integer> truck = new LinkedList<>();
        
        int currentTime = 0;
        int time = 0;
        int weightOntheBridge = 0;

        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]); // 다리의 길이
        int l = Integer.parseInt(input[2]); // 다리의 하중
        String input_[] = br.readLine().split(" ");

        for(int i = 0 ; i < input_.length; i++){
            truck.add(Integer.parseInt(input_[i]));
        }

        while(!truck.isEmpty() || !bridge.isEmpty()){
            boolean check = false;
            
            if(!truck.isEmpty()){
                check = true;
            }

            if(check){
                int t = truck.poll();
                weightOntheBridge += t;

                if(weightOntheBridge < l){
                    bridge.add(new int[] {t, currentTime});
                }else{
                    int current [] = bridge.poll();

                    weightOntheBridge -= current[0];

                }


            }
            else{

            }

            currentTime++;
        }
        
        System.out.println(currentTime);
    }
}