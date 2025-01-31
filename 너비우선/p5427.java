import java.util.*;
import java.io.*;

public class p5427 {
    static class Node5427{
        int x, y, d;
        char mark;

        Node5427(int x, int y, int d, char mark){
            this.x = x;
            this.y = y;
            this.d = d;
            this.mark = mark;
        }
    }

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- != 0){
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // w (열)
            int M = Integer.parseInt(input[1]); // h (행)

            char matrix[][] = new char[M][N];
            boolean visited[][] = new boolean[M][N];
            Queue<Node5427> fireQueue = new LinkedList<>();
            Queue<Node5427> personQueue = new LinkedList<>();

            for(int i = 0 ; i < M; i++){
                String line = br.readLine();
                for(int j = 0 ; j < N; j++){
                    matrix[i][j] = line.charAt(j);
                    if(matrix[i][j] == '*'){
                        fireQueue.add(new Node5427(i, j, 0, '*'));
                    }
                    else if(matrix[i][j] == '@'){
                        personQueue.add(new Node5427(i, j, 0, '@'));
                        visited[i][j] = true;
                    }
                }
            }

            int result = bfs(matrix, fireQueue, personQueue, visited, N, M);

            if(result == -1){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(result);
            }
        }
    }

    static int bfs(char matrix[][], Queue<Node5427> fireQueue, Queue<Node5427> personQueue, boolean visited[][], int N, int M){
        while(!personQueue.isEmpty()){
            // 먼저 불을 확산시킵니다.
            int fireSize = fireQueue.size();
            for(int i = 0; i < fireSize; i++){
                Node5427 fire = fireQueue.poll();
                for(int d = 0; d < 4; d++){
                    int nextX = fire.x + dx[d];
                    int nextY = fire.y + dy[d];
                    if(nextX >= 0 && nextX < M && nextY >=0 && nextY < N){
                        if(matrix[nextX][nextY] == '.' || matrix[nextX][nextY] == '@'){
                            matrix[nextX][nextY] = '*';
                            fireQueue.add(new Node5427(nextX, nextY, fire.d + 1, '*'));
                        }
                    }
                }
            }

            int personSize = personQueue.size();
            for(int i = 0; i < personSize; i++){
                Node5427 person = personQueue.poll();

                if(person.x == 0 || person.x == M-1 || person.y == 0 || person.y == N-1){
                    return person.d + 1;
                }

                for(int d = 0; d < 4; d++){
                    int nextX = person.x + dx[d];
                    int nextY = person.y + dy[d];

                    if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N){
                        return person.d + 1;
                    }

                    if(nextX >=0 && nextX < M && nextY >=0 && nextY < N){
                        if(!visited[nextX][nextY] && matrix[nextX][nextY] == '.'){
                            visited[nextX][nextY] = true;
                            personQueue.add(new Node5427(nextX, nextY, person.d + 1, '@'));
                        }
                    }
                }
            }
        }

        return -1; 
    }
}
