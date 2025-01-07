import java.util.*;
import java.io.*;

public class p1991 {
    static class Node {
        String left, right;

        Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<String, Node> tree = new HashMap<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            String root = input[0];
            String left = input[1];
            String right = input[2];

            tree.put(root, new Node(left, right));
        }

        StringBuilder preOrderResult = new StringBuilder();
        StringBuilder inOrderResult = new StringBuilder();
        StringBuilder postOrderResult = new StringBuilder();

        preOrder("A", preOrderResult);
        inOrder("A", inOrderResult);
        postOrder("A", postOrderResult);

        System.out.println(preOrderResult.toString());
        System.out.println(inOrderResult.toString());
        System.out.println(postOrderResult.toString());
    }

    static void preOrder(String current, StringBuilder result) {
        if (current.equals(".")) return;
        result.append(current);
        preOrder(tree.get(current).left, result);
        preOrder(tree.get(current).right, result);
    }

    static void inOrder(String current, StringBuilder result) {
        if (current.equals(".")) return;
        inOrder(tree.get(current).left, result);
        result.append(current);
        inOrder(tree.get(current).right, result);
    }

    static void postOrder(String current, StringBuilder result) {
        if (current.equals(".")) return;
        postOrder(tree.get(current).left, result);
        postOrder(tree.get(current).right, result);
        result.append(current);
    }
}
