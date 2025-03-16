import java.util.*;
import java.io.*;

public class p8911{
    static int dx[] = {-1, 0, 1, 0}; // 북 , 동, 남 , 서
    static int dy[] = {0, 1, 0, -1};
    static LinkedList<int []> matrix = new LinkedList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            String input = br.readLine();
            int result = rectangle(input);

            System.out.println(result);
        }
    }
    static int rectangle(String input){
        String s = input;
        int direction = 0; // 북 동 남 서 
        int x = 0;
        int y = 0;
        int MIN_X = 0;
        int MIN_Y = 0;
        int MAX_X = 0;
        int MAX_Y = 0;

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'F'){
                x = x + dx[direction];
                y = y + dy[direction];
            }else if(c == 'B'){
                x = x - dx[direction];
                y = y - dy[direction];
            }else if(c == 'L'){
                if(direction == 0){
                    direction = 3;
                }else{
                    direction = direction - 1;
                }
            }else if(c == 'R'){
                direction = direction + 1;
            }

            if(x > 0){
                MAX_X = Math.max(MAX_X , x);
            }
            if (y > 0){
                MAX_Y = Math.max(MAX_Y, y);
            }
            if(x < 0){
                MIN_X = Math.min(MIN_X, x);
            }
            if(y < 0){
                MIN_Y = Math.min(MIN_Y, y);
            }

            if(direction > 3){
                direction = direction % 4;
            }
        }
        //System.out.println("MAX_X , MIN_X" + MAX_X + " " + MIN_X);
        //System.out.println("MAX_Y , MIN_Y" + MAX_Y + " " + MIN_Y);
        


        return (Math.abs(MAX_X) + Math.abs(MIN_X) ) * (Math.abs(MAX_Y) + Math.abs(MIN_Y));
    }
}