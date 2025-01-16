import java.util.*;
import java.io.*;

public class p1406 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);

        int cursor = str.length();

        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M; i++){
            String input[] = br.readLine().split(" ");

            if(input[0].equals("P")){
                sb.insert(cursor, input[1]);
                System.out.println(sb.toString());

                cursor+=1;
            }
            else if(input[0].equals("L")){
                if(cursor > 0){
                    cursor -= 1;
                }
            }
            else if(input[0].equals("D")){
                if(cursor < sb.length()){
                    cursor += 1;
                }
            }
            else if(input[0].equals("B")){
                if (sb != null && cursor - 1 >= 0 && cursor - 1 < sb.length() && sb.charAt(cursor - 1) - '0' > 0) {
                    sb.deleteCharAt(cursor - 1);
                    if(cursor > sb.length()){
                        cursor = sb.length();
                    }
                    System.out.println(sb.toString());
                }
            }
        }
        System.out.println(sb.toString());

    }
}