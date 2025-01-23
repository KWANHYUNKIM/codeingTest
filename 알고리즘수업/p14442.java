import java.util.*;
import java.io.*;

public class p14442 {
    static int N,M;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0 , 0, 1, -1};
    static boolean visited[][];
    static int matrix[][];
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        int barrier = Integer.parseInt(input[2]);

        matrix = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0 ; i < M; i++){
            String input_ = br.readLine();
            for(int j = 0 ; j < N; j++){
                matrix[i][j] = input_.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0, barrier);

        System.out.println(result);
    }
    public static int bfs(int x, int y, int barrier){
        Deque <int[]> dq = new LinkedList<>();
        dq.add(new int[] {x, y, 0, barrier});
        visited[x][y] = true;

        while(!dq.isEmpty()){
            int current[] = dq.poll();

            int X = current[0];
            int Y = current[1];
            int dist = current[2];
            int barriers = current[3];

            if(X == M -1 && Y == N -1){
                return dist;
            }

            for(int i = 0 ; i < 4; i++){
                int currentX = X + dx[i];
                int currentY = Y + dy[i];

                if(currentX >= 0 && currentX < M && currentY >= 0 && currentY < N && !visited[currentX][currentY]){
                    if(matrix[currentX][currentY] == 0){
                        visited[currentX][currentY] = true;
                        dq.addFirst(new int[] {currentX , currentY, dist + 1, barriers});
                    }
                    else if(matrix[currentX][currentY] == 1 && barriers > 0){
                        dq.addLast(new int[] {currentX, currentY, dist + 1, barriers -1});
                    }
                }
            }

        }

        return -1;
    }
}