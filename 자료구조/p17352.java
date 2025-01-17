import java.util.*;
import java.io.*;

class Bridge{
    int start;
    int end;

    public Bridge(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class p17352 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = N - 2;

        LinkedList <Bridge> island = new LinkedList<>();

        if(M > 0){
            for(int i = 0; i < M; i++){
                String input[] = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);

                island.add(new Bridge(start,end));
            }

        }
        else{ // N = 2
            System.out.println("1 2");
        }
    }
}