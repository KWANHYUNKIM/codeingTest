import java.io.*;
import java.util.*;

public class a1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> editor = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            editor.add(ch);
        }

        ListIterator<Character> cursor = editor.listIterator(editor.size());

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            char cmd = command[0].charAt(0);

            switch (cmd) {
                case 'L':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case 'D':
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case 'B':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    cursor.add(command[1].charAt(0));
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : editor) {
            result.append(ch);
        }
        System.out.println(result.toString());
    }
}
