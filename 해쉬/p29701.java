import java.util.*;
import java.io.*;

public class p29701 {
    public static void main(String args[]) throws Exception{
        HashMap <String, String> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳
        hashMap.put(".-", "A");
        hashMap.put("-...", "B");
        hashMap.put("-.-.", "C");
        hashMap.put("-..", "D");
        hashMap.put(".", "E");
        hashMap.put("..-.", "F");
        hashMap.put("--.", "G");
        hashMap.put("....", "H");
        hashMap.put("..", "I");
        hashMap.put(".---", "J");
        hashMap.put("-.-", "K");
        hashMap.put(".-..", "L");
        hashMap.put("--", "M");
        hashMap.put("-.", "N");
        hashMap.put("---", "O");
        hashMap.put(".--.", "P");
        hashMap.put("--.-", "Q");
        hashMap.put(".-.", "R");
        hashMap.put("...", "S");
        hashMap.put("-", "T");
        hashMap.put("..-", "U");
        hashMap.put("...-", "V");
        hashMap.put(".--", "W");
        hashMap.put("-..-", "X");
        hashMap.put("-.--", "Y");
        hashMap.put("--..", "Z");

        // 숫자
        hashMap.put(".----", "1");
        hashMap.put("..---", "2");
        hashMap.put("...--", "3");
        hashMap.put("....-", "4");
        hashMap.put(".....", "5");
        hashMap.put("-....", "6");
        hashMap.put("--...", "7");
        hashMap.put("---..", "8");
        hashMap.put("----.", "9");
        hashMap.put("-----", "0");

        // 특수 문자
        hashMap.put("--..--", ",");
        hashMap.put(".-.-.-", ".");
        hashMap.put("..--..", "?");
        hashMap.put("---...", ":");
        hashMap.put("-....-", "-");
        hashMap.put(".--.-.", "@");

        
        int N = Integer.parseInt(br.readLine());

        String input[] = br.readLine().split(" ");

        String result = "";
        for(int i = 0; i < N; i++){
            result += hashMap.get(input[i]);
        }

        System.out.println(result);

    }
}