import java.util.*;
import java.io.*;

public class p9328{
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int T;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
    
        while(T-- != 0){

            String input[] = br.readLine().split(" ");

            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);

            boolean visited [][] = new boolean [h][w];
            HashSet<Character> keys = new HashSet<>();

            char matrix [][] = new char [h][w];
    
            for(int i = 0 ; i < h; i ++){
                String input_ = br.readLine();
                for(int j = 0 ; j < w; j++){
                    matrix[i][j] = input_.charAt(j);
                }
            }
            
            keys = new HashSet<>();
            String input__ = br.readLine();
    
            if(!input__.equals("0")){
                for(int i = 0 ; i < input__.length(); i++){
                    keys.add(Character.toUpperCase(input__.charAt(i)));
                }
            }
            
    
            Queue<int []> start = new LinkedList<>();


            for(int i = 0 ; i < h; i++){
                for(int j = 0 ; j < w -2; j++){
                    if(i == 0 || i == h - 1){
                        if(matrix[i][j] == '*' && matrix[i][j +1] == '.' && matrix[i][j +2] == '*'){
                            start.add(new int [] {i , j +1});
                        }
                    }
                }
            }

            for(int i = 0 ; i < w; i++){ // 0 ~ 17
                for(int j = 0; j < h -2 ; j++){ // 0 ~ 5
                    if(i == 0 || i == w - 1){
                        if(matrix[i][j] == '*' && matrix[i][j +1] == '.' && matrix[i][j + 2] == '*'){
                            start.add(new int [] { i, j+ 1});
                        }
                    } 
                }
            }

            int result_ = 0;
            while(!start.isEmpty()){
                int s [] = start.poll();
                int startX = s[0];
                int startY = s[1];
                System.out.println("x " + startX + " y " + startY);
                int result = bfs(startX,startY, h, w, visited, matrix, keys);
                result_ = Math.max(result_ , result);
            }
            System.out.println(result_);
        }
    
    }
    static int bfs(int x, int y, int h, int w, boolean visited[][], char matrix[][], HashSet<Character> keys){
        int result = 0;
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {x,y, 0});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int current [] = q.poll();
            int curX = current[0];
            int curY = current[1];
            int curResult = current[2];
            result = Math.max(result,curResult);

            for(int i = 0 ; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < h && nextY < w){
                    if(!visited[nextX][nextY]){
                        if(matrix[nextX][nextY] == '.'){
                            visited[nextX][nextY] = true;
                            q.add(new int[] {nextX,nextY, curResult});
                        }
                        if(matrix[nextX][nextY] >= 'a' && matrix[nextX][nextY] <= 'z'){
                            visited[nextX][nextY] = true;
                            keys.add(Character.toUpperCase(matrix[nextX][nextY]));
                            q.add(new int [] {nextX,nextY, curResult});
                        }

                        if((matrix[nextX][nextY] >= 'A' && matrix[nextX][nextY] <= 'Z')){
                            if(keys.contains(matrix[nextX][nextY]))
                            {
                                visited[nextX][nextY] = true;
                                q.add(new int [] {nextX, nextY, curResult});
                            }
                        }

                        if(matrix[nextX][nextY] == '$'){
                            visited[nextX][nextY] = true;
                            q.add(new int [] {nextX, nextY, curResult +1});
                        }
                    }
                }
            }
        }
        
        return result;
    }
}