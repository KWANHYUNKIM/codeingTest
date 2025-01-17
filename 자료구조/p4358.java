import java.util.*;
import java.io.*;

public class p4358 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashmap = new HashMap<>();
        int size = 0; // Count of total inputs

        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.trim().isEmpty()) {
                break; // Stop reading on EOF or empty input
            }
            hashmap.put(input, hashmap.getOrDefault(input, 0) + 1);
            size++;
        }

        List<String> keySet = new ArrayList<>(hashmap.keySet());
        Collections.sort(keySet);

        for (String hash : keySet) {
            double cal = ((double) hashmap.get(hash) / (double) size) * 100;
            double result = Math.round(cal * 10000) / 10000.0;
            System.out.println(hash + " " + result);
        }
    }
}
