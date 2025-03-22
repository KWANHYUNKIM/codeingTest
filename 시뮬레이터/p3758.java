import java.io.*;
import java.util.*;

public class p3758{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- != 0){
            String input[] = br.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]); // 팀의 갯수
            int k = Integer.parseInt(input[1]); // 문제의 개수
            int t = Integer.parseInt(input[2]); // 당신 팀의 ID
            int m = Integer.parseInt(input[3]); // 로그 엔트리의 개수

            int board [][] = new int [n +1][k + 1];
            int count [] = new int[n + 1];
            int time [] = new int[n + 1];
            int sum [] = new int [n+1];
            for(int i = 0 ; i < m; i++){
                String input_[] = br.readLine().split(" ");

                int teamId = Integer.parseInt(input_[0]);
                int questionNumber = Integer.parseInt(input_[1]);
                int questionScore = Integer.parseInt(input_[2]);
                
                if(board[teamId][questionNumber] == 0){
                    board[teamId][questionNumber] = questionScore;
                    sum [teamId] += questionScore;
                    time [teamId] = i;
                    count[teamId]++;
                }else {
                    if(board[teamId][questionNumber] > questionScore){
                    }else{
                        int value = board[teamId][questionNumber];
                        sum[teamId] -= value;
                        sum[teamId] += questionScore;
                        board[teamId][questionNumber] = questionScore;
                    }
                    time[teamId] = i;
                    count[teamId]++;
                }
            }

            int result = n; // 꼴등 시작
            for(int i = 1; i <=n ;i++){

                if(t != i){
                    if(sum[t] > sum[i]){
                        result --;
                    }
                    else if ( ( sum[t] == sum[i] ) && (count[t] < count[i]) ){
                        result --;
                    }else if ( (sum[t] == sum[i]) && (count[t] == count[i]) && (time[t] < time[i])) {
                        result --;
                    }
                }
                
            }
            System.out.println(result);
        }
    }
}