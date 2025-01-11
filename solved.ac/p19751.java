import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class p19751 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        List<Integer> result = Arrays.stream(input)
                           .map(Integer::parseInt)
                           .sorted()
                           .collect(Collectors.toList());
        Collections.swap(result , 1, 2);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}