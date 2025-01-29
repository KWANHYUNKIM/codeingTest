import java.util.*;
import java.io.*;

public class p3055{
    static class Node3055{
        int x,y,d;
        char c;
        Node3055(int x, int y, int d, char c){
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
    static int N,M;
    static char matrix[][];
    static boolean visited[][];
    static int dx[] = {1, -1, 0, 0,};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque <Node3055> order = new LinkedList<>();

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        matrix = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i ++){
            String input_ = br.readLine();
            for(int j = 0 ; j < M; j ++){
                matrix[i][j] = input_.charAt(j);
                if(matrix[i][j] == '*'){
                    order.addFirst(new Node3055(i,j,1,'*'));
                }
                else if(matrix[i][j] == 'S'){
                    order.addLast(new Node3055(i,j,1,'S'));
                }
            }
        }
        int result = bfs(order);

        if(result == -1){
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(result);
        }
    }
    static int bfs(Deque<Node3055>queue){
        while(!queue.isEmpty()){
            Node3055 current = queue.poll();
            int X = current.x;
            int Y = current.y;
            int D = current.d;
            char C = current.c;
            
            visited[X][Y] = true;
    
            for(int i = 0 ; i < 4; i ++){
                int nextX = X + dx[i];
                int nextY = Y + dy[i];
        
                if(nextX >= 0 && nextY >=0 && nextX < N && nextY < M && !visited[nextX][nextY]){
                    if(matrix[nextX][nextY] == '.'){
                        visited[nextX][nextY] = true;
                        matrix[nextX][nextY] = C;
    
                        queue.add(new Node3055(nextX,nextY, D+1, C));
                    }
                    if(matrix[nextX][nextY] == 'D' && C == 'S'){
                        return D;
                    }
                }
            }
        }
        return -1;
    }
   
}