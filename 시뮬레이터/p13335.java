import java.util.*;
import java.io.*;

public class p13335{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]); // 다리의 길이
        int l = Integer.parseInt(input[2]); // 다리의 하중
        
        String input_[] = br.readLine().split(" ");
        Queue <Integer> trucks = new LinkedList<>();

        for(int i = 0 ; i < input_.length; i++){
            trucks.add(Integer.parseInt(input_[i]));
        }

        Queue <int []> bridge = new LinkedList<>();
        int currentTime = 0;
        int weightOnBridge = 0;


        while(!trucks.isEmpty() || !bridge.isEmpty()){
            currentTime++;

            if (!bridge.isEmpty() && bridge.peek()[1] == currentTime) {
                weightOnBridge -= bridge.poll()[0];
            }

            // 새로운 트럭을 다리에 올릴 수 있는지 확인
            if (!trucks.isEmpty()) {
                int nextTruck = trucks.peek();
                if (weightOnBridge + nextTruck <= l) {
                    trucks.poll();
                    weightOnBridge += nextTruck;
                    bridge.add(new int[]{nextTruck, currentTime + w}); // 트럭의 도착 시간 저장
                }
            }
            
        }
        
        System.out.println(currentTime);
    }
}