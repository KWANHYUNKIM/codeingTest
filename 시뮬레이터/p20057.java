import java.util.*;
import java.io.*;

public class p20057{
    static int size;
    static int matrix[][];
    static int dx [] ={0, 1, 0, -1 }; // (왼쪽 (0번), 아래쪽 (1번), 오른쪽 (2번), 위쪽 (3번))
    static int dy [] = {-1, 0, 1, 0};

    static int start_x,start_y;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());

        start_x = size / 2;
        start_y = size /2;
        matrix = new int [size][size];
        
        for(int i = 0 ; i < size ; i++){
            String input[] = br.readLine().split(" ");
            for(int j = 0 ; j < size; j++){
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        direction();

        for(int i = 0 ; i < size; i++){
            for(int j = 0 ; j < size; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
    static void direction(){
        int x = start_x;
        int y = start_y;
        int dir = 0; // 0 : 좌 , 1 : 하, 2: 우, 3: 상
        int move_count = 1;
        int count = 1;

        matrix[x][y] = count;
        boolean check = true;
        while(check){
            for(int i = 0 ; i < 2; i++){
                for(int j = 0 ; j < move_count; j++){
                    x += dx[dir];
                    y += dy[dir];
                    count++;

                    if(x >= 0 && x < size && y>=0 && y < size){
                        matrix[x][y] = count;
                    }

                    if( x == 0 && y == 0){
                        check = false;
                        return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            move_count ++;
        }
    }
}