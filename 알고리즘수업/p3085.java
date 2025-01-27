import java.util.*;
import java.io.*;

public class p3085{
    static int N ;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        char matrix[][] = new char[N][N];

        for(int i = 0 ; i < N; i++){
            String input = br.readLine();
            for(int j = 0 ; j < N; j++){
                matrix[i][j] = input.charAt(j);
            }
        }
        int result = matrix_count(matrix);

        if(result == N){
            
        }
        else{
            for(int i = 0; i < N; i++){
                for(int j = 0 ; j < N; j++){
                   int candy = bfs(matrix, i, j);
                   result = Math.max(result, candy);
                   if(result == N){
                    break;
                   }
                }
            }
        }
        System.out.println(result);
    }
    static int bfs(char matrix[][], int x, int y){
        int result = 0;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        
        while(!queue.isEmpty()){
            int current[] = queue.poll();
            int X = current[0];
            int Y = current[1];

            for(int i = 0 ; i < 4; i++){
                int nextX = X + dx[i];
                int nextY = Y + dy[i];
                //System.out.println("x :" + nextX + "y : " + nextY);
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N){
                  //System.out.println("값");
                  int count = swap(matrix,X,Y,nextX,nextY);
                  result = Math.max(result,count);
                }
            }
        }

        return result;
    }
    static int swap(char matrix[][], int x1, int y1, int x2, int y2) {
        // 두 위치의 문자 교환
        char temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    
        int maxConsecutive = 1; 
        
        for(int i = 0; i < N; i++){
            int count = 1; // 연속 길이
            for(int j = 1; j < N; j++){
                if(matrix[i][j] == matrix[i][j - 1]) {
                    count++;
                } else {
                    maxConsecutive = Math.max(maxConsecutive, count);
                    count = 1;
                }
            }
            // 마지막 구간까지 확인
            maxConsecutive = Math.max(maxConsecutive, count);
        }
        
        for(int j = 0; j < N; j++){
            int count = 1;
            for(int i = 1; i < N; i++){
                if(matrix[i][j] == matrix[i - 1][j]) {
                    count++;
                } else {
                    maxConsecutive = Math.max(maxConsecutive, count);
                    count = 1;
                }
            }
            maxConsecutive = Math.max(maxConsecutive, count);
        }
        
        return maxConsecutive;
    }
    static int matrix_count (char matrix[][]){
    
    int maxConsecutive = 1; 
        
    for(int i = 0; i < N; i++){
        int count = 1; // 연속 길이
        for(int j = 1; j < N; j++){
            if(matrix[i][j] == matrix[i][j - 1]) {
                count++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, count);
                count = 1;
            }
        }
        // 마지막 구간까지 확인
        maxConsecutive = Math.max(maxConsecutive, count);
    }
    
    for(int j = 0; j < N; j++){
        int count = 1;
        for(int i = 1; i < N; i++){
            if(matrix[i][j] == matrix[i - 1][j]) {
                count++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, count);
                count = 1;
            }
        }
        maxConsecutive = Math.max(maxConsecutive, count);
    }
    return maxConsecutive;
    }
}