import java.util.*;
import java.io.*;

public class p1331 {
    static int size = 6;
    static int matrix[][] = new int[size][size];
    static boolean visited[][] = new boolean[size][size];
    static int dx[] = {2, 2, -2, -2, 1, 1, -1, -1};
    static int dy[] = {1, -1, 1, -1, 2, -2, 2, -2};
    static int startX;
    static int startY;
    static String location [] = new String[size * size];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean check = true;

        for(int i = 0 ; i < size * size; i++){
            String input = br.readLine();

            char charX = input.charAt(0);
            char charY = input.charAt(1);

            int x = (int) charX - 'A';
            int y = (int) charY - '0' - 1;

            if(i == 0){
                startX = x;
                startY = y;
            }
            else{
                location[i] = input;
            }
        }
        
        check = chess(startX,startY);
        
        if(check){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }
    }
    static boolean chess(int startX, int startY){
        int x = startX;
        int y = startY;
        int index = 1;
        Queue<int []> queue =new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int current[] = queue.poll();
            int X = current[0];
            int Y = current[1];

            if(index == 35){
                return true;
            }

            for(int i = 0 ; i < 8; i++){
                int currentX = X + dx[i];
                int currentY = Y + dy[i];
                
                String checking = location[index];

                char charX = checking.charAt(0);
                char charY = checking.charAt(1);
    
                int arriveX = (int) charX - 'A';
                int arriveY = (int) charY - '0' - 1;
                if(currentX >= 0 && currentY >= 0 && currentX < size && currentY < size && !visited[currentX][currentY] && currentX == arriveX && currentY == arriveY){
                    visited[currentX][currentY] = true;
                    index ++;
                    queue.add(new int[] {currentX,currentY});
                }
            }
        }
        return false;

    }
}