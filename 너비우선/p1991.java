import java.util.*;
import java.io.*;

public class p1991 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Node> tree = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            String root = input[0];
            String left = input[1];
            String right = input[2];

            tree.putIfAbsent(root, new Node(root));
            if (!left.equals(".")) {
                tree.putIfAbsent(left, new Node(left));
                tree.get(root).left = tree.get(left);
            }
            if (!right.equals(".")) {
                tree.putIfAbsent(right, new Node(right));
                tree.get(root).right = tree.get(right);
            }
        }

        Node root = tree.get("A"); // A가 항상 루트라고 가정

        preOrder(root);
        inOrder(root);
        postOrder(root);
    }

    // 전위 순회
    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회
    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    // 후위 순회
    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    // 트리 노드 클래스
    static class Node {
        String value;
        Node left, right;

        Node(String value) {
            this.value = value;
        }
    }
}
