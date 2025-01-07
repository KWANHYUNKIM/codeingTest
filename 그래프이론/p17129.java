import java.util.*;
import java.io.*;

public class p17129 {
    static char matrix[][];
    static boolean visited[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int count = 3;
    static int distance = 0;
    static int result = 10000;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        matrix = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0;
        int startY = 0;

        for(int i = 0 ; i < N ; i ++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                matrix[i][j] = str.charAt(j);

                if(matrix[i][j] == '2'){
                    startX = i;
                    startY = j;
                }
            }
        }

        if(bfs(startX,startY, N, M)){
            System.out.println("TAK");
            System.out.println(result);
        }
        else{
            System.out.println("NIE");
        }
    }
    static boolean bfs(int x, int y, int N, int M){
        Queue <int []> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int current[] = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0 ; i < 4; i++){
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;

                if(count == 0){
                    return true;
                }

                if(nextX >= 0 && nextX < N && nextY >=0 && nextY < M && !visited[nextX][nextY] && matrix[nextX][nextY] != '1'){
                    visited[nextX][nextY] = true;
                    distance++;
                    queue.add(new int[] {nextX , nextY});

                    if(matrix[nextX][nextY] == '3' || matrix[nextX][nextY] == '4' || matrix[nextX][nextY] == '5'){
                        result = Math.min(result, distance);
                        count--;
                    }
                }
            }
        }
        return false;
    }
}