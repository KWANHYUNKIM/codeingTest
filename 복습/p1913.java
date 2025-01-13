// 12월 31일 문제 풀이 이후,
import java.io.*;
import java.util.*;

public class p1913 {
    static int matrix[][];
    static int upX = -1;
    static int upY = 0;
    static int rightX = 0;
    static int rightY = 1;
    static int downX = 1;
    static int downY = 0;
    static int leftX = 0;
    static int leftY = -1;

    static int dx[] = {-1, 0, 1, 1, 0, 0, -1, -1 }; // 위 오 아 아 왼 왼 위 위
    static int dy[] = {0, 1, 0, 0, -1, -1, 0, 0};

    static int testX[];
    static int testY[];

    static int count = 1;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int search = Integer.parseInt(br.readLine());
        matrix = new int [N][N];
        testX = new int [N];
        testY = new int [N];

        int x = N / 2;
        int y = N / 2;


        for(int i = 0 ; i < N; i++){
            
            testX[i] = 
            testY[i] = 
        }


        int currentX = x;
        int currentY = y;

        // 중간 값
        matrix[x][y] = count;

        
        for(int i = 0 ; i < 8; i++){
            currentX = dx[i] + currentX;
            currentY = dy[i] + currentY;
            count++;
            matrix[currentX][currentY] = count;

        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}