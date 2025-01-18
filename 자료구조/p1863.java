import java.util.*;
import java.io.*;

class direction{
    int x;
    int y;
    direction(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class p1863 {
    
    static direction array[];

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        array = new direction[N];

        int maxY = 0;
        int range = 0;

        for(int i = 0 ; i < N; i++){
            String input [] = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            array[i] = new direction(x,y);
        }

        Arrays.sort(array, (a,b) -> Integer.compare(a.x, b.x));

        for(int i = 0 ; i < N; i++){
            int y = array[i].y;
            if(maxY < y){
                maxY = Math.max(maxY, y);
                range = i;
            }
        }

        int count = 0;

        PriorityQueue <Integer> height = new PriorityQueue<>();

        // 왼 -> 오
        for(int i = 0; i <= range; i++ ){
            int currentHeight = array[i].y;

            if(height.isEmpty()){
                height.add(currentHeight);
                count++;
            }
            else{
                if(currentHeight > height.peek()){
                    height.poll();
                    height.add(currentHeight);
                    count++;
                }
            }
        }

        // 오 -> 왼
        height.clear();
        for(int i = N - 1; i >= range; i--){
            int currentHeight = array[i].y;


            if(height.isEmpty()){
                height.add(currentHeight);
                count++;
            }
            else{
                if(currentHeight > height.peek()){
                    height.poll();
                    height.add(currentHeight);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}