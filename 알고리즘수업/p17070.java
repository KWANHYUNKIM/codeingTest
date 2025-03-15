import java.util.*;
import java.io.*;

public class p17070{
    static int N;
    static int matrix[][];
    static int methods[][];
    // 가로
    static int dx_1[] = {0,1};
    static int dy_1[] = {1,1};
    // 세로
    static int dx_2[] = {1,1};
    static int dy_2[] = {0,1};
    // 대각선
    static int dx_3[] = {0,1,1};
    static int dy_3[] = {1,0,1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader  (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        methods = new int[N + 1][N + 1];

        for(int i = 1 ; i <= N; i ++){
            String input[] = br.readLine().split(" ");
            for(int j = 1 ; j <= N; j++){
                matrix[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        bfs(1,2);
        
        System.out.println(methods[N][N]);
    }
    static void bfs(int startX, int startY){
        boolean visited[][] = new boolean [N +1][N+1];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int [] {1 ,1, startX, startY});

        while(!queue.isEmpty()){
            int direction = 0;
            int current [] = queue.poll();
            int prevX = current[0];
            int prevY = current[1];
            int currentX = current[2];
            int currentY = current[3];

            int X = Math.abs(prevX - currentX);
            int Y = Math.abs(prevY - currentY);

            if(Y == 1 && X == 0){
                direction = 1;
            }
            else if(X == 1 && Y == 0){
                direction = 2;
            }
            else if(X == 1 && Y == 1){
                direction = 3;
            }
            if(direction == 1){
                boolean check = true;
                for(int i = 0 ; i < 2; i++){
                        int prevX_ = currentX;
                        int prevY_ = currentY;

                        int nextX = currentX + dx_1[i];
                        int nextY = currentY + dy_1[i];

                        if(nextX >=1 && nextY >=1 && nextX <= N && nextY <= N){
                            if(matrix[nextX][nextY] == 0){
                                if(dx_1[i] == 1 && dy_1[i] == 1 ){
                                    if(matrix[nextX -1][nextY] == 1 || matrix[nextX][nextY -1] == 1){
                                        check = false;
                                    }
                                }
                                if(check){
                                    methods[nextX][nextY]++;
                                    queue.add(new int[] {prevX_,prevY_,nextX,nextY});
                                }
                            }
                        }
                    }
                }

            else if (direction == 2){
                boolean check = true;
                for(int i = 0 ; i < 2; i++){
                    int prevX_ = currentX;
                    int prevY_ = currentY;

                    int nextX = currentX + dx_2[i];
                    int nextY = currentY + dy_2[i];

                    if(nextX >=1 && nextY >=1 && nextX <= N && nextY <= N){
                        if(matrix[nextX][nextY] == 0){
                            if(dx_2[i] == 1 && dy_2[i] == 1 ){
                                if(matrix[nextX -1][nextY] == 1 || matrix[nextX][nextY -1] == 1){
                                    check = false;
                                }
                            }
                            if(check){
                                methods[nextX][nextY]++;
                                queue.add(new int[] {prevX_,prevY_,nextX,nextY});
                            }
                        }
                    }
                }
            }
            else if (direction == 3){
                boolean check = true;
                for(int i = 0 ; i < 3; i++){
                    int prevX_ = currentX;
                    int prevY_ = currentY;

                    int nextX = currentX + dx_3[i];
                    int nextY = currentY + dy_3[i];

                    if(nextX >=1 && nextY >=1 && nextX <= N && nextY <= N){
                        if(matrix[nextX][nextY] == 0){
                            if(dx_3[i] == 1 && dy_3[i] == 1 ){
                                if(matrix[nextX -1][nextY] == 1 || matrix[nextX][nextY -1] == 1){
                                    check = false;
                                }
                            }
                            if(check){
                                methods[nextX][nextY]++;
                                queue.add(new int[] {prevX_,prevY_,nextX,nextY});
                            }
                        }
                    }
                }
            }
        }
    }
}